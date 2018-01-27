package nl.hu.v2tosad.data.model;

import java.util.Date;

public class BusinessRule {
	protected int id;
	protected String status;
	protected Date dateModified;
	protected String code;
	protected String businessRuleType;
	protected String rule_Name;
	protected String discription;
	protected String tableName;
	
	public BusinessRule() {
	
	}
	public BusinessRule(int id, String status, Date dateModified, String code, String businessRuleType, String rule_Name, String discription, String tableName) {
		this.id = id;
		this.status = status;
		this.dateModified = dateModified;
		this.code = code;
		this.businessRuleType = businessRuleType;
		this.rule_Name = rule_Name;
		this.discription = discription;
		this.tableName = tableName;
	}
	
	public String generateCode() {
		return null;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDateModified() {
		return dateModified;
	}
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getBusinessRuleType() {
		return businessRuleType;
	}
	public void setBusinessRuleType(String businessRuleType) {
		this.businessRuleType = businessRuleType;
	}
	public String getRule_Name() {
		return rule_Name;
	}
	public void setRule_Name(String rule_Name) {
		this.rule_Name = rule_Name;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
