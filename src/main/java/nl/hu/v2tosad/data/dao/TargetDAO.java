package nl.hu.v2tosad.data.dao;

import nl.hu.v2tosad.data.model.BusinessRule;

import java.sql.Connection;
import java.util.ArrayList;
// interface to implement generated code in target db
public interface TargetDAO {
    public abstract Connection getConnection();
	public void closeConnection();
    public void generateRules(ArrayList<BusinessRule> rules, RepositoryDAO repo);
    public String implementRule(String sql);


}
