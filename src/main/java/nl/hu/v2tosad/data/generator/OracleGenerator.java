package nl.hu.v2tosad.data.generator;

import nl.hu.v2tosad.data.model.*;

public class OracleGenerator implements Generator{


    @Override
    public String generateAttributeCompareRule(AttributeCompareRule c) {
        System.out.println("AttributeCompareRule in = " +c);
        if(c.getOperator().equals("GREATER THAN OR EQUAL TO")) {
        	c.setOperator(">=");
        }
        StringBuilder result = new StringBuilder("alter table " + c.getTableName());
        result.append(" add constraint " + c.getCode());
        result.append(" check (" + c.getColumn() + " " + c.getOperator() + " " + c.getCompareValue() );
        result.append(")");
        return result.toString();
    }

   @Override
    public String generateAttributeListRule(AttributeListRule l) {
	   StringBuilder result = new StringBuilder("alter table " + l.getTableName());
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
		StringBuilder result = new StringBuilder("alter table " + r.getTableName());
		result.append(" add constraint " + r.getCode());
		result.append(" check (" + r.getColumn() + " " + r.getOperator() + " " + r.getMinVal());
		result.append(" and " + r.getMaxVal());
		result.append(")NOVALIDATE");
		return result.toString();
	}

   @Override
   public String generateInterEntityCompareRule(InterEntityCompareRule i) {
	   StringBuilder result = new StringBuilder("create or replace trigger " + i.getCode() + "_" + i.getTableName());
	   result.append("\nbefore insert or update on " + i.getTableName());
	   result.append("\nfor each row");
	   result.append("\ndeclare");
	   result.append("\nv_column " + i.getTableName2() + "." + i.getColumnName2() + "%type;");
	   result.append("\nbegin");
	   result.append("\nSELECT " + i.getColumnName2() + " into v_column \n from " + i.getTableName2() + "\n where id = :new." + i.getAfk() + "_ID;");
	   result.append("\nif :new." + i.getColumnName() + " " + i.getOperator() + " v_column THEN");
	   result.append("\nraise_application_error(-20000, '" + i.getCode() + " description: " + i.getDiscription() + " IS VIOLATED');");
	   result.append("\nEND IF;\nEND;");
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
