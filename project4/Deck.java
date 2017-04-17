
//Beichen Zhang
//bz2309
//project 4

public class Deck {

	private Card[] cards;
	private int top; // the index of the top of the deck
	// add more instance variables if needed

	public Deck() {
		// make a 52 card deck here
		top = 0;
		cards = new Card[52];
		int num = 0;
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 14; j++) {
				cards[num] = new Card(i, j);
				num++;
			}
		}
	}

	public void shuffle() {
		// shuffle the deck here
		top = 0;
		Card temp;
		int key;
		for (int i = 51; i > 0; i--) {
			key = (int) (Math.random() * (i + 1));
			temp = cards[key];
			cards[key] = cards[i];
			cards[i] = temp;
		}

	}

	public Card deal() {
		// pop a card
		top++;
		return cards[top - 1];
	}

	// add more methods here if needed

}
