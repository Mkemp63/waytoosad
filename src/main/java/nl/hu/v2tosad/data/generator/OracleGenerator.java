package nl.hu.v2tosad.data.generator;

import nl.hu.v2tosad.data.model.*;

public class OracleGenerator implements Generator{

    public String generateCode(BusinessRule b){
        String type = b.getBusinessRuleType();
        System.out.println("generateImplOracle generate code input= " +b);
        if (b instanceof AttributeCompareRule) {
            AttributeCompareRule c = (AttributeCompareRule) b;
            /*System.out.println("generate instanceof = " + c);*/
            return generateAttributeCompareRule(c);
        }else if(b instanceof AttributeListRule ) {
            AttributeListRule c = (AttributeListRule) b;
            return generateAttributeListRule(c);
        }else if(b instanceof AttributeOtherRule) {
            AttributeOtherRule c = (AttributeOtherRule)b;
            return generateAttributeOtherRule(c);
        }else if(b instanceof AttributeRangeRule) {
            AttributeRangeRule c = (AttributeRangeRule)b;
            return generateAttributeRangeRule(c);
        }else if(b instanceof EntityOtherRule) {
            EntityOtherRule c = (EntityOtherRule)b;
            return generateEntityOtherRule(c);
        }else if(b instanceof InterEntityCompareRule) {
            InterEntityCompareRule c = (InterEntityCompareRule)b;
            return generateInterEntityCompareRule(c);
        }else if(b instanceof ModifyRule) {
            ModifyRule c = (ModifyRule)b;
            return generateModifyRule(c);
        }else if(b instanceof TupleCompareRule) {
            TupleCompareRule c = (TupleCompareRule)b;
            return generateTupleCompareRule(c);
        }else if(b instanceof TupleOtherRule) {
            TupleOtherRule c = (TupleOtherRule) b;
            return generateTupleOtherRule(c);
        }else {return "";}
    }

    @Override
    public String generateAttributeCompareRule(AttributeCompareRule c) {
        System.out.println("AttributeCompareRule in = " +c);
        if(c.getOperator().equals("GREATER THAN OR EQUAL TO")) {
        	c.setOperator(">=");
        }
        StringBuilder result = new StringBuilder("alter table TOSAD_2017_2B_TEAM2_TARGET." + c.getTableName());
        result.append(" add constraint " + c.getCode());
        result.append(" check (" + c.getColumn() + " " + c.getOperator() + " " + c.getCompareValue() );
        result.append(")");
      //System.out.println(result.toString());
        return result.toString();
    }

   @Override
    public String generateAttributeListRule(AttributeListRule l) {
	   StringBuilder result = new StringBuilder("alter table TOSAD_2017_2B_TEAM2_TARGET." + l.getTableName());
		result.append(" add constraint " + l.getCode());
		result.append(" check (" + l.getColumn() + " " + l.getOperator() + " (");
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
//   	StringBuilder result = new StringBuilder("create or replace trigger " + i.getCode() + i.getTableName());
//   	result.append("\nbefore insert or update on TOSAD_2017_2B_TEAM2_TARGET." + i.getTableName());
//   	result.append("\nfor each row \ndeclare \nv_column1 varchar2(400); \nv_column2 varchar2(400); \nbegin");
//   	result.append("\nselect " +i.getColumnName() + " into v_column1 from TOSAD_2017_2B_TEAM2_TARGET." + i.getTableName() + ";");
//   	result.append("\nselect " +i.getColumnName2() + " into v_column2 from TOSAD_2017_2B_TEAM2_TARGET." + i.getTableName2());
//   	result.append("\nwhere (select ID from TOSAD_2017_2B_TEAM2_TARGET." + i.getTableName() + ") = " + i.getAfk() + "_ID;");
//   	result.append("\n if v_column1 " + i.getOperator() + " v_column2 then null;");
//   	result.append("\nelse \nraise_application_error(-20000,'" + i.getCode() + " description: " + i.getDiscription() + " violated');");
//   	result.append("\nend if; \nend " + i.getCode() + i.getTableName() + ";");
//   	
//   	StringBuilder result2 = new StringBuilder("\ncreate or replace trigger " + i.getCode() + i.getTableName2());
//   	result2.append("\nbefore insert or update on TOSAD_2017_2B_TEAM2_TARGET." + i.getTableName2());
//   	result2.append("\nfor each row \ndeclare \nv_column1 varchar2(400); \nv_column2 varchar2(400); \nbegin");
//   	result2.append("\nselect " +i.getColumnName() + " into v_column1 from TOSAD_2017_2B_TEAM2_TARGET." + i.getTableName() + ";");
//   	result2.append("\nselect " +i.getColumnName2() + " into v_column2 from TOSAD_2017_2B_TEAM2_TARGET." + i.getTableName2());
//   	result2.append("\nwhere (select ID from TOSAD_2017_2B_TEAM2_TARGET." + i.getTableName() + ") = " + i.getAfk() + "_ID;");
//   	result2.append("\n if v_column1 " + i.getOperator() + " v_column2 then null;");
//   	result2.append("\nelse \nraise_application_error(-20000,'" + i.getCode() + " description: " + i.getDiscription() + " violated');");
//   	result2.append("\nend if; \nend " + i.getCode() + i.getTableName2() + ";");
//   	result.append("\n" + result2.toString());
//   	return result.toString();
	   StringBuilder result = new StringBuilder("create or replace trigger " + i.getCode() + "_" + i.getTableName());
	   result.append("\nbefore insert or update on " + i.getTableName());
	   result.append("\nfor each row");
	   result.append("\ndeclare");
	   result.append("\nv_column " + i.getTableName2() + "." + i.getColumnName2() + "%type;");
	   result.append("\nbegin");
	   result.append("\nSELECT " + i.getColumnName2() + " into v_column \n from " + i.getTableName2() + "\n where id = :new." + i.getAfk() + "_ID;");
	   result.append("\nif :new." + i.getColumnName() + " " + i.getOperator() + " v_column THEN");
	   result.append("\nraise_application_error(-20000, '" + i.getCode() + " description: " + i.getDiscription() + " IS VIOLATED');");
	   result.append("\nEND IF;\nEND");
	   return result.toString();
   }

    @Override
    public String generateTupleCompareRule(TupleCompareRule t) {
        StringBuilder result = new StringBuilder("alter table " + t.getTableName());
        result.append(" add constraint " + t.getCode());
        result.append(" check (" + t.getColumn() + " " + t.getOperator() + " " + t.getCompareColumn());
        result.append(")NOVALIDATE");
        return result.toString();
    }

    public String generateAttributeOtherRule(AttributeOtherRule b){
        return "not implemented";
    }

    public String generateEntityOtherRule(EntityOtherRule b){
        return "not implemented";
    }

    public String generateModifyRule(ModifyRule b){
        return "not implemented";
    }
    public String generateTupleOtherRule(TupleOtherRule b){
        return "not implemented";
    }
}
