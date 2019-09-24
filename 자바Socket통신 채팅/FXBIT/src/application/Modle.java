package application;

public class Modle {

	public int calculate(String operator, int x) {
		if (operator.equals( "π›¿Â" )) {
			return 4*4*(1000 + ( x * 100));			
		}else if (operator.equals( "∆¿¿Â" )) {
			return 4*4*(1000 + ( x * 100));			
		}else if (operator.equals( "∫Œ∆¿¿Â" )) {
			return 2*4*(1000 + ( x * 100));			
		}else{
			return 4*(1000 + ( x * 100));			
		}
	}
}
