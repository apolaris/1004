/* bz2309
 * Beichen Zhang
 * P6.5 in Big Java
 * has main function
 */
import java.util.Scanner;

public class PrimePrinter {
	public static void main(String[] argv){
		Scanner input = new Scanner(System.in);
		System.out.println("Please input an integer");
		while(input.hasNextInt()==false){
			System.out.println("It's not an integer!!"
					+ "Please input an integer!!");
			input.nextLine();
		}
		int n = input.nextInt(), i = 0, j;
		PrimeGenerator prime = new PrimeGenerator();
		for(;i<=n;i++){
			j = prime.nextPrime();
			if(j<=n){
				System.out.println(j);
			}
		}
		input.close();
	}
}
