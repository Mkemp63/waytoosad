package nl.hu.v2tosad.domain.service;

import nl.hu.v2tosad.data.dao.RepositoryDAO;
import nl.hu.v2tosad.data.dao.TargetDAO;
import nl.hu.v2tosad.data.dao.TargetDAOImpl;
import nl.hu.v2tosad.data.model.BusinessRule;
import nl.hu.v2tosad.data.model.Database;

import java.util.ArrayList;
// class to give structure in application

public class BusinessRuleService implements ApplicationService {
	private ArrayList<BusinessRule> allRules = new ArrayList<BusinessRule>();
	
	//TODO
/*	public void generateCode(ArrayList<BusinessRule> br) {
		this.target.generateConstraint(br);
	}*/
	
//	public void addTargetSchema(Database db) {
//		this.target = new TargetDAOImpl(db);
//	}

    public void startGenerating(ArrayList<Integer> rulelist) {
    	RepositoryDAO repo = new RepositoryDAO();
        System.out.println("Start generating rules");
        allRules = repo.getBusinessRules(rulelist);
        System.out.println(allRules);
        int targetId = allRules.get(0).getSchemaID();
        TargetDAO targetDAO = repo.getTargetDAO(targetId);
        
        targetDAO.generateRules(allRules);
//        Database db = repo.getTarget();


//        addTargetSchema(db);
//
//        target.generateRules(rules);
//        repo.closeConnection();
    }
}
