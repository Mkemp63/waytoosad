package nl.hu.v2tosad.data.model;
//POJO
public class TupleCompareRule extends BusinessRule{
	private int compareRuleId;
	private String columnName;
	private String compareValue;
	private String operator;
	
	public TupleCompareRule() {
		
	}
	
	public TupleCompareRule(BusinessRule br, int compareRuleId, String columnName, String compareValue, String operator) {
		super(br.id, br.status, br.dateModified, br.code, br.businessRuleType, br.rule_Name, br.discription, br.tableName);
		this.compareRuleId = compareRuleId;
		this.columnName = columnName;
		this.compareValue = compareValue;
		this.operator = operator;
	}
	
	//TODO
	/*public String generateCode() {
		
	}*/

    @Override
    public String toString() {
        return super.toString()+"TupleCompareRule{" +
                "compareRuleId=" + compareRuleId +
                ", columnName='" + columnName + '\'' +
                ", compareValue='" + compareValue + '\'' +
                ", operator='" + operator + '\'' +
                '}'+'}';
    }
}
