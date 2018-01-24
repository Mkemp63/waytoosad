package main.java.nl.hu.v2tosad.data;

import nl.hu.v2tosad.model.Businessrule;

import java.util.ArrayList;

public class businessruleDAOImpl implements businessruleDAO {
    private ArrayList<Businessrule> rules;
    public businessruleDAOImpl(){
        //legt de connectie met de db en haalt alle rules op en slaat ze op in list
        rules = new ArrayList<Businessrule>();
        // conect to db.

        //save all rules in list.

    }

    @Override
    public ArrayList<Businessrule> getAllBusinessrules() {
        return rules;
    }

    @Override
    public ArrayList<Businessrule> getBusinessrulesByID(ArrayList<Integer> idList) {
        return null;
    }

    @Override
    public void setStatus(Businessrule rule, String status) {

    }
}

