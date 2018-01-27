package nl.hu.v2tosad.data.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import nl.hu.v2tosad.data.model.AttributeRangeRule;
import nl.hu.v2tosad.data.model.BusinessRule;

public class RepositoryDAO {
	private Connection conn;
	private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@ondora02.hu.nl:8521/cursus02.hu.nl";
	private static final String DB_USER = "tosad_2017_2b_team2";
	private static final String DB_PASS = "tosad_2017_2b_team2";
	
	public RepositoryDAO() {
		try {
			Class.forName(DB_DRIV).newInstance();
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		getConnection();
	}
	
	public final Connection getConnection() {
		try {
			this.conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			return conn;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	//TODO
//	public BusinessRule getRuleDetails() {
//		
//	}
	
	public BusinessRule getBusinessRule(int id) {
		BusinessRule br = new BusinessRule();
		try(Statement stmt = conn.createStatement()){
			ResultSet rs = stmt.executeQuery("SELECT * FROM BUSINESSRULE WHERE ID = " + id);
			
			int idResult;
			String status;
			Date dateModified;
			String code;
			String businessRuleType;
			String rule_Name;
			String discription;
			String tableName;
			System.out.println("");
			
			while(rs.next()) {

				idResult = rs.getInt("ID");
				status = rs.getString("STATUS");
				dateModified = rs.getDate("DATEMODIFIED");
				code = rs.getString("CODE");
				businessRuleType = rs.getString("BUSINESSRULETYPE");
				rule_Name = rs.getString("RULE_NAME");
				discription = rs.getString("DISCRIPTION");
				tableName = rs.getString("tableName");
				
				br = new BusinessRule(idResult, status, dateModified, code, businessRuleType, rule_Name, discription, tableName);
			}
			
			if (br.getBusinessRuleType().equals("Attribute Range Rule")) {
				rs = stmt.executeQuery("SELECT * FROM RANGE_RULE WHERE FK_BUSINESSRULE_ID = " + br.getId());
				while(rs.next()) {
					br = new AttributeRangeRule(br, rs.getInt("RANGERULE_ID"), rs.getInt("MINVAL"), rs.getInt("MAXVAL"), rs.getString("OPERATORVALUE"), rs.getString("COLUMNNAME"));
				}
			}
			
//			if (br.getId() == 0) {
//				SQLException sqle = new SQLException();
//				sqle.printStackTrace();
//			}
			
			rs.close();
			this.conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return br;
	}
	

}
