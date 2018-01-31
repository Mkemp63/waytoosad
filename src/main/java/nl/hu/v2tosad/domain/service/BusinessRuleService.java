package nl.hu.v2tosad.domain.service;

import nl.hu.v2tosad.data.dao.RepositoryDAO;
import nl.hu.v2tosad.data.dao.TargetDAO;
import nl.hu.v2tosad.data.model.BusinessRule;

import java.util.ArrayList;
// class to give structure in application

public class BusinessRuleService implements ApplicationService {
	private ArrayList<BusinessRule> allRules = new ArrayList<BusinessRule>();
	private RepositoryDAO repo = new RepositoryDAO();

    public void startGenerating(ArrayList<Integer> idList) {
    	this.getBusinesRuleDetails(idList);
    	
        int targetId = allRules.get(0).getSchemaID();
        TargetDAO targetDAO = repo.getTargetDAO(targetId);
        
        targetDAO.generateRules(allRules);
    }
    
    public void startUpdating(int id) {
    	ArrayList<Integer> idList= new ArrayList<Integer>();
    	idList.add(id);
    	this.getBusinesRuleDetails(idList);
    	
    	int targetId = allRules.get(0).getSchemaID();
    	TargetDAO targetDAO = repo.getTargetDAO(targetId);
    	
    	targetDAO.dropRules(allRules);
    	targetDAO.generateRules(allRules);
    }
    
    public ArrayList<BusinessRule> getBusinesRuleDetails(ArrayList<Integer> idList) {
        System.out.println("Start generating rules");
        allRules = repo.getAllBusinessRules(idList);
        System.out.println(allRules);
        return allRules;
    }
}
