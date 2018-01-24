package main.java.nl.hu.v2tosad.TOSAD;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDAO {
	private Connection conn;
	
	private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@ondora02.hu.nl:8521/cursus02.hu.nl";
	private static final String DB_USER = "tosad_2017_2b_team2_target";
	private static final String DB_PASS = "tosad_2017_2b_team2_target";
	
	
	public BaseDAO() {
		try {
			Class.forName(DB_DRIV).newInstance();
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
	}
	protected final Connection getConnection() {
		try {
			this.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			return conn;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

}
