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
    public String generateAttributeListRule(AttributeListRule r) {
	   StringBuilder result = new StringBuilder("alter table TOSAD_2017_2B_TEAM2_TARGET." + r.getTableName());
		result.append(" add constraint " + r.getCode());
		result.append(" check (" + r.getColumn() + " " + r.getOperator() + " (" + r.getCompareValue());
		for (String s : r.getCompareValue()) {
			if (r.getCompareValue().indexOf(s) == 0) {
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
public String generateAttributeRangeRule() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String generateInterEntityCompareRule() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String generateTupleCompareRule() {
	// TODO Auto-generated method stub
	return null;
}

   /* @Override
    public String generateAttributeOtherRule() {
        return null;
    }

    @Override
    public String generateAttributeRangeRule() {
        StringBuilder result = new StringBuilder("alter table TOSAD_2017_2B_TEAM2_TARGET." + super.getTableName());
        result.append(" add constraint " + super.getCode());
        result.append("check (" + column + " " + operator + " " + minVal);
        result.append(" and " + maxVal);
        result.append(")");
        System.out.println(result.toString());
        return result.toString();
    }

    @Override
    public String generateEntityOtherRule() {
        return null;
    }

    @Override
    public String generateInterEntityCompareRule() {
        return null;
    }

    @Override
    public String generateModifyRule() {
        return null;
    }

    @Override
    public String generateTupleCompareRule() {
        StringBuilder result = new StringBuilder("alter table TOSAD_2017_2B_TEAM2_TARGET." + super.getTableName());
        result.append(" add constraint " + super.getCode());
        result.append("check (" + column + operator + compareColumn);
        result.append(")");
        System.out.println(result.toString());
        return result.toString();
    }

    @Override
    public String generateTupleOtherRule() {
        return null;
    }*/
}
