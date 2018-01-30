package nl.hu.v2tosad.data.dao;

import nl.hu.v2tosad.data.model.BusinessRule;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
// interface to implement generated code in target db
public interface TargetDAO {
    public abstract Connection getConnection();
    
    public abstract void generateRules(ArrayList<BusinessRule> rules);

}
