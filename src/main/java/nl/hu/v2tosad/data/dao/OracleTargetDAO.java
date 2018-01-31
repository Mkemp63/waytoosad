package nl.hu.v2tosad.data.dao;

import nl.hu.v2tosad.data.model.BusinessRule;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OracleTargetDAO implements TargetDAO{
	private final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	private final String DB_URL;
	private final String DB_USER;
	private final String DB_PASS;

	public OracleTargetDAO(String DB_URL, String DB_USER, String DB_PASS) {
		this.DB_URL = DB_URL;
		this.DB_USER = DB_USER;
		this.DB_PASS = DB_PASS;
		try {
			Class.forName(DB_DRIV).newInstance();
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	
	public void generateRules(ArrayList<BusinessRule> rules) {
		try(Connection conn = getConnection()) {
			Statement stmt = conn.createStatement();
			
			for(BusinessRule br : rules) {
				String sql = br.generateCode("Oracle");
				System.out.println("Dit is de SQL-code: ");
				System.out.println(sql);
//				stmt.executeQuery(sql);
//				this.updateAffected(br.getId());
			}
			
			stmt.close();
			conn.close();
				
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		} 
	}
	
	public void dropRules(ArrayList<BusinessRule> rules) {
		try(Connection conn = getConnection()) {
			Statement stmt = conn.createStatement();
			for(BusinessRule br : rules) {
				String sql = "ALTER TABLE " + br.getTableName() + " DROP CONSTRAINT " + br.getCode();
				System.out.println(sql);
			}
			stmt.close();
			conn.close();
		} catch ( SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	public void updateAffected(int id) {
		RepositoryDAO repo = new RepositoryDAO();
		repo.setRuleStatus("ACTIVE", id);
	}
	

	@Override
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		}
		catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}
