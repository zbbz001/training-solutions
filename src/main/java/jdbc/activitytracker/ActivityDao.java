package jdbc.activitytracker;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {
    private DataSource dataSource;

    public ActivityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveTrackPoints(Activity activity, PreparedStatement stmt) throws SQLException {
        for (TrackPoint trackPoint : activity.getTrackPointList()) {
            if (trackPoint.isValid()) {
                stmt.setTimestamp(1, Timestamp.valueOf(trackPoint.getTime()));
                stmt.setDouble(2, trackPoint.getLat());
                stmt.setDouble(3, trackPoint.getLon());
                stmt.setLong(4, activity.getId());
                stmt.executeUpdate();
            } else {
                throw new IllegalStateException("Invalid GPS coordinate");
            }
        }
    }


    public Activity saveActivity(Activity activity) {
        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmtActivity = conn.prepareStatement(
                    "INSERT INTO `activities`" +
                            " (`start_time`, `activity_desc`, `activity_type`) " +
                            " VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                 PreparedStatement stmtTrackPoint = conn.prepareStatement("INSERT INTO `track_points` " +
                         " (`time`, `lat`, `lon`, `activity_id`) " +
                         " VALUES(?, ?, ?, ?)")
            ) {
                stmtActivity.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
                stmtActivity.setString(2, activity.getDesc());
                stmtActivity.setString(3, String.valueOf(activity.getType()));
                stmtActivity.executeUpdate();

                ResultSet rs = stmtActivity.getGeneratedKeys();
                if (rs.next()) {
                    Activity newActivity = activity.activityWithId(rs.getLong(1));
                    saveTrackPoints(newActivity, stmtTrackPoint);
                    conn.commit();

                    return newActivity;
                }
                throw new IllegalStateException("Activity insertion failed");

            } catch (IllegalStateException | SQLException e) {
                conn.rollback();
                throw new IllegalStateException("Activity insertion failed", e);
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Activity cannot inserted", sqlException);
        }
    }

    public void saveMultiplyActivity(List<Activity> activities) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO `activities`" +
                             " (`start_time`, `activity_desc`, `activity_type`) " +
                             " VALUES (?, ?, ?)")
        ) {
            for (Activity activity : activities) {
                stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
                stmt.setString(2, activity.getDesc());
                stmt.setString(3, String.valueOf(activity.getType()));
                stmt.addBatch();
            }

            stmt.executeBatch();

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Activities cannot inserted", sqlException);
        }
    }

    public Activity findActivityById(long id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `activities` WHERE `id` = ?")) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                List<TrackPoint> trackPoints = findActivityTrackPoints(rs.getLong("id"));

                return new Activity(
                        rs.getLong("id"),
                        rs.getTimestamp("start_time").toLocalDateTime(),
                        rs.getString("activity_desc"),
                        ActivityType.valueOf(rs.getString("activity_type")),
                        trackPoints);
            }
            throw new IllegalArgumentException("Activity not found");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot select activity", sqlException);
        }
    }

    private List<TrackPoint> findActivityTrackPoints(long id) {
        List<TrackPoint> trackPoints = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `track_points` WHERE `activity_id` = ?")) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                trackPoints.add(new TrackPoint(rs.getLong("id"),
                        rs.getTimestamp("time").toLocalDateTime(),
                        rs.getDouble("lat"),
                        rs.getDouble("lon")
                ));
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot select track points", sqlException);
        }

        return trackPoints;
    }

    public List<Activity> listActivities() {
        List<Activity> activities = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `activities`")) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                activities.add(new Activity(
                        rs.getLong("id"),
                        rs.getTimestamp("start_time").toLocalDateTime(),
                        rs.getString("activity_desc"),
                        ActivityType.valueOf(rs.getString("activity_type"))));
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot select activities", sqlException);
        }

        return activities;
    }
}
