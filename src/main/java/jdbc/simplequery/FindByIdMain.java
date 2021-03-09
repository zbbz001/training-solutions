package jdbc.simplequery;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindByIdMain {

    public static void main(String[] args) {

        MariaDbDataSource dataSource = new MariaDbDataSource();

        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3307/employees?useUnicode=true");
            dataSource.setUser("employees");
            dataSource.setPassword("employees");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot create data source", sqlException);
        }

        selectEmplyeeById(dataSource, 3L);
    }

    private static void selectEmplyeeById(MariaDbDataSource dataSource, Long id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT `emp_name` FROM `employees` WHERE `id` = (?)");
        ) {
            stmt.setLong(1, id);
            String name = selectNameByPreparedStatement(stmt);
            System.out.println(name);

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot select employee", sqlException);
        }
    }

    private static String selectNameByPreparedStatement(PreparedStatement stmt) {
        try {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("emp_name");
            }
            throw new IllegalArgumentException("Employee not found");

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot select employee", sqlException);
        }
    }
}
