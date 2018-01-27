package nl.hu.v2tosad.domain.service;

import nl.hu.v2tosad.data.dao.RepositoryDAO;
import nl.hu.v2tosad.data.dao.TargetDAO;
import nl.hu.v2tosad.data.dao.TargetDAOImpl;
import nl.hu.v2tosad.data.model.BusinessRule;

import java.util.ArrayList;
// class to give structure in application
public class BusinessRuleService implements ApplicationService {
	private RepositoryDAO repo = new RepositoryDAO();
	private ArrayList<TargetDAO> targetDatabases = new ArrayList<TargetDAO>();
	private ArrayList<BusinessRule> allRules = new ArrayList<BusinessRule>();
	private TargetDAO target;
	
	//TODO
	public void getRuleDetails(int id) {
		allRules.add(repo.getBusinessRule(id));
		target.generateConstraint(allRules);
	}
	
	//TODO
	public void generateCode(ArrayList<BusinessRule> br) {
		this.target.generateConstraint(br);
	}
	
	public void addTargetSchema(String dbName, String DB_URL, String DB_USER, String DB_PASS) {
		this.target = new TargetDAOImpl(dbName, DB_URL, DB_USER, DB_PASS);
	}
	
	public BusinessRule getBusinessRule(int id) {
		return repo.getBusinessRule(id);
	}

}
