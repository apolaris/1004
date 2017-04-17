class Card: This part has suit and rank, and print method and getSuit, getRank.

class Player: This class has bet, bankroll, hand. The constructor will set bankroll as 0 at first.
	Method addCard and removeCard is method for get and remove hand's card.
	Method winnings will add the bet*odd to bankroll and remove all the cards in player's hand.
	Method show will print card.
	Method getCard will get card by index.
	Method getnet will return the bet.
	Method insert will insert a card by the index.

class Deck: It has cards and top. When construct it, it will initialize 52 card in the Deck and assign top to 0
	Shuffle: It will shuffle in O(n) and can make sure that P(each card in each place) = 1/52. And set top to 0.
	deal: get a card and add 1 to top.

class Game: 
	it has a Player, a Deck, a boolean test to judge whether it's a testhand. This class supports multiplay, which means we can play many times.
	constructor: if there is a valid test hand, then it will init the hand like the argv
	play method: Play a game. First give your bet (from 1 to 5), then it will show you the cards in hand, then you have to give how many cards you want to throw, and then type in the cards' number that you want to throw. And the method will refill the cards in your hand. Then, print the card and the result of your card and show you your bankroll now. When a round is over, you can type in 1 to continue or type in 0 to exit.
	method checkHand: checkhand, return the result of the card and calculate the benefit for player.
	method same: judge whether the suits are same.
	method straight: return the cards' kind of staight.
	method judge: put the cards into two judgediff and judgesame.
	method judgesame and judgediff: judge the card.
	

If use the testhand(argv), the first play's cards will be same as the argvs, but the next play's card will be gained from shuffled deck. So, the testhand can only keep one round and next round is same as formal play. If the testhand is not valid, we won't use testhand.