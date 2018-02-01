package nl.hu.v2tosad.domain.service;

import nl.hu.v2tosad.data.dao.RepositoryDAO;
import nl.hu.v2tosad.data.dao.TargetDAO;
import nl.hu.v2tosad.data.model.BusinessRule;

import java.util.ArrayList;

// class to give structure in application
public class BusinessRuleService implements ApplicationService {
	private ArrayList<BusinessRule> allRules = new ArrayList<BusinessRule>();
	private final RepositoryDAO repo = new RepositoryDAO();
    private TargetDAO targetDAO;

    // Method to write the constraints/triggers in the target database
    public void startGenerating(ArrayList<Integer> idList) {
        allRules = this.getBusinesRuleDetails(idList);
        getTarget();
        targetDAO.generateRules(allRules);

    }
    
    // Method to get a list of BusinessRule-objects from a list of id's
    private ArrayList<BusinessRule> getBusinesRuleDetails(ArrayList<Integer> idList) {
        System.out.println("Start generating rules");
        allRules = repo.getAllBusinessRules(idList);
        System.out.println(allRules);
        return allRules;
    }
    
    // Method to update existing constraints/triggers in the target database.
    public void startUpdating(int id) {
    	ArrayList<Integer> idList= new ArrayList<Integer>();
    	idList.add(id);
    	allRules = this.getBusinesRuleDetails(idList);
    	getTarget();
    	
    	// Here the rules are dropped first
    	targetDAO.dropRules(allRules);
    	
    	// Here the new rules are generated again
    	targetDAO.generateRules(allRules);
    }
    
    // Method to delete the businessrules from the target database and from the repository database
    public void deleteRules(ArrayList<Integer> idList) {
        allRules = this.getBusinesRuleDetails(idList);
        getTarget();
        targetDAO.dropRules(allRules);
        
        // Here the businessrules from the repository database
        repo.deleteRules(idList);
    }

    // Method to delete the businessrules from the target database, but not from the repository database
    public void deactivateRules(ArrayList<Integer> idList) {
        allRules = this.getBusinesRuleDetails(idList);
        getTarget();
        targetDAO.dropRules(allRules);
        
        // Here the status of the businessrules in the respository database are set to "NOT ACTIVE"
        for(int id : idList) {
            repo.setRuleStatus("NOT ACTIVE", id);
        }
    }

    // Method to make connection with a target database using the schemaID of the first businessrule in the database
    private void getTarget(){
        int targetId = allRules.get(0).getSchemaID();
        targetDAO = repo.getTargetDAO(targetId);
    }

    // Get the ID of every businessrule in the repository database
    public void getAllRuleIds(){
        startGenerating(repo.getAllRuleIds());
    }
}

