package nl.hu.v2tosad.data.model;
//POJO
public class AttributeOtherRule extends BusinessRule{
	private int otherRuleId;
	private String columnName;
	private String plSqlCode;

	
	public AttributeOtherRule(BusinessRule br, int otherRuleId, String columnName, String plSqlCode) {
		super(br.id, br.status, br.dateModified, br.code, br.businessRuleType, br.rule_Name, br.discription, br.tableName, br.schemaID);
		this.otherRuleId = otherRuleId;
		this.columnName = columnName;
		this.plSqlCode = plSqlCode;
	}
	

    public String generateCode(String dbType){/*
        Generate g = new GenerateFactory(dbType);
        return g.generateAttributeOtherRule();*/
        return null;
    }

    @Override
    public String toString() {
        return super.toString()+"AttributeOtherRule{" +
                "otherRuleId=" + otherRuleId +
                ", columnName='" + columnName + '\'' +
                ", plSqlCode='" + plSqlCode + '\'' +
                '}'+'}';
    }
}
