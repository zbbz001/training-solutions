package covid.dao;

import covid.Vaccination;
import covid.Vaccine;
import covid.Zip;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VaccinationsDao {
    private final DataSource dataSource;

    public VaccinationsDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<HashMap<String, Object>> selectDataToVaccinationList(Zip zip, int maxNumOfPatient) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT `citizen_name`, `age`, `email`, `ssn` FROM `citizens` " +
                     " LEFT JOIN (SELECT `citizen_id`, COUNT(*) AS numVaccinations" +
                     " FROM `vaccinations`" +
                     " LEFT JOIN `citizens` ON `citizens`.`id` = `vaccinations`.`citizen_id` WHERE `vaccinations_status` = 1" +
                     " AND `zip_code_id` = ? GROUP BY `citizen_id`) AS `t1`" +
                     " ON `t1`.`citizen_id` = `citizens`.`id`" +
                     " WHERE (`numVaccinations` IS NULL OR `numVaccinations` < 2)" +
                     " AND `zip_code_id` = ?" +
                     " ORDER BY `citizens`.`age` DESC" +
                     " LIMIT ?")) {

            stmt.setLong(1, zip.getId());
            stmt.setLong(2, zip.getId());
            stmt.setLong(3, maxNumOfPatient);

            return selectDataByPrepareStatementToHashMaps(stmt);
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Unable to select", sqlException);
        }
    }

    private List<HashMap<String, Object>> selectDataByPrepareStatementToHashMaps(PreparedStatement stmt) {
        List<HashMap<String, Object>> resultList = new ArrayList<>();

        try {
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int numOfColumns = metaData.getColumnCount();

            while (rs.next()) {
                HashMap<String, Object> row = new HashMap<>();
                for (int i = 1; i <= numOfColumns; i++) {
                    row.put(metaData.getColumnName(i), rs.getObject(i));
                }
                resultList.add(row);
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Unable to select", sqlException);
        }

        return resultList;
    }

    public List<Vaccination> selectCitizenVaccinations(String ssn) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT `vaccinations`.*" +
                     " FROM `vaccinations`" +
                     " LEFT JOIN `citizens` ON `citizens`.`id` = `vaccinations`.`citizen_id`" +
                     " WHERE `ssn` = ?" +
                     " ORDER BY vaccinations_ts DESC")) {

            stmt.setString(1, ssn);

            return selectCitizenVaccinationsByPrepareStatement(stmt);
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Unable to select", sqlException);
        }
    }

    private List<Vaccination> selectCitizenVaccinationsByPrepareStatement(PreparedStatement stmt) {
        List<Vaccination> vaccinationList = new ArrayList<>();

        try {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                if (rs.getString("vaccine_type") != null) {
                    vaccinationList.add(new Vaccination(
                            rs.getLong("citizen_id"),
                            rs.getDate("vaccinations_ts").toLocalDate(),
                            rs.getInt("vaccinations_status"),
                            rs.getString("vaccinations_note"),
                            Vaccine.valueOf(rs.getString("vaccine_type"))));
                } else {
                    vaccinationList.add(new Vaccination(
                            rs.getLong("citizen_id"),
                            rs.getDate("vaccinations_ts").toLocalDate(),
                            rs.getInt("vaccinations_status"),
                            rs.getString("vaccinations_note"),
                            null));
                }
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Unable to select", sqlException);
        }

        return vaccinationList;
    }

    public void saveNewVaccination(Vaccination vaccination) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO `vaccinations`" +
                     " (`citizen_id`, `vaccinations_ts`, `vaccinations_status`, `vaccinations_note`, `vaccine_type`)" +
                     " VALUES (?, ?, ?, ?, ?)")) {

            stmt.setLong(1, vaccination.getCitizenId());
            stmt.setDate(2, Date.valueOf(vaccination.getVaccinationTime()));
            stmt.setInt(3, vaccination.getVaccinationStatus());
            stmt.setString(4, vaccination.getVaccinationNote());
            stmt.setString(5, vaccination.getVaccine() != null ? vaccination.getVaccine().name() : null);

            stmt.executeUpdate();

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Unable to insert", sqlException);
        }
    }

    public List<HashMap<String, Object>> selectVaccinationsByZip() {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT `zip_code`, SUM(`no_vacc`) AS sum_no_vacc, SUM(`vacc1`) AS sum_vacc_x1, SUM(`vacc2`) AS sum_vacc_x2" +
                     " FROM (" +
                     "   (SELECT `zip_code_id`, `vaccinations_status`, COUNT(*) AS 'no_vacc', 0 AS 'vacc1', 0 AS 'vacc2', 0 AS 'temp'" +
                     "     FROM `citizens`" +
                     "     LEFT JOIN `vaccinations` ON `vaccinations`.`citizen_id` = `citizens`.`id`" +
                     "     WHERE `vaccinations_status` IS NULL" +
                     "     GROUP BY `vaccinations`.`citizen_id`, `citizens`.`zip_code_id`)" +
                     "   UNION" +
                     "   (SELECT `zip_code_id`, `vaccinations_status`, 0, 1, 0, COUNT(*) AS 'vacc1'" +
                     "     FROM `citizens`" +
                     "     LEFT JOIN `vaccinations` ON `vaccinations`.`citizen_id` = `citizens`.`id`" +
                     "     WHERE `vaccinations_status` = 1" +
                     "     GROUP BY `vaccinations`.`citizen_id`, `citizens`.`zip_code_id`" +
                     "     HAVING `vacc1` = 1)" +
                     "   UNION" +
                     "   (SELECT `zip_code_id`, `vaccinations_status`, 0, 0, 1, COUNT(*) AS 'vacc2'" +
                     "     FROM `citizens`" +
                     "     LEFT JOIN `vaccinations` ON `vaccinations`.`citizen_id` = `citizens`.`id`" +
                     "     WHERE `vaccinations_status` = 1" +
                     "     GROUP BY `vaccinations`.`citizen_id`, `citizens`.`zip_code_id`" +
                     "     HAVING `vacc2` = 2)" +
                     "   ) AS t1" +
                     " LEFT JOIN `zip_codes` ON `zip_codes`.`id` = `t1`.`zip_code_id`" +
                     " GROUP BY zip_code")) {

            return selectDataByPrepareStatementToHashMaps(stmt);
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Unable to select", sqlException);
        }
    }
}
