package nl.hu.v2tosad.domain.service;

import nl.hu.v2tosad.data.dao.RepositoryDAO;
import nl.hu.v2tosad.data.dao.TargetDAO;
import nl.hu.v2tosad.data.dao.TargetDAOImpl;
import nl.hu.v2tosad.data.model.BusinessRule;
import nl.hu.v2tosad.data.model.Database;

import java.util.ArrayList;
// class to give structure in application

public class BusinessRuleService implements ApplicationService {
	private RepositoryDAO repo = new RepositoryDAO();
	private ArrayList<TargetDAO> targetDatabases = new ArrayList<TargetDAO>();
	private ArrayList<BusinessRule> allRules = new ArrayList<BusinessRule>();
	private TargetDAO target;
	

	
	//TODO
/*	public void generateCode(ArrayList<BusinessRule> br) {
		this.target.generateConstraint(br);
	}*/
	
	public void addTargetSchema(Database db) {
		this.target = new TargetDAOImpl(db);
	}

    public void startGenerating(ArrayList<Integer> rulelist) {
        System.out.println("Start generating rules");
        ArrayList<BusinessRule> rules = repo.getBusinessRules(rulelist);
        System.out.println("VERBINDING");
        int targetId = rules.get(0).getSchemaID();
        TargetDAO targetDAO = repo.getTargetDAO(targetId);
        
        targetDAO.generateRules(rules);
        
//        System.out.println(rules);
//        Database db = repo.getTarget();
//
//        addTargetSchema(db);
//
//        target.generateRules(rules);

    }
}
