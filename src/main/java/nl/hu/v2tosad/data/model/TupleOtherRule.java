package nl.hu.v2tosad.data.model;
//POJO
public class TupleOtherRule extends BusinessRule{
	private int otherRuleId;
	private String columnName;
	private String plSqlCode;
	
	public TupleOtherRule() {
		
	}
	
	public TupleOtherRule(BusinessRule br, int otherRuleId, String columnName, String plSqlCode) {
		super(br.id, br.status, br.dateModified, br.code, br.businessRuleType, br.rule_Name, br.discription, br.tableName);
		this.otherRuleId = otherRuleId;
		this.columnName = columnName;
		this.plSqlCode = plSqlCode;
	}
	
	//TODO
	/*public String generateCode() {
		
	}*/

    @Override
    public String toString() {
        return super.toString()+"TupleOtherRule{" +
                "otherRuleId=" + otherRuleId +
                ", columnName='" + columnName + '\'' +
                ", plSqlCode='" + plSqlCode + '\'' +
                '}'+'}';
    }
}
