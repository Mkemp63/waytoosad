package nl.hu.v2tosad.data.model;

public class GenerateImplOracle implements Generate{

    public String generateCode(BusinessRule b){
        String type = b.getBusinessRuleType();
        System.out.println("generateImplOracle generate code input= " +b);
        if (b instanceof AttributeCompareRule){
            AttributeCompareRule c = (AttributeCompareRule) b;
            System.out.println("generate instanceof = "+c);
            return generateAttributeCompareRule(c);

        }else {return "";}
    }

    @Override
    public String generateAttributeCompareRule(AttributeCompareRule c) {
        System.out.println("AttributeCompareRule in = " +c);
        StringBuilder result = new StringBuilder("alter table TOSAD_2017_2B_TEAM2_TARGET." + c.tableName);
        result.append(" add constraint " + c.code);
        result.append("check (" + c.getColumn() + c.getOperator() + c.getCompareValue() );
        result.append(")");
        System.out.println(result.toString());
        return result.toString();
    }

   @Override
    public String generateAttributeListRule(AttributeListRule l) {
	   StringBuilder result = new StringBuilder("alter table TOSAD_2017_2B_TEAM2_TARGET." + l.getTableName());
		result.append(" add constraint " + l.getCode());
		result.append(" check (" + l.getColumn() + " " + l.getOperator() + " (" + l.getCompareValue());
		for (String s : l.getCompareValue()) {
			if (l.getCompareValue().indexOf(s) == 0) {
				result.append("'" + s + "'");
			}
			else { 
				result.append(", '" + s + "'");
			}
		}
		result.append("))");
		return result.toString();
	}

   @Override
   public String generateAttributeRangeRule(AttributeRangeRule r) {
		StringBuilder result = new StringBuilder("alter table TOSAD_2017_2B_TEAM2_TARGET." + r.getTableName());
		result.append(" add constraint " + r.getCode());
		result.append(" check (" + r.getColumn() + " " + r.getOperator() + " " + r.getMinVal());
		result.append(" and " + r.getMaxVal());
		result.append(")NOVALIDATE");
		return result.toString();
	}

@Override
public String generateInterEntityCompareRule(InterEntityCompareRule i) {
	StringBuilder result = new StringBuilder("create or replace trigger " + i.getCode());
	result.append("\nbefore or update on table TOSAD_2017_2B_TEAM2_TARGET." + i.getTableName());
	result.append("\nfor each row \ndeclare \nv_result varchar2; \nbegin \ncase TOSAD_2017_2B_TEAM2_TARGET." + i.getTableName() + "." + i.getColumnName());
	result.append("\nwhen > TOSAD_2017_2B_TEAM2_TARGET." + i.getTableName2() + "." + i.getColumnName2());
	result.append("\nthen v_result := 'GREATER THAN';");
	result.append("\nwhen < TOSAD_2017_2B_TEAM2_TARGET." + i.getTableName2() + "." + i.getColumnName2());
	result.append("\nthen v_result := 'LESSER THAN';");
	result.append("\nwhen >= TOSAD_2017_2B_TEAM2_TARGET." + i.getTableName2() + "." + i.getColumnName2());
	result.append("\nthen v_result := 'GREATER OR EQUAL THAN';");
	result.append("\nwhen <= TOSAD_2017_2B_TEAM2_TARGET." + i.getTableName2() + "." + i.getColumnName2());
	result.append("\nthen v_result := 'LESSER OR EQUAL THAN';");
	result.append("\nwhen = TOSAD_2017_2B_TEAM2_TARGET." + i.getTableName2() + "." + i.getColumnName2());
	result.append("\nthen v_result := 'EQUALS';");
	result.append("\nwhen != TOSAD_2017_2B_TEAM2_TARGET." + i.getTableName2() + "." + i.getColumnName2());
	result.append("\nthen v_result := 'NOT EQUAL'; \nend");
	result.append("\n if " + i.getOperator() + " != v_result then");
	result.append("\nraise_application_error(-20000," + i.getCode() + " description: " + i.getDiscription() + " violated)");
	result.append("\nend if; \nend" + i.getCode());
	
	StringBuilder result2 = new StringBuilder("create or replace trigger " + i.getCode());
	result2.append("\nbefore or update on table TOSAD_2017_2B_TEAM2_TARGET." + i.getTableName2());
	result2.append("\nfor each row \ndeclare \nv_result varchar2; \nbegin \ncase TOSAD_2017_2B_TEAM2_TARGET." + i.getTableName() + "." + i.getColumnName());
	result2.append("\nwhen > TOSAD_2017_2B_TEAM2_TARGET." + i.getTableName2() + "." + i.getColumnName2());
	result2.append("\nthen v_result := 'GREATER THAN';");
	result2.append("\nwhen < TOSAD_2017_2B_TEAM2_TARGET." + i.getTableName2() + "." + i.getColumnName2());
	result2.append("\nthen v_result := 'LESSER THAN';");
	result2.append("\nwhen >= TOSAD_2017_2B_TEAM2_TARGET." + i.getTableName2() + "." + i.getColumnName2());
	result2.append("\nthen v_result := 'GREATER OR EQUAL THAN';");
	result2.append("\nwhen <= TOSAD_2017_2B_TEAM2_TARGET." + i.getTableName2() + "." + i.getColumnName2());
	result2.append("\nthen v_result := 'LESSER OR EQUAL THAN';");
	result2.append("\nwhen = TOSAD_2017_2B_TEAM2_TARGET." + i.getTableName2() + "." + i.getColumnName2());
	result2.append("\nthen v_result := 'EQUALS';");
	result2.append("\nwhen != TOSAD_2017_2B_TEAM2_TARGET." + i.getTableName2() + "." + i.getColumnName2());
	result2.append("\nthen v_result := 'NOT EQUAL'; \nend");
	result2.append("\n if " + i.getOperator() + " != v_result then");
	result2.append("\nraise_application_error(-20000," + i.getCode() + " description: " + i.getDiscription() + " violated)");
	result2.append("\nend if; \nend" + i.getCode());
	result.append("\n" + result2.toString());
	return result.toString();
}

@Override
public String generateTupleCompareRule(TupleCompareRule t) {
	StringBuilder result = new StringBuilder("alter table TOSAD_2017_2B_TEAM2_TARGET." + t.getTableName());
	result.append(" add constraint " + t.getCode());
	result.append(" check (" + t.getColumn() + " " + t.getOperator() + " TOSAD_2017_2B_TEAM2_TARGET." + t.getCompareColumn());
	result.append(")");
	return result.toString();
}
}
