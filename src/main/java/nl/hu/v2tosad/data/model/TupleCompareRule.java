package nl.hu.v2tosad.data.model;

import nl.hu.v2tosad.data.generator.Generator;
import nl.hu.v2tosad.data.generator.GeneratorFactory;

public class TupleCompareRule extends BusinessRule{
	private int compareRuleId;
	private String column;
	private String compareColumn;
	private String operator;

	
	public TupleCompareRule(BusinessRule br, int compareRuleId, String column, String compareColumn, String operator) {
		super(br.id, br.status, br.dateModified, br.code, br.businessRuleType, br.rule_Name, br.discription, br.tableName, br.schemaID);
		this.compareRuleId = compareRuleId;
		this.column = column;
		this.compareColumn= compareColumn;
		this.operator = operator;
	}

    public String generateCode(String dbType){
    	Generator gen = GeneratorFactory.getGenerator(dbType);
        return gen.generateTupleCompareRule(this);
    }

	public String getColumn() {
		return column;
	}

	public String getOperator() {
		return operator;
	}

	public String getCompareColumn() {
		return compareColumn;
	}
}
