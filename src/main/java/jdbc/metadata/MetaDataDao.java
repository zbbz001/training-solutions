package jdbc.metadata;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetaDataDao {
    private DataSource dataSource;

    public MetaDataDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getTableNames() {
        try (Connection conn = dataSource.getConnection()) {
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet rs = metaData.getTables(null, null, null, null);

            List<String> tableNames = new ArrayList<>();

            while (rs.next()) {
                tableNames.add(rs.getString(3));
            }

            return tableNames;
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot read table names", sqlException);
        }
    }
}
