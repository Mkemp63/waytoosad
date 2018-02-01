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
	protected int schemaID;


	public BusinessRule(){

	}
	
	public BusinessRule(int id, String status, Date dateModified, String code, String businessRuleType, String rule_Name, String discription, String tableName, int schemaID) {
		this.id = id;
		this.status = status;
		this.dateModified = dateModified;
		this.code = code;
		this.businessRuleType = businessRuleType;
		this.rule_Name = rule_Name;
		this.discription = discription;
		this.tableName = tableName;
		this.schemaID = schemaID;
	}
	
	public String generateCode(String dbType) {
        return null;
    }

	public int getId() {
		return id;
	}

    public String getStatus() {
		return status;
	}

    public Date getDateModified() {
		return dateModified;
	}

    public String getCode() {
		return code;
	}

    public String getBusinessRuleType() {
		return businessRuleType;
	}

    public String getRule_Name() {
		return rule_Name;
	}

    public String getDiscription() {
		return discription;
	}

    public String getTableName() {
		return tableName;
	}

    public int getSchemaID() {
		return schemaID;
	}

    @Override
    public String toString() {
        return "BusinessRule{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", dateModified=" + dateModified +
                ", code='" + code + '\'' +
                ", businessRuleType='" + businessRuleType + '\'' +
                ", rule_Name='" + rule_Name + '\'' +
                ", discription='" + discription + '\'' +
                ", tableName='" + tableName + '\'' +", "
                ;
    }
}
