package nl.hu.v2tosad.data.model;

public class ModifyRule extends BusinessRule{
	private int modifyRuleId;
	private String plSqlCode;
	
	public ModifyRule() {
		
	}
	
	public ModifyRule(BusinessRule br, int modifyRuleId, String plSqlCode) {
		super(br.id, br.status, br.dateModified, br.code, br.businessRuleType, br.rule_Name, br.discription, br.tableName);
		this.modifyRuleId = modifyRuleId;
		this.plSqlCode = plSqlCode;
	}
	
	//TODO
	/*public String generateCode() {
		
	}*/
}
