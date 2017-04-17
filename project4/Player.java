
//Beichen Zhang
//bz2309
//project 4
import java.util.ArrayList;

public class Player
{

    private ArrayList<Card> hand; // the player's cards
    private double bankroll;
    private double bet;

    // you may choose to use more instance variables

    public Player()
    {
        bet = 0;
        bankroll = 0;
        hand = new ArrayList<Card>();
    }

    public void addCard(Card c)
    {
        // add card to hand
        hand.add(c);
    }

    public void removeCard(int i)
    {
        // remove the ith card
        hand.remove(i - 1);
    }

    public void bets(double amt)
    {
        bet = amt;
        bankroll -= bet;
    }

    public void winnings(int odds)
    {
        // get the pay and clear the cards in hand
        bankroll += bet * odds;
        bet = 0;
        for (int i = 0; i < 5; i++)
        {
            hand.remove(0);
        }
    }

    public double getBankroll()
    {
        // return current balance of bankroll
        return bankroll;
    }

    // you may wish to use more methods here
    public void show()
    {
        // print the card
        int i;
        System.out.println("\nyour cards(marked as 1 to 5): ");
        for (i = 1; i <= 5; i++)
        {
            Card c = hand.get(i - 1);
            c.print(i);
        }
    }

    public Card getCard(int index)
    {
        return this.hand.get(index);
    }

    public double getBet()
    {
        // return the bet
        return bet;
    }

    public void insert(Card c, int index)
    {
        // add card to hand
        hand.add(index-1, c);
    }

    public void reset()
    {
        // add card to hand
        hand = new ArrayList<Card>();
    }
}
