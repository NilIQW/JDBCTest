package DAL;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class Connection {
    private final SQLServerDataSource dataSource;
    public Connection() {
        dataSource = new SQLServerDataSource();
        dataSource.setServerName("10.176.111.34");
        dataSource.setDatabaseName("Nil.JDBCTest");
        dataSource.setUser("CSe2023b_e_21");
        dataSource.setPassword("CSe2023bE21#23");
        dataSource.setPortNumber(1433);
        dataSource.setTrustServerCertificate(true);

    }

    public java.sql.Connection getConnection() throws SQLServerException {
        return dataSource.getConnection();
    }

}
