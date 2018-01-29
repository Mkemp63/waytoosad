package nl.hu.v2tosad.data.model;

import java.sql.Date;
//POJO
public class AttributeRangeRule extends BusinessRule{
	private int rangeRuleId;
	private int minVal;
	private int maxVal;
	private String operator;
	private String column;


	public AttributeRangeRule(BusinessRule br, int rangeRuleId, int minVal, int maxVal, String operator, String column) {
		super(br.id, br.status, br.dateModified, br.code, br.businessRuleType, br.rule_Name, br.discription, br.tableName);
		this.rangeRuleId = rangeRuleId;
		this.minVal = minVal;
		this.maxVal = maxVal;
		this.operator = operator;
		this.column = column;
	}
	
	public String generateCode() {
		StringBuilder result = new StringBuilder("alter table TOSAD_2017_2B_TEAM2_TARGET." + super.getTableName());
		result.append(" add constraint " + super.getCode());
		result.append("check (" + column + " " + operator + " " + minVal);
		result.append(" and " + maxVal);
		result.append(")");
		System.out.println(result.toString());
		return result.toString();
	}

	public int getRangeRuleId() {
		return rangeRuleId;
	}

	public void setRangeRuleId(int rangeRuleId) {
		this.rangeRuleId = rangeRuleId;
	}

	public int getMinval() {
		return minVal;
	}

	public void setMinval(int minVal) {
		this.minVal = minVal;
	}

	public int getMaxval() {
		return maxVal;
	}

	public void setMaxval(int maxVal) {
		this.maxVal = maxVal;
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
