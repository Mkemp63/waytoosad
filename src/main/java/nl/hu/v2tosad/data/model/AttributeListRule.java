package nl.hu.v2tosad.data.model;

import java.util.ArrayList;

import nl.hu.v2tosad.data.generator.Generator;
import nl.hu.v2tosad.data.generator.GeneratorFactory;
//POJO
public class AttributeListRule extends BusinessRule{
	private int listRuleId;
	private String column;
	private String operator;
	private ArrayList<String> compareValue = new ArrayList<String>();

	
	public AttributeListRule(BusinessRule br, int listRuleId, String column, String operator) {
		super(br.id, br.status, br.dateModified, br.code, br.businessRuleType, br.rule_Name, br.discription, br.tableName, br.schemaID);
		this.listRuleId = listRuleId;
		this.column = column;
		this.operator = operator;
	}
	
    public String generateCode(String dbType){
    	Generator gen = GeneratorFactory.getGenerator(dbType);
    	return gen.generateAttributeListRule(this);
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
