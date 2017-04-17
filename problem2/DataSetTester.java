/* bz2309
 * Beichen Zhang
 * E6.6 in Big Java
 */
public class DataSetTester {
	public static void main(String[] argv){
		DataSet data = new DataSet();
		System.out.println("average: "+data.getAverage());
		System.out.println("largest: "+data.getLargest());
		System.out.println("smallest: "+data.getSmallest());
		System.out.println("range: "+data.getRange());
	}
}
