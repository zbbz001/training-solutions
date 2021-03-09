package jdbc.architecture;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

public class EmployeeMain {

    public static void main(String[] args) {
        MariaDbDataSource dataSource = new MariaDbDataSource();

        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3307/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot create data source");
        }

        EmployeesDao employeesDao = new EmployeesDao(dataSource);
        //employeesDao.createEmployee("Rocky Balboa");
        System.out.println(employeesDao.selectAllEmployee());
        System.out.println(employeesDao.findEmployeeById(3L));
    }

}
