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

    public String generateCode(String dbType){
      /*  Generate g = new GenerateFactory(dbType);
        return g.generateAttributeListRule();*/
        return null;
    }
	
	public void addValue(String item) {
		this.compareValue.add(item);
	}
	public void removeValue(String item) {
		this.compareValue.remove(item);
	}

	public String getColumn() {
		return column;
	}

	public String getOperator() {
		return operator;
	}

	public ArrayList<String> getCompareValue() {
		return compareValue;
	}

}
