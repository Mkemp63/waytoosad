package nl.hu.v2tosad.data.model;

import java.util.ArrayList;
//POJO
public class AttributeListRule extends BusinessRule{
	private int listRuleId;
	private String columnName;
	private String operator;
	private ArrayList<String> compareValue = new ArrayList<String>();
	
	public AttributeListRule() {
		
	}
	
	public AttributeListRule(BusinessRule br, int listRuleId, String columnName, String operator) {
		super(br.id, br.status, br.dateModified, br.code, br.businessRuleType, br.rule_Name, br.discription, br.tableName);
		this.listRuleId = listRuleId;
		this.columnName = columnName;
		this.operator = operator;
	}
	
	public String generateCode() {
		//TODO
		return null;
	}
	
	public void addValue(String item) {
		this.compareValue.add(item);
	}
	public void removeValue(String item) {
		this.compareValue.remove(item);
	}

	public int getListRuleId() {
		return listRuleId;
	}

	public void setListRuleId(int listRuleId) {
		this.listRuleId = listRuleId;
	}

    @Override
    public String toString() {
        return super.toString()+"AttributeListRule{" +
                "listRuleId=" + listRuleId +
                ", columnName='" + columnName + '\'' +
                ", operator='" + operator + '\'' +
                ", compareValue=" + compareValue +
                '}'+'}';
    }
}
