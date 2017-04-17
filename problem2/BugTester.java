
/* bz2309
 * Beichen Zhang
 * E3.15 in Big Java
 */
public class BugTester {
	public static void main(String[] argv){
		Bug bug1 = new Bug(100);
		int i;
		for(i=0;i<10;i++){
			bug1.move();
		}
		System.out.println("bug1's actual position is " + bug1.getPosition());
		System.out.printf("bug1's expected position is %d\n\n", 100+10);
		
		bug1.turn();
		for(i=0;i<112;i++){
			bug1.move();
		}
		System.out.println("bug1's actual position is " + bug1.getPosition());
		System.out.printf("bug1's expected position is %d\n\n", 100+10-112);
		
		for(i=0;i<53;i++){
			bug1.move();
		}
		System.out.println("bug1's actual position is " + bug1.getPosition());
		System.out.printf("bug1's expected position is %d\n\n", 100+10-112-53);
		
		bug1.turn();
		for(i=0;i<534;i++){
			bug1.move();
		}
		System.out.println("bug1's actual position is " + bug1.getPosition());
		int k = 100+10-112-53+534;
		System.out.printf("bug1's expected position is %d\n\n",k);
	}
}
