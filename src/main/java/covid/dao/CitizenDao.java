package covid.dao;

import covid.Citizen;
import org.jetbrains.annotations.Nullable;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CitizenDao {
    private final DataSource dataSource;

    public CitizenDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void saveCitizen(Citizen citizen) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO `citizens`" +
                     " (`citizen_name`, `zip_code_id`, `age`, `email`, `ssn`)" +
                     " VALUES(?, ?, ?, ?, ?)")
        ) {
            stmt.setString(1, citizen.getName());
            stmt.setLong(2, citizen.getZip().getId());
            stmt.setLong(3, citizen.getAge());
            stmt.setString(4, citizen.getEmail());
            stmt.setString(5, citizen.getSsn());

            stmt.executeUpdate();
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Citizen cannot inserted", sqlException);
        }
    }

    public void saveMultipleCitizens(List<Citizen> citizens) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO `citizens`" +
                     " (`citizen_name`, `zip_code_id`, `age`, `email`, `ssn`)" +
                     " VALUES(?, ?, ?, ?, ?)")
        ) {
            int i = 0;
            for (Citizen citizen : citizens) {
                stmt.setString(1, citizen.getName());
                stmt.setLong(2, citizen.getZip().getId());
                stmt.setLong(3, citizen.getAge());
                stmt.setString(4, citizen.getEmail());
                stmt.setString(5, citizen.getSsn());
                stmt.addBatch();
                i++;
            }

            if (i % 1000 == 0 || i == citizens.size()) {
                stmt.executeBatch();
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Citizens cannot inserted", sqlException);
        }
    }

    public Citizen findCitizenBySsn(String ssn) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM `citizens`" +
                     " WHERE ssn = ?")
        ) {
            stmt.setString(1, ssn);

            return findCitizenByPreparedStatement(stmt);

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Citizens cannot selected", sqlException);
        }
    }

    @Nullable
    private Citizen findCitizenByPreparedStatement(PreparedStatement stmt) {
        try {
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Citizen(
                        rs.getLong("id"),
                        rs.getString("citizen_name"),
                        new ZipDao(dataSource).findZipByZipId(rs.getLong("zip_code_id")),
                        rs.getInt("age"),
                        rs.getString("email"),
                        rs.getString("ssn"));
            }
            return null;
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Unable to select citizen", sqlException);
        }
    }
}