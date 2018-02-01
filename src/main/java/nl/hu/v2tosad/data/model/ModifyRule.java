package nl.hu.v2tosad.data.model;

import nl.hu.v2tosad.data.generator.Generator;
import nl.hu.v2tosad.data.generator.GeneratorFactory;

public class ModifyRule extends BusinessRule{
	private int modifyRuleId;
	private String plSqlCode;

	
	public ModifyRule(BusinessRule br, int modifyRuleId, String plSqlCode) {
		super(br.id, br.status, br.dateModified, br.code, br.businessRuleType, br.rule_Name, br.discription, br.tableName, br.schemaID);
		this.modifyRuleId = modifyRuleId;
		this.plSqlCode = plSqlCode;
	}

    public String generateCode(String dbType){
        Generator g = GeneratorFactory.getGenerator(dbType);
        return g.generateModifyRule(this);
    }

    @Override
    public String toString() {
        return super.toString()+"ModifyRule{" +
                "modifyRuleId=" + modifyRuleId +
                ", plSqlCode='" + plSqlCode + '\'' +
                '}'+'}';
    }
}
