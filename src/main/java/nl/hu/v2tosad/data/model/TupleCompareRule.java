package nl.hu.v2tosad.data.model;
//POJO
public class TupleCompareRule extends BusinessRule{
	private int compareRuleId;
	private String column;
	private String compareColumn;
	private String operator;
	
	public TupleCompareRule() {
		
	}
	
	public TupleCompareRule(BusinessRule br, int compareRuleId, String column, String compareColumn, String operator) {
		super(br.id, br.status, br.dateModified, br.code, br.businessRuleType, br.rule_Name, br.discription, br.tableName);
		this.compareRuleId = compareRuleId;
		this.column = column;
		this.compareColumn= compareColumn;
		this.operator = operator;
	}
	
	public String generateCode() {
		StringBuilder result = new StringBuilder("alter table TOSAD_2017_2B_TEAM2_TARGET." + super.getTableName());
		result.append(" add constraint " + super.getCode());
		result.append("check (" + column + operator + compareColumn);
		result.append(");");
		System.out.println(result.toString());
		return result.toString();
	}
}
