package main.java.nl.hu.v2tosad.data;

import main.java.nl.hu.v2tosad.model.Businessrule;


import java.sql.*;
import java.util.ArrayList;

public class businessruleDAOImpl implements businessruleDAO {
    private ArrayList<Businessrule> rules;

    public businessruleDAOImpl(){
        //legt de connectie met de db en haalt alle rules op en slaat ze op in list
        rules = new ArrayList<Businessrule>();
        // conect to db.
        BaseDAO base = new BaseDAO();
        base.getConnection();
        try (Connection conn = base.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from businessrule");

            while (rs.next()) {
                int id = rs.getInt("ID");
                String code = rs.getString("code");
                String rulename = rs.getString("rulename");
                String businessruleType = rs.getString("businessruleType");
                String discription = rs.getString("discription");
                String tablename = rs.getString("tablename");
                String status = rs.getString("status");
                String dateModified = rs.getString("dateModified");

                Businessrule b = new Businessrule(id,code, rulename, businessruleType, discription,tablename,status,dateModified);
                rules.add(b);   //save all rules in list.
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    @Override
    public ArrayList<Businessrule> getAllBusinessrules() {
        return rules;
    }

    @Override
    public ArrayList<Businessrule> getBusinessrulesByID(ArrayList<Integer> idList) {
        ArrayList<Businessrule> out = new ArrayList<Businessrule>();
        for (int i : idList){
            for (Businessrule r: rules){
                if (i == r.getId()){
                    out.add(r);
                }
            }
        }
        return out;
    }

    @Override
    public void setStatus(Businessrule rule, String status) {
        BaseDAO base = new BaseDAO();
        base.getConnection();
        try (Connection conn = base.getConnection()) {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("UPDATE businessrule Set status = 'Implementing' where id = "+rule.getId()+" ;");

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}

