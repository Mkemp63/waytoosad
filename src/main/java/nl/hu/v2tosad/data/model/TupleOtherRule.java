package nl.hu.v2tosad.data.model;
//POJO
public class TupleOtherRule extends BusinessRule{
	private int otherRuleId;
	private String columnName;
	private String plSqlCode;

	
	public TupleOtherRule(BusinessRule br, int otherRuleId, String columnName, String plSqlCode) {
		super(br.id, br.status, br.dateModified, br.code, br.businessRuleType, br.rule_Name, br.discription, br.tableName, br.schemaID);
		this.otherRuleId = otherRuleId;
		this.columnName = columnName;
		this.plSqlCode = plSqlCode;
	}

    public String generateCode(String dbType){
/*        Generate g = new GenerateFactory(dbType);
        return g.generateTupleOtherRule();*/
        return null;
    }

    @Override
    public String toString() {
        return super.toString()+"TupleOtherRule{" +
                "otherRuleId=" + otherRuleId +
                ", columnName='" + columnName + '\'' +
                ", plSqlCode='" + plSqlCode + '\'' +
                '}'+'}';
    }
}
