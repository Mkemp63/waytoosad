package Test;

public abstract class BusinessRule {
	
	protected String code;
	protected String ruleType;
	
	public BusinessRule() {
	}
	
	public abstract String generateCode() ;

}
