package connectionTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnector implements DatabaseConnector{
	private String DB_DRIV;
	private String DB_URL;
	private String DB_USER;
	private String DB_PASS;
	
	
	public OracleConnector(String driver, String url, String user, String password) {
		this.DB_DRIV = driver;
		this.DB_URL = url;
		this.DB_USER = user;
		this.DB_PASS = password;
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		try {
			Class.forName(this.DB_DRIV).newInstance();
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return DriverManager.getConnection(this.DB_URL, this.DB_USER, this.DB_PASS);
	}

//	public String getDB_DRIV() {
//		return DB_DRIV;
//	}
//
//	public void setDB_DRIV(String dB_DRIV) {
//		DB_DRIV = dB_DRIV;
//	}
//
//	public String getDB_URL() {
//		return DB_URL;
//	}
//
//	public void setDB_URL(String dB_URL) {
//		DB_URL = dB_URL;
//	}
//
//	public String getDB_USER() {
//		return DB_USER;
//	}
//
//	public void setDB_USER(String dB_USER) {
//		DB_USER = dB_USER;
//	}
//
//	public String getDB_PASS() {
//		return DB_PASS;
//	}
//
//	public void setDB_PASS(String dB_PASS) {
//		DB_PASS = dB_PASS;
//	}

}
