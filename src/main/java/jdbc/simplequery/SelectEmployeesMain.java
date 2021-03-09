package jdbc.simplequery;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SelectEmployeesMain {

    public static void main(String[] args) {
        MariaDbDataSource dataSource = new MariaDbDataSource();

        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3307/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot create data source", sqlException);
        }

        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT `emp_name` FROM `employees`");
        ) {
            List<String> names = new ArrayList<>();

            while (rs.next()) {
                names.add(rs.getString("emp_name"));
            }

            System.out.println(names);
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot select employees", sqlException);
        }

    }


}
