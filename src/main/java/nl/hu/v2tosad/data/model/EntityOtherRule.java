package nl.hu.v2tosad.data.model;

import nl.hu.v2tosad.data.generator.Generator;
import nl.hu.v2tosad.data.generator.GeneratorFactory;

public class EntityOtherRule extends BusinessRule {
	private int otherRuleId;
	private String columnName;
	private String plSqlCode;

	
	public EntityOtherRule (BusinessRule br, int otherRuleId, String columnName, String plSqlCode) {
		super(br.id, br.status, br.dateModified, br.code, br.businessRuleType, br.rule_Name, br.discription, br.tableName, br.schemaID);
		this.otherRuleId = otherRuleId;
		this.columnName = columnName;
		this.plSqlCode = plSqlCode;
	}
	
    // Retrieves a Generator-class based on the database type given in the paramaters
 	// Then it uses the Generator-class to create a sql statment using the correct SQL statement
    public String generateCode(String dbType){
        Generator g = GeneratorFactory.getGenerator(dbType);
        return g.generateEntityOtherRule(this);
    }

    @Override
    public String toString() {
        return super.toString()+"EntityOtherRule{" +
                "otherRuleId=" + otherRuleId +
                ", columnName='" + columnName + '\'' +
                ", plSqlCode='" + plSqlCode + '\'' +
                '}'+'}';
    }
}
