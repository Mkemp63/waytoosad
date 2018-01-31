package nl.hu.v2tosad.data.generator;

import nl.hu.v2tosad.data.model.AttributeCompareRule;
import nl.hu.v2tosad.data.model.AttributeListRule;
import nl.hu.v2tosad.data.model.AttributeRangeRule;
import nl.hu.v2tosad.data.model.BusinessRule;
import nl.hu.v2tosad.data.model.InterEntityCompareRule;
import nl.hu.v2tosad.data.model.TupleCompareRule;

public interface Generator {
    String generateCode(BusinessRule b);
    String generateAttributeCompareRule(AttributeCompareRule c);
    String generateAttributeListRule(AttributeListRule l);
    String generateAttributeRangeRule(AttributeRangeRule r);
    String generateInterEntityCompareRule(InterEntityCompareRule i);
    String generateTupleCompareRule(TupleCompareRule t);
/*  public String generateAttributeOtherRule();
    public String generateEntityOtherRule();
    public String generateModifyRule();
    public String generateTupleOtherRule();*/
}
