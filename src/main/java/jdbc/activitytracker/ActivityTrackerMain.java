package jdbc.activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityTrackerMain {

    private void insertActivityToDatabase(Activity activity, DataSource dataSource) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO `activities`" +
                             " (`start_time`, `activity_desc`, `activity_type`) " +
                             " VALUES (?, ?, ?)")
        ) {
            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            stmt.setString(2, activity.getDesc());
            stmt.setString(3, String.valueOf(activity.getType()));
            stmt.execute();
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Activity cannot inserted", sqlException);
        }
    }

    private Activity findActivityById(DataSource dataSource, long id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `activities` WHERE `id` = ?")) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Activity(
                        rs.getLong("id"),
                        rs.getTimestamp("start_time").toLocalDateTime(),
                        rs.getString("activity_desc"),
                        ActivityType.valueOf(rs.getString("activity_type")));
            }
            throw new IllegalArgumentException("Activity not found");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot select activity", sqlException);
        }
    }

    private List<Activity> getAllActivities(DataSource dataSource) {
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


    public static void main(String[] args) {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3307/activitytracker?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot create data source", sqlException);
        }

//        new ActivityTrackerMain().insertActivityToDatabase(new Activity(LocalDateTime.of(2021, 01, 11, 17, 10, 00), "hegyi kerékpározás", ActivityType.BIKING), dataSource);
//        new ActivityTrackerMain().insertActivityToDatabase(new Activity(LocalDateTime.of(2021, 01, 19, 11, 52, 00), "kosár Ramboval", ActivityType.BASKETBALL), dataSource);
//        new ActivityTrackerMain().insertActivityToDatabase(new Activity(LocalDateTime.of(2021, 01, 17, 11, 55, 00), "", ActivityType.HIKING), dataSource);
//        new ActivityTrackerMain().insertActivityToDatabase(new Activity(LocalDateTime.of(2021, 02, 21, 19, 11, 00), "hegyi kerékpározás", ActivityType.BIKING), dataSource);

//        Activity activity = new ActivityTrackerMain().findActivityById(dataSource, 2L);
//        System.out.println(activity);

        List<Activity> activityList = new ActivityTrackerMain().getAllActivities(dataSource);
        System.out.println(activityList);

    }


}
