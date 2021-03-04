package covid.dao;

import covid.Zip;
import org.jetbrains.annotations.Nullable;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ZipDao {
    private final DataSource dataSource;

    public ZipDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Zip findZipByZipCode(String zipCode) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `zip_codes` WHERE `zip_code` = ? LIMIT 1");
        ) {
            stmt.setString(1, zipCode);

            return findZipByPreparedStatement(stmt);
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot select zipcode", sqlException);
        }
    }

    public Zip findZipByZipId(Long zipId) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `zip_codes` WHERE `id` = ? LIMIT 1");
        ) {
            stmt.setLong(1, zipId);

            return findZipByPreparedStatement(stmt);
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot select zipcode", sqlException);
        }
    }


    @Nullable
    private Zip findZipByPreparedStatement(PreparedStatement stmt) {
        try {
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Zip(rs.getLong("id"), rs.getString("zip_code"), rs.getString("settlement"), rs.getString("settlement_part"));
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Unable to select zip", sqlException);
        }

        return null;
    }
}
