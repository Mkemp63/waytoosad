package nl.hu.v2tosad.data.model;

public interface Generate {
    public String generateCode(BusinessRule b);
    public String generateAttributeCompareRule(AttributeCompareRule c);
    public String generateAttributeListRule(AttributeListRule r);
    public String generateAttributeRangeRule();
    public String generateInterEntityCompareRule();
    public String generateTupleCompareRule();
/*  public String generateAttributeOtherRule();
    public String generateEntityOtherRule();
    public String generateModifyRule();
    public String generateTupleOtherRule();*/

}
