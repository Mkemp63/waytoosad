package nl.hu.v2tosad.data.dao;

import nl.hu.v2tosad.data.model.BusinessRule;
import nl.hu.v2tosad.data.model.Generate;
import nl.hu.v2tosad.data.model.GenerateFactory;

import java.sql.Connection;
import java.util.ArrayList;

// implements generated code in target db
public class TargetDAOImpl implements TargetDAO {
	private String schemaName;
	private String DB_DRIV;
	private String DB_URL;
	private String DB_USER;
	private String DB_PASS;
	
	public TargetDAOImpl(String schemaName, String DB_URL, String DB_USER, String DB_PASS) {
		this.schemaName = schemaName;
		this.DB_URL = DB_URL;
		this.DB_USER = DB_USER;
		this.DB_PASS = DB_PASS;
	}

	@Override
	public void generateRules(ArrayList<BusinessRule> rules) {
		// TODO Auto-generated method stub
        for(BusinessRule b : rules){
            String dbType = "Oracle";
            Generate g =  GenerateFactory.doGenerate(dbType);
            String sql = g.generateCode(b);
        }
    }

/*	@Override
	public void generateTrigger(BusinessRule br) {
		// TODO Auto-generated method stub
		
	}*/

	@Override
	public Connection getConnection() {
		if (this.schemaName.equals("Oracle")) {
			this.DB_DRIV = "oracle.jdbc.driver.OracleDriver";
		}
		return null;
	}

}
