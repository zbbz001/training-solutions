package jdbc.metadata;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MetaDataDaoTest {
    private MetaDataDao metaDataDao;

    @BeforeEach
    public void init() throws SQLException {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3307/employees?useUnicode=true");
        dataSource.setUser("employees");
        dataSource.setPassword("employees");

        Flyway flyway = Flyway.configure()
                .locations("db/migration/employee")
                .dataSource(dataSource)
                .load();

        flyway.clean();
        flyway.migrate();

        metaDataDao = new MetaDataDao(dataSource);
    }

    @Test
    public void testTableNames() {
        List<String> names = metaDataDao.getTableNames();
        System.out.println(names);
        assertTrue(names.contains("employees"));
    }
}