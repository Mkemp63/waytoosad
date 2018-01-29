package nl.hu.v2tosad.data.model;
//POJO
public class TupleCompareRule extends BusinessRule{
	private int compareRuleId;
	private String column;
	private String compareColumn;
	private String operator;

	
	public TupleCompareRule(BusinessRule br, int compareRuleId, String column, String compareColumn, String operator) {
		super(br.id, br.status, br.dateModified, br.code, br.businessRuleType, br.rule_Name, br.discription, br.tableName);
		this.compareRuleId = compareRuleId;
		this.column = column;
		this.compareColumn= compareColumn;
		this.operator = operator;
	}

    public String generateCode(String dbType){
     /*   Generate g = new GenerateFactory(dbType);
        return g.generateTupleCompareRule();*/
        return null;
    }

	public String getColumn() {
		return column;
	}

	public String getOperator() {
		return operator;
	}

	public String getCompareColumn() {
		return compareColumn;
	}
}
