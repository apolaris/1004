/* bz2309
 * Beichen Zhang
 * P4.6 in Big Java
 */
import java.util.Scanner;
public class Order{
    public static void main(String []args) {
		double money=0;
		Scanner input = new Scanner(System.in);
		System.out.printf("please input the number of books!\n");
		int count = input.nextInt();
		System.out.printf("please input the price!\n");
		double price = input.nextDouble();
		money =	price* 1.075;
		money += 2*count;
		System.out.printf("the price of the order is %.2f\n",money);
		input.close();
	}
}
