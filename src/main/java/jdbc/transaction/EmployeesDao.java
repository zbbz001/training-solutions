package jdbc.transaction;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDao {
    private DataSource dataSource;

    public EmployeesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void createEmployess(List<String> names) {
        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO `employees` (`emp_name`) VALUES(?)")) {
                for (String name : names) {
                    if (name.startsWith("x")) {
                        throw new IllegalArgumentException("Invalid name");
                    }

                    stmt.setString(1, name);
                    stmt.execute();
                }

                conn.commit();
            } catch (IllegalArgumentException iae) {
                conn.rollback();
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot insert emplyoees", sqlException);
        }
    }

    public long createEmployee(String name) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO `employees` (`emp_name`) VALUES(?)", Statement.RETURN_GENERATED_KEYS)
        ) {
            stmt.setString(1, name);
            stmt.execute();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                return rs.getLong(1);
            }

            throw new IllegalStateException("Cannot get id");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot insert employee", sqlException);
        }
    }

    public List<String> selectAllEmployee() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT `emp_name` FROM `employees`");
        ) {
            List<String> names = new ArrayList<>();

            while (rs.next()) {
                names.add(rs.getString("emp_name"));
            }

            return names;
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot select employees", sqlException);
        }
    }

    public String findEmployeeById(Long id) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT `emp_name` FROM `employees` WHERE `id` = (?)");
        ) {
            stmt.setLong(1, id);
            return selectNameByPreparedStatement(stmt);
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
