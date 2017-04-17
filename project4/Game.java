
//Beichen Zhang
//bz2309
//project 4
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	private Player p;
	private Deck cards;
	private boolean test;

	public Game(String[] testHand) {
		// This constructor is to help test your code
		// use the contents of testHand to
		// make a hand for the player
		// use the following encoding for cards
		// c = clubs
		// d = diamonds
		// h = hearts
		// s = spades
		// 1-13 correspond to ace - king
		// example: s1 = ace of spades
		// example: testhand = {s1, s13, s12, s11, s10} = royal flush
		if (testHand.length != 5) {
			System.out.println("the test hand should be 5 cards!");
			p = new Player();
			cards = new Deck();
			test = false;
		} else {// put the argv to p's hand
			p = new Player();
			cards = new Deck();
			test = true;
			int s, r;
			for (int i = 0; i < 5; i++) {
				if (testHand[i].charAt(0) == 's')
					s = 4;
				else if (testHand[i].charAt(0) == 'h')
					s = 3;
				else if (testHand[i].charAt(0) == 'd')
					s = 2;
				else if (testHand[i].charAt(0) == 'c')
					s = 1;
				else {
					test = false;
					System.out.println("the card in input for testhand is not available!");
					p.reset();
					break;
				}
				if (testHand[i].length() == 2) {
					r = testHand[i].charAt(1) - '0';
				}
				else if(testHand[i].length() == 2) {
					r = testHand[i].charAt(2) - '0' + 10 *
                        (testHand[i].charAt(1) - '0');
				}
                else{
                    test = false;
					System.out.println("the card in input for testhand is not available!");
                    p.reset();
					break;
                }
				if (r == 0 || r >13){
                    test = false;
					System.out.println("the card in input for testhand is not available!");
                    p.reset();
					break;
				}
				Card c = new Card(s, r);
				p.addCard(c);
			}
		}
	}

	public Game() {
		// This no-argument constructor is to actually play a normal game
		p = new Player();
		cards = new Deck();
		test = false;
	}

	public void play() {
	    Scanner input = new Scanner(System.in);
	    int exi;// exi to mark whether to exit
	    do{
            System.out.println("A new play!");
            int i, m = 0;
            double bet;
            ArrayList<Card> hand = new ArrayList<Card>();
            cards.shuffle();
            do {
                System.out.println("please input your bet(from 1 to 5):");
                bet = input.nextDouble();
            } while (bet > 5 || bet < 1);
            p.bets(bet);
            if(!test){
                for (int j = 0; j < 5; j++) {
                    Card c = cards.deal();
                    p.addCard(c);
                }
                test = false;
            }
            p.show();
            System.out.println("If you don't want to change your cards, type "
                    + "in 0.\nOr type in how many cards you want to change:");
            i = input.nextInt();
            if (i != 0)
                System.out.println("Please input the cards' number");
            for (int j = i; j > 0; j--) {
                int replace = input.nextInt();
                p.removeCard(replace);
                p.insert(cards.deal(),replace);
            }
            p.show();

            for (int j = 0; j < 5; j++) {
                hand.add(p.getCard(j));
            }
            String a = this.checkHand(hand);
            System.out.println(a + ", player's bankroll now is "
                    + p.getBankroll() + "\n\n");
            // input.close();
            System.out.println("if you want to exit, type in 0, "
                               +"else, type in 1");
            input.nextLine();
            while(true){
                if(input.hasNextInt() == false){
                    System.out.println("type in 0 to exit, 1 to continue.");
                    input.nextLine();
                    continue;
                }
                exi = input.nextInt();
                if(exi != 1 && exi != 0){
                    System.out.println("type in 0 to exit, 1 to continue. ");
                    input.nextLine();
                    continue;
                }
                else
                    break;
            }
	    }while(exi == 1);
	    input.close();
	}

	public String checkHand(ArrayList<Card> hand) {
		// this method should take an ArrayList of cards
		// as input and then determine what evaluates to and
		// return that as a String
		int[] a = new int[5];
		for (int i = 0; i < 5; i++) {
			// set the array for checkhand
			a[i] = hand.get(i).getSuit() + 10 * hand.get(i).getRank();
		}
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 5; j++) {
				if (a[i] > a[j]) {
					int l = a[i];
					a[i] = a[j];
					a[j] = l;
				}
			}
		}
		return judge(a);
	}

	private boolean same(int[] c) {
		// judge whether the suit is same
		return (c[0] % 10 == c[1] % 10) && (c[1] % 10 == c[2] % 10)
				&& (c[2] % 10 == c[3] % 10)&& (c[3] % 10 == c[4] % 10);
	}

	private int straight(int[] c) {
		// judge which kind of straight it belongs to
		int[] a = new int[5];
		for (int i = 0; i < 5; i++)
			a[i] = c[i] / 10;
		if (a[0] == 1 && a[1] == 10 && a[2] == 11 && a[3] == 12 && a[4] == 13){
			return 1;
		} else if ((a[0] == a[1] - 1) && (a[1] == a[2] - 1)
				&& (a[2] == a[3] - 1) && (a[3] == a[4] - 1)) {
			return 2;
		} else
			return 0;
	}

	private String judge(int[] c) {
		// split it to two situation
		if (same(c)) {
			return judgesame(c);
		} else {
			return judgediff(c);
		}
	}

	private String judgesame(int[] c) {
		if (straight(c) == 1) {
			p.winnings(250);
			String s = "Royal Flush";
			return s;
		} else if (straight(c) == 2) {
			p.winnings(50);
			String s = "Straight Flush";
			return s;
		} else
			return judgediff(c);
	}

	private String judgediff(int[] c) {
		int[] a = new int[5];
		for (int i = 0; i < 5; i++)
			a[i] = c[i] / 10;
		if ((a[1] == a[2]) && (a[2] == a[3]) && ((a[3] == a[4])
				|| (a[0] == a[1]))) {
			p.winnings(25);
			String s = "Four of a Kind";
			return s;
		} else if (((a[0] == a[1]) && (a[1] == a[2]) && (a[3] == a[4]))
				|| ((a[0] == a[1]) && (a[2] == a[3]) && (a[3] == a[4]))) {
			p.winnings(6);
			String s = "Full House";
			return s;
		} else if (same(c)) {
			p.winnings(5);
			String s = "Flush";
			return s;
		} else if (straight(c) != 0) {
			p.winnings(4);
			String s = "Straight";
			return s;
		} else if (((a[0] == a[1]) && (a[1] == a[2])) || ((a[1] == a[2])
				&& (a[2] == a[3]))|| ((a[2] == a[3]) && (a[3] == a[4]))) {
			p.winnings(3);
			String s = "Three of a kind";
			return s;
		} else if (((a[0] == a[1]) && ((a[2] == a[3]) || (a[3] == a[4])))
				|| ((a[1] == a[2]) && a[3] == a[4])) {
			p.winnings(2);
			String s = "Two pairs";
			return s;
		} else if ((a[0] == a[1]) || (a[1] == a[2])
				|| (a[2] == a[3]) || (a[3] == a[4])) {
			p.winnings(1);
			String s = "One pair";
			return s;
		} else {
			p.winnings(0);
			String s = "No pairs";
			return s;
		}
	}
}
