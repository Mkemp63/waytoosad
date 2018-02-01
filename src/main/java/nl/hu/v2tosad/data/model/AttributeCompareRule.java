package nl.hu.v2tosad.data.model;

import nl.hu.v2tosad.data.generator.Generator;
import nl.hu.v2tosad.data.generator.GeneratorFactory;

public class AttributeCompareRule extends BusinessRule{
	private int compareRuleId;
	private String compareName;
	private String compareValue;
	private String operator;
	private String column;


	public AttributeCompareRule(BusinessRule br, int compareRuleId, String compareName, String compareValue, String operator, String column) {
		super(br.id, br.status, br.dateModified, br.code, br.businessRuleType, br.rule_Name, br.discription, br.tableName, br.schemaID);
		this.compareRuleId = compareRuleId;
		this.compareName = compareName;
		this.compareValue = compareValue;
		this.operator = operator;
		this.column = column;
	}

	// Retrieves a Generator-class based on the database type given in the paramaters
	// Then it uses the Generator-class to create a sql statment using the correct SQL statement
    public String generateCode(String dbType){
    	Generator gen = GeneratorFactory.getGenerator(dbType);
    	return gen.generateAttributeCompareRule(this);
    }

	public int getCompareRuleId() {
		return compareRuleId;
	}

    public String getCompareName() {
		return compareName;
	}

    public String getCompareValue() {
		return compareValue;
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

}
