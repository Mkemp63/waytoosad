package nl.hu.v2tosad.data.model;

import java.sql.Date;

public class AttributeRangeRule extends BusinessRule{
	private int rangeRuleId;
	private int minval;
	private int maxval;
	private String operator;
	private String column;
	
	public AttributeRangeRule() {
		
	}
	
	public AttributeRangeRule(int id, String status, Date dateModified, String code, String businessRuleType, String rule_Name, String discription, String tableName, int rangeRuleId, int minval, int maxval, String operator, String column) {
		super(id, status, dateModified, code, businessRuleType, rule_Name, discription, tableName);
		this.rangeRuleId = rangeRuleId;
		this.minval = minval;
		this.maxval = maxval;
		this.operator = operator;
		this.column = column;
	}
	
	public AttributeRangeRule(BusinessRule br, int rangeRuleId, int minval, int maxval, String operator, String column) {
		super(br.id, br.status, br.dateModified, br.code, br.businessRuleType, br.rule_Name, br.discription, br.tableName);
		this.rangeRuleId = rangeRuleId;
		this.minval = minval;
		this.maxval = maxval;
		this.operator = operator;
		this.column = column;
	}
	
	public String generateCode() {
		//TODO
		return null;
	}

	public int getRangeRuleId() {
		return rangeRuleId;
	}

	public void setRangeRuleId(int rangeRuleId) {
		this.rangeRuleId = rangeRuleId;
	}

	public int getMinval() {
		return minval;
	}

	public void setMinval(int minval) {
		this.minval = minval;
	}

	public int getMaxval() {
		return maxval;
	}

	public void setMaxval(int maxval) {
		this.maxval = maxval;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}
	

}
