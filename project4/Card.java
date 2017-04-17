
//Beichen Zhang
//bz2309
//project 4

public class Card implements Comparable<Card> {

	private int suit; // use integers 1-4 to encode the suit
	private int rank; // use integers 1-13 to encode the rank

	public Card(int s, int r) {
		suit = s;
		rank = r;
	}

	public int compareTo(Card c) {
		// use this method to compare cards so they
		// may be easily sorted
		if (c.getSuit() == this.getSuit())
			return 100 * (c.getRank() - this.getRank());
		else
			return (c.getRank() - this.getRank());
	}

	public String toString() {
		// use this method to easily print a Card object
		if (suit > 2) {
			if (suit == 3) {
				String a = "heart";
				return a;
			} else {
				String a = "spade";
				return a;
			}
		} else {
			if (suit == 1) {
				String a = "club";
				return a;
			} else {
				String a = "diamond";
				return a;
			}
		}
	}

	// add some more methods here if needed
	public int getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}

	public void print(int i) {
		// print a card
		String a = this.toString();
		System.out.printf("%d.  ", i);
		System.out.println(a + " " + rank);
	}
}
