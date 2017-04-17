/**
 * Beichen Zhang, bz2309
 * 1004_001
 * credicard
 */
public class CreditCard {
	private String code;
	private int errorcode;
	private boolean y;
	void check() {
		int sum = 0, b = 0, c = 0, i, test3, test6;
		for(i = 0; i < 12; i++){
			sum += (code.charAt(i) - '0');
		}
		for(i = 0; i < 4; i++){
			b += (code.charAt(i) - '0');
			c += (code.charAt(11-i) - '0');
		}
    test3 = (code.charAt(0) - '0') 
        * (code.charAt(4) - '0') * (code.charAt(8) - '0');
    test6 = 10 * (code.charAt(0) - '0') + (code.charAt(1) - '0') +
				10 * (code.charAt(6) - '0') + (code.charAt(7) - '0');
		if(code.charAt(0) != '4'){
			errorcode = 1;
			y = false;
		}
		else if(code.charAt(3) <= code.charAt(4)) {
			errorcode = 2;
			y = false;
		}
		else if(test3 != 24){
			errorcode = 3;
			y = false;
		}
		else if(sum % 4 != 0){
			errorcode = 4;
			y = false;
		}
		else if((c - b) != 1){
			errorcode = 5;
			y = false;
		}
		else if(test6 != 100){
			errorcode = 6;
			y = false;
		}
	}
	public CreditCard(String cc) {
		code = cc;
		y = true;
		errorcode = 0;
	}
	boolean isValid() {
		return y;
	}
	int getErrorCode() {
		return errorcode;
	}

}
