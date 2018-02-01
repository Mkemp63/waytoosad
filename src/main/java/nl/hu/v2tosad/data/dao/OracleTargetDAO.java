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
	
	// Method to generate Businessrules in the target database using a list of Businessrule-objects
	public void generateRules(ArrayList<BusinessRule> rules) {
		try(Connection conn = getConnection()) {
			Statement stmt = conn.createStatement();
            RepositoryDAO repo = new RepositoryDAO();

            for(BusinessRule br : rules) {
				String sql = br.generateCode("Oracle");
				System.out.println("Dit is de SQL-code: ");
				System.out.println(sql);
				
				// Because not every rule type is supported we check if the rule is implemented first
				if (!sql.equals("not implemented")) {
                    stmt.executeQuery(sql);
                    repo.setRuleStatus("ACTIVE", br.getId());
                }
			}
			
			stmt.close();
			conn.close();
				
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		} 
	}
	
	// Method to drop the rules from the target database
	// With as parameter a list of Businessrule-objects to drop form the target database
	public void dropRules(ArrayList<BusinessRule> rules) {
		try(Connection conn = getConnection()) {
			Statement stmt = conn.createStatement();
			for(BusinessRule br : rules) {
				// A nested try-catch block to drop a constraint or trigger
				// This is because some Businessrules are only written in triggers and some are written in constraints
				try {
					String sql = "ALTER TABLE " + br.getTableName() + " DROP CONSTRAINT " + br.getCode();
					System.out.println(sql);
					stmt.executeQuery(sql);
				} catch (SQLException sqle) {
					try {
						String sql = "DROP TRIGGER " + br.getCode() + "_" + br.getTableName();
						System.out.println(sql);
						stmt.executeQuery(sql);
					} catch (SQLException sqle2) {
						sqle2.printStackTrace();
					}
				}
			}
			stmt.close();
			conn.close();
		} catch ( SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	// Method to get a connetction with the database
	// Using the attributes of this class
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		}
		catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}
