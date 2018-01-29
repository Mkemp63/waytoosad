package nl.hu.v2tosad.data.model;

//POJO
public class AttributeRangeRule extends BusinessRule{
	private int rangeRuleId;
	private int minVal;
	private int maxVal;
	private String operator;
	private String column;


	public AttributeRangeRule(BusinessRule br, int rangeRuleId, int minVal, int maxVal, String operator, String column) {
		super(br.id, br.status, br.dateModified, br.code, br.businessRuleType, br.rule_Name, br.discription, br.tableName);
		this.rangeRuleId = rangeRuleId;
		this.minVal = minVal;
		this.maxVal = maxVal;
		this.operator = operator;
		this.column = column;
	}

    public String generateCode(String dbType){
 /*       Generate g = new GenerateFactory(dbType);
        return g.generateAttributeRangeRule();*/
        return null;

    }

	public int getRangeRuleId() {
		return rangeRuleId;
	}

	public void setRangeRuleId(int rangeRuleId) {
		this.rangeRuleId = rangeRuleId;
	}

	public int getMinval() {
		return minVal;
	}

	public void setMinval(int minVal) {
		this.minVal = minVal;
	}

	public int getMaxval() {
		return maxVal;
	}

	public void setMaxval(int maxVal) {
		this.maxVal = maxVal;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}
	

}
