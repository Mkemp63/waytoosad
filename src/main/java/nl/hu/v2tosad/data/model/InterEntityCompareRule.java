package nl.hu.v2tosad.data.model;

import nl.hu.v2tosad.data.generator.Generator;
import nl.hu.v2tosad.data.generator.GeneratorFactory;

public class InterEntityCompareRule extends BusinessRule{
	private int interEntityCompareRuleId;
	private String columnName;
	private String tableName2;
	private String columnName2;
	private String operator;
	private String afk;


    public InterEntityCompareRule(BusinessRule br, int interEntityCompareRuleId, String columnName, String tableName2, String columnName2, String operator, String afk) {
		super(br.id, br.status, br.dateModified, br.code, br.businessRuleType, br.rule_Name, br.discription, br.tableName, br.schemaID);
		this.interEntityCompareRuleId = interEntityCompareRuleId;
		this.columnName = columnName;
		this.tableName2 = tableName2;
		this.columnName2 = columnName2;
		this.operator = operator;
		this.afk = afk;
	}

	public String generateCode(String dbType){
		Generator gen = GeneratorFactory.getGenerator(dbType);
        return gen.generateInterEntityCompareRule(this);
    }

	@Override
    public String toString() {
        return super.toString()+"InterEntityCompareRule{" +
                "interEntityCompareRuleId=" + interEntityCompareRuleId +
                ", columnName='" + columnName + '\'' +
                ", tableName2='" + tableName2 + '\'' +
                ", columnName2='" + columnName2 + '\'' +
                ", operator='" + operator + '\'' +
                '}'+'}';
    }

	public String getOperator() {
		return operator;
	}

	public String getColumnName() {
		return columnName;
	}

	public String getTableName2() {
		return tableName2;
	}

	public String getColumnName2() {
		return columnName2;
	}
	public String getAfk() {
		return afk;
	}
}
