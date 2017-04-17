//*********************************
//
//Beichen Zhang, bz2309
//2/20/2017
//
//FactorGenerator class
//
//Do not alter this class. The FactorGenerator
//class that you write must work with this class.
//*********************************

public class FactorGenerator {
	private int n;
	private int out;
	public FactorGenerator(int input){
		if(input < 0){
			System.out.println("the input <= 0, "
			+ "which means that it can't be decomposed into quality factors");
		}
		if(input == 1 )
			System.out.println("1 can't be decomposed into quality factors");
		n = input;
		out = 2;
	}
	public int nextFactor(){
		for(;out<=n;out++)
		{
			if(isPrime(out))
				if(n%out == 0){
					n /= out;
					return out;
				}
		}
		return 0;
	}

	public boolean hasMoreFactors(){
		for(;out<=n;out++)
		{
			if(isPrime(out))
				if(n%out == 0){
					return true;
				}
		}
		return false;
	}
	public boolean isPrime(int x){
		double sqn = Math.sqrt((double)x)+1;
		if(x<2)
			return false;
		if(x==2)
			return true;
		int i;
		for(i=2;i<=sqn;i++)
			if(x%i == 0)
				return false;
		return true;
	}
}
