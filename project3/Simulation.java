/**
 * Beichen Zhang, bz2309
 *Simulate the two games
 *
 *
 */
public class Simulation {
	public static void main(String[] argv){
		Die die1 = new Die();
		Die die2 = new Die();
		int i, j, game1 = 0, game2 = 0, y;
		for(i = 0; i < 1000000; i++) {
			if(die1.play() != 6 && die1.play() != 6 &&
					die1.play() != 6 && die1.play() != 6)
				game1--;
			else
				game1++;
		}
		for(i = 0; i < 1000000; i++) {
			y = 0;
			for(j = 0; j < 24; j++) {
				if(die1.play() == 6 && die2.play() == 6) {
					y++;
					break;
				}
			}
			if(y != 0)
				game2++;
			else
				game2--;
		}
		if(game1 > 0) {
			System.out.println("In first game, the profit is $" + game1);
			System.out.println("The first game is a good game for him.");
		}
		else {
			System.out.println("In first game, the loss is $" + game1 + '.');
			System.out.println("The first game isn't a good game for him.");
		}
		if(game2 > 0) {
			System.out.println("In second game, the profit is $" + game2);
			System.out.println("The second game is a good game for him.");
		}
		else {
			System.out.println("In second game, the loss is $" + game2 + '.');
			System.out.println("The second game isn't a good game for him.");
		}

	}
}
