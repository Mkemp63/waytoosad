package nl.hu.v2tosad.data.model;

import nl.hu.v2tosad.data.generator.Generator;
import nl.hu.v2tosad.data.generator.GeneratorFactory;

//POJO
public class AttributeRangeRule extends BusinessRule{
	private int rangeRuleId;
	private int minVal;
	private int maxVal;
	private String operator;
	private String column;


	public AttributeRangeRule(BusinessRule br, int rangeRuleId, int minVal, int maxVal, String operator, String column) {
		super(br.id, br.status, br.dateModified, br.code, br.businessRuleType, br.rule_Name, br.discription, br.tableName, br.schemaID);
		this.rangeRuleId = rangeRuleId;
		this.minVal = minVal;
		this.maxVal = maxVal;
		this.operator = operator;
		this.column = column;
	}

    public String generateCode(String dbType){
    	Generator gen = GeneratorFactory.getGenerator(dbType);
        return gen.generateAttributeRangeRule(this);
    }

	public int getRangeRuleId() {
		return rangeRuleId;
	}

    public int getMinVal() {
		return minVal;
	}

    public int getMaxVal() {
		return maxVal;
	}

    public String getOperator() {
		return operator;
	}

    public String getColumn() {
		return column;
	}

}
