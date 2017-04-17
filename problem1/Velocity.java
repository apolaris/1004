/* bz2309
 * Beichen Zhang
 * P5.23 in Big Java
 */
import java.util.Scanner;
public class Velocity{
	public static void main(String[] arg){
		Scanner input = new Scanner(System.in);
		double r = 1153000;
		double g = 6.67 * Math.pow(10,-11);
		double m = 1.3 * Math.pow(10,22);
		double v = input.nextDouble();
		v *= 0.44704;
		double m_should = Math.pow(v,2) / 2 * r / g;
		if(m_should <= m)
			System.out.printf("The jumper will return!\n");
		else
			System.out.printf("The jumper won't return. The comet must be %f kg more!\n",m_should-m);
		input.close();
	}
}
