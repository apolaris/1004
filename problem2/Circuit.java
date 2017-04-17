/* bz2309
 * Beichen Zhang
 * E3.3 in Big Java
 */
public class Circuit {
	private int switch1, switch2, lamp;
	public Circuit(){
		this.switch1=0;
		this.switch2=0;
		this.lamp=0;
	}
	public int getFirstSwitchState() {// 0 for down, 1 for up
		return switch1;
	}
	public int getSecondSwitchState() {
		return switch2;
	}
	public int getLampState() {
		return lamp;
	}
	public void toggleFirstSwitch() {
		switch1 = 1 - switch1;
		lamp = 1 - lamp;
	}
	public void toggleSecondSwitch() {
		switch2 = 1 - switch2;
		lamp = 1 - lamp;
	}
}
