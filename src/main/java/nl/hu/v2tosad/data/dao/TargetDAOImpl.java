package nl.hu.v2tosad.data.dao;

import nl.hu.v2tosad.data.model.BusinessRule;
import nl.hu.v2tosad.data.model.Database;
import nl.hu.v2tosad.data.model.Generate;
import nl.hu.v2tosad.data.model.GenerateFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

// implements generated code in target db
public class TargetDAOImpl implements TargetDAO {
    private Connection conn;
/*    private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL = "jdbc:oracle:thin:@ondora02.hu.nl:8521/cursus02.hu.nl";
    private static final String DB_USER = "tosad_2017_2b_team2_target";
    private static final String DB_PASS = "tosad_2017_2b_team2_target";*/

    private String schemaName;
 	private String DB_DRIV;
 	private String DB_URL;
 	private String DB_USER;
 	private String DB_PASS;

    public TargetDAOImpl(Database db) {
        this.schemaName = db.getDb_driv();
        this.DB_URL = db.getDb_url();
        this.DB_USER = db.getDb_user();
        this.DB_PASS = db.getDb_pass();
        this.DB_DRIV = db.getDb_driv();
        try {
            Class.forName(DB_DRIV).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
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

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void generateRules(ArrayList<BusinessRule> rules) {
        // TODO Auto-generated method stub
        for (BusinessRule b : rules) {
            System.out.println("targetDAOimpl input = " + b);
            String dbType = "Oracle";
            Generate g = GenerateFactory.doGenerate(dbType);
            String sql = g.generateCode(b);
            System.out.println(sql);

            //zet in db
        }
        closeConnection();
    }
}


