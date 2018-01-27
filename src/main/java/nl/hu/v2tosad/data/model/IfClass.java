package nl.hu.v2tosad.data.model;

public class IfClass {
	
	else if (br.getBusinessRuleType().equals("Inter-Entity Compare Rule")) {
		rs = stmt.executeQuery("SELECT * FROM inter_entity_compare_rule WHERE fk_businessrule_id =" + br.getId());
		while (rs.next()) {
			br = new InterEntityCompareRule(br, rs.getInt("INTER_ENTITY_COMPARE_RULE_ID"), rs.getString("COLUMNNAME"), rs.getString("TABLENAME2"), rs.getString("COLUMNAME2"), rs.getString("OPERATOR"));
		}
	}
	else if (br.getBusinessRuleType().equals("Entity Other Rule")) {
		rs = stmt.executeQuery("SELECT * FROM other_rule WHERE fk_businessrule_id =" + br.getId());
		while (rs.next()) {
			br = new EntityOtherRule(br, rs.getInt("OTHER_RULE_ID"), rs.getString("COLUMNNAME"), rs.getString("PLSQLCODE"));
		}
	}
	else if (br.getBusinessRuleType().equals("Modify Rule")) {
		rs = stmt.executeQuery("SELECT * FROM modify_rule WHERE fk_businessrule_id =" + br.getId());
		while (rs.next()) {
			br = new ModifyRule(br, rs.getInt("MODIFY_RULE_ID"), rs.getString("PLSQLCODE"));
		}
	}
	else if (br.getBusinessRuleType().equals("Tuple Other Rule")) {
		rs = stmt.executeQuery("SELECT * FROM other_rule WHERE fk_businessrule_id =" + br.getId());
		while (rs.next()) {
			br = new ModifyRule(br, rs.getInt("OTHER_RULE_ID"), rs.getString("COLUMNNAME"), rs.getString("PLSQLCODE"));
		}
	}
	else if (br.getBusinessRuleType().equals("Tuple Compare Rule")) {
		rs = stmt.executeQuery("SELECT * FROM compare_rule WHERE fk_businessrule_id =" + br.getId());
		while (rs.next()) {
			br = new TupleCompareRule(br, rs.getInt("COMPARE_RULE_ID"), rs.getString("COLUMNNAME"), rs.getString("COMPAREVALUE"), rs.getString("OPERATORVALUE"));
		}
	}
	else if (br.getBusinessRuleType().equals("Attribute Other Rule")) {
		rs = stmt.executeQuery("SELECT * FROM other_rule WHERE fk_businessrule_id =" + br.getId());
		while (rs.next()) {
			br = new AttributeOtherRule(br, rs.getInt("OHTER_RULE_ID"), rs.getString("COLUMNNAME"), rs.getString("PLSQLCODE"));
		}
	}
}
