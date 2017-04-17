
/* bz2309
 * Beichen Zhang
 * E3.4 in Big Java
 */
public class CircuitTester {
	public static void main(String[] argv){
		Circuit cir = new Circuit();
		if(cir.getFirstSwitchState()==1)
			System.out.printf("actual: switch1 is up,");
		else
			System.out.printf("actual: switch1 is down,");
		if(cir.getSecondSwitchState()==1)
			System.out.printf(" switch2 is up,");
		else
			System.out.printf(" switch2 is down,");
		if(cir.getLampState()==1)
			System.out.printf(" lamp is on\n");
		else
			System.out.printf(" lamp is off\n");
		System.out.printf("expected: switch1 is down, ");
		System.out.printf("switch2 is down, lamp is off\n\n");
		cir.toggleFirstSwitch();//turn switch1 on
		if(cir.getFirstSwitchState()==1)
			System.out.printf("actual: switch1 is up,");
		else
			System.out.printf("actual: switch1 is down,");
		if(cir.getSecondSwitchState()==1)
			System.out.printf(" switch2 is up,");
		else
			System.out.printf(" switch2 is down,");
		if(cir.getLampState()==1)
			System.out.printf(" lamp is on\n");
		else
			System.out.printf(" lamp is off\n");
		System.out.printf("expected: switch1 is up, switch2 is down, lamp is on\n\n");
		cir.toggleSecondSwitch();//turn switch2 on
		if(cir.getFirstSwitchState()==1)
			System.out.printf("actual: switch1 is up,");
		else
			System.out.printf("actual: switch1 is down,");
		if(cir.getSecondSwitchState()==1)
			System.out.printf(" switch2 is up,");
		else
			System.out.printf(" switch2 is down,");
		if(cir.getLampState()==1)
			System.out.printf(" lamp is on\n");
		else
			System.out.printf(" lamp is off\n");
		System.out.printf("expected: switch1 is up, switch2 is up, lamp is off\n\n");
		cir.toggleFirstSwitch();//turn switch1 off
		if(cir.getFirstSwitchState()==1)
			System.out.printf("actual: switch1 is up,");
		else
			System.out.printf("actual: switch1 is down,");
		if(cir.getSecondSwitchState()==1)
			System.out.printf(" switch2 is up,");
		else
			System.out.printf(" switch2 is down,");
		if(cir.getLampState()==1)
			System.out.printf(" lamp is on\n");
		else
			System.out.printf(" lamp is off\n");
		System.out.printf("expected: switch1 is down, switch2 is up,");
		System.out.printf(" lamp is on\n\n");
		cir.toggleSecondSwitch();//turn switch2 off
		if(cir.getFirstSwitchState()==1)
			System.out.printf("actual: switch1 is up,");
		else
			System.out.printf("actual: switch1 is down,");
		if(cir.getSecondSwitchState()==1)
			System.out.printf(" switch2 is up,");
		else
			System.out.printf(" switch2 is down,");
		if(cir.getLampState()==1)
			System.out.printf(" lamp is on\n");
		else
			System.out.printf(" lamp is off\n");
		System.out.println("expected: switch1 is down, switch2 is down, "
				+ "lamp is off");
	}
}
