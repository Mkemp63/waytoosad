package nl.hu.v2tosad.data.dao;

//Factory Method (Design Pattern), with this class we can get a connection to the correct Target database at run-time
public class TargetDatabaseFactory {
	public static TargetDAO getTargetDAO(String dbType, String DB_URL, String DB_USER, String DB_PASS) {
		if (dbType.equals("Oracle")) {
			return new OracleTargetDAO(DB_URL, DB_USER, DB_PASS);
		} 
		else {
			return null;
		}
	}

}
