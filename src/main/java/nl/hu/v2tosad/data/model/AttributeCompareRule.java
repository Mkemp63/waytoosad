package nl.hu.v2tosad.data.model;

//POJO
public class AttributeCompareRule extends BusinessRule{
	private int compareRuleId;
	private String compareName;
	private String compareValue;
	private String operator;
	
	public AttributeCompareRule() {
		
	}
	
	public AttributeCompareRule(BusinessRule br, int compareRuleId, String compareName, String compareValue, String operator) {
		super(br.id, br.status, br.dateModified, br.code, br.businessRuleType, br.rule_Name, br.discription, br.tableName);
		this.compareRuleId = compareRuleId;
		this.compareName = compareName;
		this.compareValue = compareValue;
		this.operator = operator;
	}
	
	public String generateCode() {
		//TODO
		return null;
	}

	public int getCompareRuleId() {
		return compareRuleId;
	}

	public void setCompareRuleId(int compareRuleId) {
		this.compareRuleId = compareRuleId;
	}

	public String getCompareName() {
		return compareName;
	}

	public void setCompareName(String compareName) {
		this.compareName = compareName;
	}

	public String getCompareValue() {
		return compareValue;
	}

	public void setCompareValue(String compareValue) {
		this.compareValue = compareValue;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

}
