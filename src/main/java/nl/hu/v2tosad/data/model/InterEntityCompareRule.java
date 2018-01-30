package nl.hu.v2tosad.data.model;
//POJO
public class InterEntityCompareRule extends BusinessRule{
	private int interEntityCompareRuleId;
	private String columnName;
	private String tableName2;
	private String columnName2;
	private String operator;
	private int id;
	private int fk_id;


<<<<<<< HEAD
    public InterEntityCompareRule(BusinessRule br, int interEntityCompareRuleId, String columnName, String tableName2, String columnName2, String operator, int id, int fk_id) {
		super(br.id, br.status, br.dateModified, br.code, br.businessRuleType, br.rule_Name, br.discription, br.tableName);
=======
    public InterEntityCompareRule(BusinessRule br, int interEntityCompareRuleId, String columnName, String tableName2, String columnName2, String operator) {
		super(br.id, br.status, br.dateModified, br.code, br.businessRuleType, br.rule_Name, br.discription, br.tableName, br.schemaID);
>>>>>>> branch 'master' of https://github.com/Mkemp63/waytoosad.git
		this.interEntityCompareRuleId = interEntityCompareRuleId;
		this.columnName = columnName;
		this.tableName2 = tableName2;
		this.columnName2 = columnName2;
		this.operator = operator;
		this.id = id;
		this.fk_id = fk_id;
	}

	public String generateCode(String dbType){
 /*       Generate g = new GenerateFactory(dbType);
        return g.generateInterEntityCompareRule();*/
        return null;
    }

	@Override
    public String toString() {
        return super.toString()+"InterEntityCompareRule{" +
                "interEntityCompareRuleId=" + interEntityCompareRuleId +
                ", columnName='" + columnName + '\'' +
                ", tableName2='" + tableName2 + '\'' +
                ", columnName2='" + columnName2 + '\'' +
                ", operator='" + operator + '\'' +
                '}'+'}';
    }

	public String getOperator() {
		return operator;
	}

	public String getColumnName() {
		return columnName;
	}

	public String getTableName2() {
		return tableName2;
	}

	public String getColumnName2() {
		return columnName2;
	}
	public int getId() {
		return id;
	}
	public int getFk_Id() {
		return fk_id;
	}
}
