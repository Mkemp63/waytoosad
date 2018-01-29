package nl.hu.v2tosad.data.model;
//POJO
public class ModifyRule extends BusinessRule{
	private int modifyRuleId;
	private String plSqlCode;

	
	public ModifyRule(BusinessRule br, int modifyRuleId, String plSqlCode) {
		super(br.id, br.status, br.dateModified, br.code, br.businessRuleType, br.rule_Name, br.discription, br.tableName);
		this.modifyRuleId = modifyRuleId;
		this.plSqlCode = plSqlCode;
	}

    public String generateCode(String dbType){
     /*   Generate g = new GenerateFactory(dbType);
        return g.generateModifyRule();
*/return null;
    }

    @Override
    public String toString() {
        return super.toString()+"ModifyRule{" +
                "modifyRuleId=" + modifyRuleId +
                ", plSqlCode='" + plSqlCode + '\'' +
                '}'+'}';
    }
}
