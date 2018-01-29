package nl.hu.v2tosad.data.model;
//POJO
public class EntityOtherRule extends BusinessRule {
	private int otherRuleId;
	private String columnName;
	private String plSqlCode;

	
	public EntityOtherRule (BusinessRule br, int otherRuleId, String columnName, String plSqlCode) {
		super(br.id, br.status, br.dateModified, br.code, br.businessRuleType, br.rule_Name, br.discription, br.tableName);
		this.otherRuleId = otherRuleId;
		this.columnName = columnName;
		this.plSqlCode = plSqlCode;
	}
	//TODO

    @Override
    public String toString() {
        return super.toString()+"EntityOtherRule{" +
                "otherRuleId=" + otherRuleId +
                ", columnName='" + columnName + '\'' +
                ", plSqlCode='" + plSqlCode + '\'' +
                '}'+'}';
    }
	/*public String GenerateCode() {
		
	}*/
}
