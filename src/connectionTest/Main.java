package connectionTest;

import java.sql.*;

public class Main {
	public static void main(String[] args) throws SQLException {
		
		
		
		
		ConnectionController ConnControl = new ConnectionController();
		
		
		String DB_TYPE = "Oracle";
		String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
		String DB_URL = "jdbc:oracle:thin:@ondora02.hu.nl:8521/cursus02.hu.nl";
		String DB_USER = "tosad_2017_2b_team2";
		String DB_PASS = "tosad_2017_2b_team2";

		DatabaseConnector databaseConnector1 = new OracleConnector(DB_DRIV, DB_URL, DB_USER, DB_PASS);
		ConnControl.addConnection(databaseConnector1);

		
		Connection conn = databaseConnector1.getConnection();
		
		Statement stmt = conn.createStatement();
		String query = "SELECT db_type, db_url, db_user, db_pass from DATABASE_SCHEMA where id = 1";
		ResultSet rs = stmt.executeQuery(query);
		
		String DB_TYPE2= "";
		String DB_URL2 = "";
		String DB_USER2 = "";
		String DB_PASS2 = "";
		
		while(rs.next()) {
			DB_TYPE2 = rs.getString("DB_TYPE");
			DB_URL2 = rs.getString("DB_URL");
			DB_USER2 = rs.getString("DB_USER");
			DB_PASS2 = rs.getString("DB_PASS");
			System.out.println("Connectie met de target: " + DB_TYPE2 + ", " + DB_URL2 + ", " + DB_USER2);
		}
		
		if (DB_TYPE2.equals("Oracle")) {
			DatabaseConnector dbcn = new OracleConnector(DB_DRIV, DB_URL2, DB_USER2, DB_PASS2);
			ConnControl.addConnection(dbcn);
		}
		
		rs.close();
		conn.close();
		
		
		for (DatabaseConnector dc : ConnControl.getConnections()) {
			if (dc instanceof OracleConnector) { 
				conn = dc.getConnection();
				
				stmt = conn.createStatement();
				query = "SELECT id, string FROM test";
				
				rs = stmt.executeQuery(query);
				
				int id;
				String string;
				while(rs.next()) {
					id = rs.getInt("id");
					string = rs.getString("string");
					System.out.println("id " + ", " + string);
				}
				rs.close();
				conn.close();
			}
			else {
				System.out.println("Geen Oracle database!");
			}
		}
	}

}
