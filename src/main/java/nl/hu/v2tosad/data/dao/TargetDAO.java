package nl.hu.v2tosad.data.dao;

import nl.hu.v2tosad.data.model.BusinessRule;

import java.sql.Connection;
import java.util.ArrayList;
// interface to implement generated code in target db
public interface TargetDAO {
    Connection getConnection();
    void generateRules(ArrayList<BusinessRule> rules);
    void dropRules(ArrayList<BusinessRule> rules);
}
