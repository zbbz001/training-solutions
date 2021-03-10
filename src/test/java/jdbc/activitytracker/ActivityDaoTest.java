package jdbc.activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTest {
    private ActivityDao activityDao;

    @BeforeEach
    public void init() throws SQLException {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3307/activitytracker?useUnicode=true");
        dataSource.setUser("activitytracker");
        dataSource.setPassword("activitytracker");

        Flyway flyway = Flyway.configure()
                .locations("/db/migration/activitytracker")
                .dataSource(dataSource)
                .load();

        flyway.clean();
        flyway.migrate();

        activityDao = new ActivityDao(dataSource);
    }

    @Test
    public void testSaveActivity() {
        List<TrackPoint> trackPoints = List.of(
                new TrackPoint(LocalDateTime.of(2021, 01, 11, 17, 10, 00), 45.44, 98.51),
                new TrackPoint(LocalDateTime.of(2021, 01, 11, 17, 15, 00), 45.40, 99.51),
                new TrackPoint(LocalDateTime.of(2021, 01, 11, 17, 20, 00), 41.79, 108.51),
                new TrackPoint(LocalDateTime.of(2021, 01, 11, 17, 15, 00), 40.14, 104.51)
        );

        Activity activity = activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 01, 11, 17, 10, 00), "hegyi kerékpározás", ActivityType.BIKING, trackPoints));

        assertEquals(1L, activity.getId());
        assertEquals("hegyi kerékpározás", activityDao.findActivityById(1L).getDesc());
        assertEquals(ActivityType.BIKING.toString(), activityDao.findActivityById(1L).getType().toString());
    }

    @Test
    public void testSaveActivityRollback() {
        List<TrackPoint> trackPoints = List.of(
                new TrackPoint(LocalDateTime.of(2021, 01, 11, 17, 10, 00), 45.44, 98.51),
                new TrackPoint(LocalDateTime.of(2021, 01, 11, 17, 15, 00), 45.40, 99.51),
                new TrackPoint(LocalDateTime.of(2021, 01, 11, 17, 20, 00), 41.79, 108.51),
                new TrackPoint(LocalDateTime.of(2021, 01, 11, 17, 15, 00), 140.14, 104.51)
        );

        assertThrows(IllegalStateException.class, () -> activityDao.saveActivity(new Activity(LocalDateTime.of(2021, 01, 11, 17, 10, 00), "hegyi kerékpározás", ActivityType.BIKING, trackPoints)));
    }

    @Test
    public void testMultiplySaveActivity() {
        activityDao.saveMultiplyActivity(List.of(
                new Activity(LocalDateTime.of(2021, 01, 11, 17, 10, 00), "hegyi kerékpározás", ActivityType.BIKING),
                new Activity(LocalDateTime.of(2021, 01, 19, 11, 52, 00), "kosár Ramboval", ActivityType.BASKETBALL),
                new Activity(LocalDateTime.of(2021, 01, 17, 11, 55, 00), "", ActivityType.HIKING),
                new Activity(LocalDateTime.of(2021, 02, 21, 19, 11, 00), "kerékpározás", ActivityType.BIKING)
        ));

        assertEquals("kosár Ramboval", activityDao.findActivityById(2L).getDesc());
    }

}