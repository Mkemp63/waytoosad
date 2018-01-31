package nl.hu.v2tosad.data.generator;

import nl.hu.v2tosad.data.model.*;

public interface Generator {

    String generateAttributeCompareRule(AttributeCompareRule a);
    String generateAttributeListRule(AttributeListRule a);
    String generateAttributeRangeRule(AttributeRangeRule a);
    String generateInterEntityCompareRule(InterEntityCompareRule a);
    String generateTupleCompareRule(TupleCompareRule a);
    String generateAttributeOtherRule(AttributeOtherRule a);
    String generateEntityOtherRule(EntityOtherRule a);
    String generateModifyRule(ModifyRule a);
    String generateTupleOtherRule(TupleOtherRule a);
}
