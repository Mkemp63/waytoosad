package nl.hu.v2tosad.data.model;

public class EntityOtherRule extends BusinessRule {
	private int otherRuleId;
	private String columnName;
	private String plSqlCode;
	
	public EntityOtherRule() {
		
	}
	
	public EntityOtherRule (BusinessRule br, int otherRuleId, String columnName, String plSqlCode) {
		super(br.id, br.status, br.dateModified, br.code, br.businessRuleType, br.rule_Name, br.discription, br.tableName);
		this.otherRuleId = otherRuleId;
		this.columnName = columnName;
		this.plSqlCode = plSqlCode;
	}
	//TODO
	/*public String GenerateCode() {
		
	}*/
}
