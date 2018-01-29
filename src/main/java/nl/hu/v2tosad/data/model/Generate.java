package nl.hu.v2tosad.data.model;

public interface Generate {
    public String generateCode(BusinessRule b);
    public String generateAttributeCompareRule(AttributeCompareRule c);
    public String generateAttributeListRule(AttributeListRule l);
    public String generateAttributeRangeRule(AttributeRangeRule r);
    public String generateInterEntityCompareRule(InterEntityCompareRule i);
    public String generateTupleCompareRule(TupleCompareRule t);
/*  public String generateAttributeOtherRule();
    public String generateEntityOtherRule();
    public String generateModifyRule();
    public String generateTupleOtherRule();*/

}
