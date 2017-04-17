/* bz2309
 * Beichen Zhang
 * P4.9 in Big Java
 */
import java.util.Scanner;
public class Change{
	public static void main(String[] arg){
		int dollar,quarters,dimes,nickels,pennies,due,recieved,change;
		Scanner input = new Scanner(System.in);
		System.out.printf("please input the due money!\n");
		due = input.nextInt();
		System.out.printf("please input the recieved money!\n");
		recieved = input.nextInt();
		change = recieved - due;
		//System.out.println(change % 100);
		dollar = change / 100;
		change -= dollar * 100;
		System.out.println("dollar: " + dollar);
		quarters = change / 25;
		change -= quarters * 25;
		System.out.println("quarters: " + quarters);
		dimes = change / 10;
		change -= dimes * 10;
		System.out.println("dimes: " + dimes);
		nickels = change / 5;
		change -= nickels*5;
		System.out.println("nickels: "+ nickels);
		System.out.println("pennies: " + change);
		input.close();
	}
}
