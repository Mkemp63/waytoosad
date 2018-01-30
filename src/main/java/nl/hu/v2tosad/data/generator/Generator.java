package nl.hu.v2tosad.data.generator;

import nl.hu.v2tosad.data.model.AttributeCompareRule;
import nl.hu.v2tosad.data.model.AttributeListRule;
import nl.hu.v2tosad.data.model.AttributeRangeRule;
import nl.hu.v2tosad.data.model.BusinessRule;
import nl.hu.v2tosad.data.model.InterEntityCompareRule;
import nl.hu.v2tosad.data.model.TupleCompareRule;

public interface Generator {
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
