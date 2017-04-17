class Hangman:
	private ArrayList<String> word: word list.
	private ArrayList<int []> des: descripters for words in list.
	private int guessnum: remaining guess times for player.
	private int length: word's length.
	private int[] ch: note which character is guessed and which not;
	private Scanner input;
	private char[] h: the word now;

	method play: Recieve play's input to initilize the word length, guess time, and start a new hangman game, then ask player whether to play again.
	method game: Play hangman once. Let play input a guess character, and return the result until all the character of the word is guessed out.
	method getWord: Read all the word with a input length to Arraylist word. If there are no words with such length, return false.
	method show: Print all the character guessed and not guessed. Then print the word now.(if some bits haven't been guessed, will print '_' in that bit)
	method delete: When player input a guess character, it will choose the most case, delete other words in Arraylist, and renew guessed character and words. The algorithm is in the following paragraph.
	
Algorithm for choose the most case:
	For each words, I initialize 26 int descriptors. Each descripter represent a character's case by change same bits. For example, for word "people", 'p' exsit in 0th and 3rd, so, it's descripter in binary code is (001000)b, which is 2^0 + 2^3 = 8, 'e' exsit in 1st and 5th, which is (100010)b, which is 2^5 + 2^1 = 34. Then, when player input a character, I will use the character's descripter to split all the remaining words into different families and choose the most one to keep and others to delete.

If you want to run the program, please run on TesterHangman
	