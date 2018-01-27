package nl.hu.v2tosad.data.model;

public class InterEntityCompareRule extends BusinessRule{
	private int interEntityCompareRuleId;
	private String columnName;
	private String tableName2;
	private String columnName2;
	private String operator;
	
	public InterEntityCompareRule() {
		
	}
	
	public InterEntityCompareRule(BusinessRule br, int interEntityCompareRuleId, String columnName, String tableName2, String columnName2, String operator) {
		super(br.id, br.status, br.dateModified, br.code, br.businessRuleType, br.rule_Name, br.discription, br.tableName);
		this.interEntityCompareRuleId = interEntityCompareRuleId;
		this.columnName = columnName;
		this.tableName2 = tableName2;
		this.columnName2 = columnName2;
		this.operator = operator;
	}
	
	//TODO
	/*public String generateCode() {
		
	}*/
}
