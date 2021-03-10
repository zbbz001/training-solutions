package jdbc.transaction;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeesDaoTest {

    private EmployeesDao employeesDao;

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

        employeesDao = new EmployeesDao(dataSource);
    }

    @Test
    public void testCreateEmployees() {
        employeesDao.createEmployess(List.of("Rocky Balboa", "Mickey Mouse", "John James Rambo"));
        List<String> names = employeesDao.selectAllEmployee();
        assertEquals(List.of("Rocky Balboa", "Mickey Mouse", "John James Rambo"), names);
    }

    @Test
    public void testCreateEmployeesRollback() {
        employeesDao.createEmployess(List.of("Rocky Balboa", "Mickey Mouse", "John James Rambo", "xxx"));
        List<String> names = employeesDao.selectAllEmployee();
        assertEquals(Collections.emptyList(), names);
    }
}