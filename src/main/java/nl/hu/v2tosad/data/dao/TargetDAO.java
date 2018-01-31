package nl.hu.v2tosad.data.dao;

import nl.hu.v2tosad.data.model.BusinessRule;

import java.util.ArrayList;
// interface to implement generated code in target db
public interface TargetDAO {
    // --Commented out by Inspection (31/01/2018 12:49):Connection getConnection();
    void generateRules(ArrayList<BusinessRule> rules);
    void dropRules(ArrayList<BusinessRule> rules);
}
