package nl.hu.v2tosad.data.model;

import java.util.ArrayList;
//POJO
public class AttributeListRule extends BusinessRule{
	private int listRuleId;
	private String column;
	private String operator;
	private ArrayList<String> compareValue = new ArrayList<String>();
	private String listTable;

	
	public AttributeListRule(BusinessRule br, int listRuleId, String column, String operator, String listTable) {
		super(br.id, br.status, br.dateModified, br.code, br.businessRuleType, br.rule_Name, br.discription, br.tableName);
		this.listRuleId = listRuleId;
		this.column = column;
		this.operator = operator;
		this.listTable = listTable;
	}
	
	public String generateCode() {
		StringBuilder result = new StringBuilder("alter table TOSAD_2017_2B_TEAM2_TARGET." + super.getTableName());
		result.append(" add constraint " + super.getCode());
		result.append("check (" + column + " " + operator + "(" + compareValue);
		for (String s : compareValue) {
			if (compareValue.indexOf(s) == 0) {
				result.append("'" + s + "'");
			}
			else { 
				result.append(", '" + s + "'");
			}
		}
		result.append("))");
		System.out.println(result.toString());
		return result.toString();
	}
	
	public void addValue(String item) {
		this.compareValue.add(item);
	}
	public void removeValue(String item) {
		this.compareValue.remove(item);
	}

}
