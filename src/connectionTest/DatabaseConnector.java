package connectionTest;

import java.sql.*;

public interface DatabaseConnector {
	public Connection getConnection() throws SQLException;

}
