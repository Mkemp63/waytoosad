package nl.hu.v2tosad.data.dao;

import nl.hu.v2tosad.data.model.*;

import java.sql.*;

// connection to tool db
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
				
			} else if (br.getBusinessRuleType().equals("Attribute Compare Rule")) {
				rs = stmt.executeQuery("SELECT * FROM COMPARE_RULE WHERE FK_BUSINESSRULE_ID = " + br.getId());
				while(rs.next()) {
					br = new AttributeCompareRule(br, rs.getInt("COMPARE_RULE_ID"), rs.getString("COLUMNNAME"), rs.getString("COMPAREVALUE"), rs.getString("OPERATORVALUE"));
				}
			} else if (br.getBusinessRuleType().equals("Attribute List Rule")) {
				rs = stmt.executeQuery("SELECT * FROM LIST_RULE WHERE FK_BUSINESSRULE_ID = " + br.getId());
				int list_id = 0;
				while(rs.next()) {
					br = new AttributeListRule(br, rs.getInt("LIST_RULE_ID"), rs.getString("COLUMNNAME"), rs.getString("OPERATORVALUE"));
					list_id = rs.getInt("LIST_RULE_ID");
				}
				rs = stmt.executeQuery("SELECT * FROM LIST_RULE_VALUE WHERE ID = " + list_id);
				
				//Parse BusinessRule object naar een AttributeListRule zodat de functies gebruikt kunnen worden van de AttributeListRule klasse
				//DIt is nodig om de listvalues toe te kunnen voegen aan de arraylist van AttributeListRule
				AttributeListRule attlr = (AttributeListRule)br;

				while(rs.next()) {
					String a = rs.getString("ITEM_VALUE");
					attlr.addValue(a);
				}
				//Hier wordt de Parse weer teruggezet.
				br = attlr;
			} 	else if (br.getBusinessRuleType().equals("Inter-Entity Compare Rule")) {
				rs = stmt.executeQuery("SELECT * FROM inter_entity_compare_rule WHERE fk_businessrule_id =" + br.getId());
				while (rs.next()) {
					br = new InterEntityCompareRule(br, rs.getInt("INTER_ENTITY_COMPARE_RULE_ID"), rs.getString("COLUMNNAME"), rs.getString("TABLENAME2"), rs.getString("COLUMN2"), rs.getString("OPERATOR"));
				}
			}
			else if (br.getBusinessRuleType().equals("Entity Other Rule")) {
				rs = stmt.executeQuery("SELECT * FROM other_rule WHERE fk_businessrule_id =" + br.getId());
				while (rs.next()) {
					br = new EntityOtherRule(br, rs.getInt("OTHER_RULE_ID"), rs.getString("COLUMNNAME"), rs.getString("PLSQLCODE"));
				}
			}
			else if (br.getBusinessRuleType().equals("Modify Rule")) {
				rs = stmt.executeQuery("SELECT * FROM modify_rule WHERE fk_businessrule_id =" + br.getId());
				while (rs.next()) {
					br = new ModifyRule(br, rs.getInt("MODIFY_RULE_ID"), rs.getString("PLSQLCODE"));
				}
			}
			else if (br.getBusinessRuleType().equals("Tuple Other Rule")) {
				rs = stmt.executeQuery("SELECT * FROM other_rule WHERE fk_businessrule_id =" + br.getId());
				while (rs.next()) {
					br = new ModifyRule(br, rs.getInt("OTHER_RULE_ID"), rs.getString("PLSQLCODE"));
				}
			}
			else if (br.getBusinessRuleType().equals("Tuple Compare Rule")) {
				rs = stmt.executeQuery("SELECT * FROM compare_rule WHERE fk_businessrule_id =" + br.getId());
				while (rs.next()) {
					br = new TupleCompareRule(br, rs.getInt("COMPARE_RULE_ID"), rs.getString("COLUMNNAME"), rs.getString("COMPAREVALUE"), rs.getString("OPERATORVALUE"));
				}
			}
			else if (br.getBusinessRuleType().equals("Attribute Other Rule")) {
				rs = stmt.executeQuery("SELECT * FROM other_rule WHERE fk_businessrule_id =" + br.getId());
				while (rs.next()) {
					br = new AttributeOtherRule(br, rs.getInt("OHTER_RULE_ID"), rs.getString("COLUMNNAME"), rs.getString("PLSQLCODE"));
				}
			}
			
			
//			if (br.getId() == 0) {
//				SQLException sqle = new SQLException();
//				sqle.printStackTrace();
//			}
			
			rs.close();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return br;
	}
	

}
