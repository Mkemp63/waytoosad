package nl.hu.v2tosad.data.model;

public class GenerateImplOracle implements Generate{

    public String generateCode(BusinessRule b){
        String type = b.getBusinessRuleType();
        if (b instanceof AttributeCompareRule){
            AttributeCompareRule c = (AttributeCompareRule) b;
            return generateAttributeCompareRule(c);

        }else {return "";}
    }

    @Override
    public String generateAttributeCompareRule(AttributeCompareRule c) {
        StringBuilder result = new StringBuilder("alter table TOSAD_2017_2B_TEAM2_TARGET." + c.tableName);
        result.append(" add constraint " + c.code);
        result.append("check (" + c.getColumn() + c.getOperator() + c.getCompareValue() );
        result.append(")");
        System.out.println(result.toString());
        return result.toString();
    }

   /* @Override
    public String generateAttributeListRule() {
        StringBuilder result = new StringBuilder("alter table TOSAD_2017_2B_TEAM2_TARGET." + super.getTableName());
        result.append(" add constraint " + super.getCode());
        result.append("check (" + column + " " + operator + "(" + compareValue);
        for (String s : compareValue) {
            if (compareValue.indexOf(s) == 0) {
                result.append("'" + s + "'");
            }
            else {
                result.append(", '" + s + "'");
            }
        }
        result.append("))");
        System.out.println(result.toString());
        return result.toString();
    }

    @Override
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
