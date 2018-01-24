package Test;

public class AttributeRangeRule extends BusinessRule {
	
	private String operator;
	private String table;
	private String attribute;
	private String minValue;
	private String maxValue;
	
	public AttributeRangeRule(String op, String t, String att, String min, String max) {
		operator = op;
		table = t;
		attribute = att;
		minValue = min;
		maxValue = max;
		this.ruleType = "AttributeRangeRule";
	}

	public String generateCode() {
		String code = "BRG_VBMG";
		if (table == "VMBG_KLANTEN") {
			code += "_KLN";
		} else if (table == "VMBG_LEVERINGEN") {
			code += "_LVR";
		} else if (table == "VMBG_LOCATIES") {
			code += "_LCT";
		} else if (table == "VMBG_ORDERS") {
			code += "_ORD";
		} else if (table == "VMBG_PRODUCTEN") {
			code += "_PRD";
		}
		code += "_CNS_ATRG";
		String rule = "alter table " + table + " add constraint " + code + " check (" + attribute + " " + operator + " " + minValue + " and " + maxValue + ")";
		return rule;
 	}

}
