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


    public void startGenerating(ArrayList<Integer> idList) {
        allRules = this.getBusinesRuleDetails(idList);
        getTarget();
        targetDAO.generateRules(allRules);

    }

    private ArrayList<BusinessRule> getBusinesRuleDetails(ArrayList<Integer> idList) {
        System.out.println("Start generating rules");
        allRules = repo.getAllBusinessRules(idList);
        System.out.println(allRules);
        return allRules;
    }
    public void startUpdating(int id) {
    	ArrayList<Integer> idList= new ArrayList<Integer>();
    	idList.add(id);
    	allRules = this.getBusinesRuleDetails(idList);
    	getTarget();
    	targetDAO.dropRules(allRules);
    	targetDAO.generateRules(allRules);
    }

    public void deleteRules(ArrayList<Integer> idList) {
        allRules = this.getBusinesRuleDetails(idList);
        getTarget();
        targetDAO.dropRules(allRules);
        repo.deleteRules(idList);
    }

    public void deactivateRules(ArrayList<Integer> idList) {
        allRules = this.getBusinesRuleDetails(idList);
        getTarget();
        targetDAO.dropRules(allRules);
        for(int id : idList) {
            repo.setRuleStatus("NOT ACTIVE", id);
        }
    }

    private void getTarget(){
        int targetId = allRules.get(0).getSchemaID();
        targetDAO = repo.getTargetDAO(targetId);
    }

    public void getAllRuleIds(){
        startGenerating(repo.getAllRuleIds());
    }
}

