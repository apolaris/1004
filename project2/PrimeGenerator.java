/* bz2309
 * Beichen Zhang
 * P6.5 in Big Java
 */
public class PrimeGenerator {
	private int p;
	public PrimeGenerator(){
		p = 1;
	}
	public boolean isPrime(int x){
		if(x<=1)
			return false;
		int i;
		for(i=2;i<=x/2;i++)
			if(x%i == 0)
				return false;
		return true;
	}
	public int nextPrime(){
		int i;
		for(i=p+1;!isPrime(i);i++);
		p = i;
		return i;
	}
}
