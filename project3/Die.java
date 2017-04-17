/**
 * Beichen Zhang, bz2309
 * Die class, simulate one Die
 *
 */
public class Die {
	public Die() {

	}
	public int play() {
		return (int)(Math.random() * 6) + 1;
	}
}
