
/* bz2309
 * Beichen Zhang
 * E6.6 in Big Java
 */
import java.util.Scanner;
public class DataSet {
	private double large, small, sum=0, begin=1;
	private double kk;
	private int n=0;
	public DataSet(){
		System.out.printf("Please input the values, ");
		System.out.println("if you want to stop, input a letter and enter.");
		Scanner input = new Scanner(System.in);
		while(input.hasNextDouble()==true){
			kk = input.nextDouble();
			add(kk);
			if(begin == 1){
				large = kk;
				small = kk;
				begin =0;
			}
			else{
				if(large < kk)
					large = kk;
				if(small > kk)
					small = kk;
			}
		}
		if(n == 0)
			System.out.println("There are no values input.");
		input.close();
	}
	//getAverage, getSmallest, getLargest, and getRange
	public void add(double value){
		sum += value;
		n++;
	}
	public double getAverage(){
		return sum/n;
	}
	public double getSmallest(){
		return small;
	}
	public double getLargest(){
		return large;
	}
	public double getRange(){
		return large-small;
	}
}
