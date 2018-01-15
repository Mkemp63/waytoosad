package Voorbeeld_Database_Verbinding;
import java.sql.*;


public class Main {
	private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@ondora02.hu.nl:8521/cursus02.hu.nl";
	private static final String DB_USER = "tosad_2017_2b_team2";
	private static final String DB_PASS = "tosad_2017_2b_team2";
	private static final String DB_USER2 = "tosad_2017_2b_team2_target";
	private static final String DB_PASS2 = "tosad_2017_2b_team2_target";
	private static Connection conn;
	private static Connection conn2;
	
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName(DB_DRIV).newInstance();
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		conn2 = DriverManager.getConnection(DB_URL, DB_USER2, DB_PASS2);
		//test
		Statement stm = conn.createStatement();
		String queryText = "SELECT id, string FROM test";
		Statement stm2 = conn2.createStatement();
		String queryText2 = "SELECT id , string FROM test";
		
		ResultSet rs = stm.executeQuery(queryText);
		ResultSet rs2 = stm2.executeQuery(queryText2);
		
		int id;
		String string;
		while (rs.next()) {   
			id = rs.getInt("id");	
			string = rs.getString("string");
			System.out.println(id + ", " + string);
		}
		
		int id2;
		String string2;
		while (rs2.next()) {
			id2 = rs2.getInt("id");
			string2 = rs2.getString("string");
			System.out.println(id2 + ", " + string2);
		}
		
		rs.close();
		stm.close();
		rs2.close();
		stm2.close();
		conn.close();
		conn2.close();
	}
	
}
