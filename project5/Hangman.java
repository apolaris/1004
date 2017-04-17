//Beichen Zhang
//bz2309
//1004, project5
//Hangman.class, all the methods are here.
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;

public class Hangman {
	private ArrayList<String> word; // remain list
	private ArrayList<int[]> des; // descriptor for words
	private int guessnum; // chances you guess
	private int length; // word's length
	private int[] ch; // Note whether each character is guessed
	private Scanner input;
	private char[] h; // Note each bit on a word

	public Hangman() {
		guessnum = 10;
		des = new ArrayList<int[]>();
		word = new ArrayList<String>();
		length = 0;
		ch = new int[26];
		input = new Scanner(System.in);
		h = new char[29];
	}

	public void play() {

		int yes;
		do {
			System.out.println("please input the length of the word you guess:");
			while (true) {
				if (!input.hasNextInt()) {
					System.out.println("please input an integer:");
					input.nextLine();
					continue;
				} else {
					length = input.nextInt();

                    if (!getWord()) {
                        System.out.printf("There are no words with"
                            + " length of %d, please input an valid integer:\n"
                            ,length);
                        continue;
                    }
				}
				break;
			}
			System.out.println("Please input how many chances" +
                      " you want to guess:");
			while (true) {
				if (!input.hasNextInt()) {
					System.out.println("please input an integer:");
					input.nextLine();
					continue;
				} else {
					guessnum = input.nextInt();
				}
				break;
			}
			game(); // begin a game
			word.clear();
			des.clear();
			guessnum = 10;
			ch = new int[26];
			h = new char[29]; // initialize them for next game
			System.out.println("Input 1 to exit and input 0 for continue:");
			while (true) {
				if (!input.hasNextInt()) {
					System.out.println("please input an integer:");
					input.nextLine();
					continue;
				} else {
					yes = input.nextInt();
					if (yes != 1 && yes != 0) {
						System.out.println("Input 1 to exit and"
                         + " input 0 for continue:");
                        input.nextLine();
						continue;
					}
				}
				break;
			}
		} while (yes == 0);
	}

	public void game() {
		char gu;
		boolean iff = false;
		while (true) {
			if (iff) {
				System.out.println("Congratulations, you win! The word is:");
				for (int i = 0; i < length; i++) {
					System.out.printf("%c", h[i]);
				}
				System.out.printf("\n");
				break;
			}
			if (guessnum == 0) {
				System.out.println("Haha, you lose! The solution is "
                       + word.get(0));
				for (int i = 0; i < length; i++) {
					if (h[i] == 0)
						System.out.printf("_ ");
					else
						System.out.printf("%c ", h[i]);
				}
				System.out.printf("\n");
				break;
			}
			show();
			System.out.println("Please input a lower-case character:"
					+ "\n(If you want to see the number"
                    + " of rest words, then input 0. "
					+ "\nIf you want to print the remaining"
					+ " words to the screen, then input 1. "
					+ "\nIf you want to print the remaining"
					+ " words to a file, then input 2.)");
			while (true) {
				String ss = input.next();
				gu = ss.charAt(0);
				if (gu == '0') { // print the number of words
					System.out.println("The number of rest words is " +
                         word.size());
					System.out.println("Please input an character" +
                         " which is not guessed:");
					continue;
				}
				if (gu == '1') { // print to the screen
					int remain = word.size();
					for (int index = 0; index < remain; index++) {
						System.out.println(word.get(index));
					}
					System.out.println("Please input an " +
                        "character which is not guessed:");
					continue;
				}
				if (gu == '2') { // print to a file
					int remain = word.size();
					try {
						PrintWriter output = new PrintWriter("remainWord.txt");
						for (int index = 0; index < remain; index++) {
							output.println(word.get(index));
						}
						output.close();
					} catch (IOException e) {
						System.out.println("Can't init such file!");
					}
					System.out.println("The words has been output to remainWord.txt"
                        + ". Please input an character which is not guessed:");
					continue;
				}
				if(gu > 'z' || gu < 'a' || ss.length() > 1 || ch[gu-'a'] != 0){
					System.out.println("Please input an"
                         + " character which is not guessed:");
					continue;
				}
				break;
			}
			iff = delete(gu);
		}
	}

	private boolean getWord() { // read the words out
		if (length <= 0)
			return false;
		try {
			File fp = new File("dictionary.txt");
			if (!fp.isFile()) {
				System.out.println("No such file!");
				return false;
			}
			Scanner get;
			get = new Scanner(fp);
			String a;
			int[] ara;
			while (get.hasNext()) {
				a = get.next();
				if (a.length() == length) {
					word.add(a);
					ara = new int[26];
					for (int i = 0; i < length; i++) { // pick out words
						ara[a.charAt(i) - 'a'] += (1 << i);
					}
					des.add(ara);
				}
			}
			get.close();
			return !(word.isEmpty());
		} catch (FileNotFoundException fred) {
			System.out.println("no such file");
			System.out.println(fred);
			return false;
		}
	}

	private void show() { // show the characters and word
		System.out.println("The character you have guessed:");
		for (int i = 0; i < 26; i++) {
			if (ch[i] == 1)
				System.out.printf("%c ", 'A' + i);
		}
		System.out.printf("\n");
		System.out.println("The character you have not guessed:");
		for (int i = 0; i < 26; i++) {
			if (ch[i] == 0)
				System.out.printf("%c ", 'A' + i);
		}
		System.out.printf("\n");
		System.out.println("The word:");
		for (int i = 0; i < length; i++) {
			if (h[i] == 0)
				System.out.printf("_ ");
			else
				System.out.printf("%c ", h[i]);
		}
		System.out.printf("\nYou can only guess %d time!\n", guessnum);
	}

	private boolean delete(char gu) {
        // put the words into families by descriptor and choose most one
		ArrayList<Integer> sort = new ArrayList<Integer>();
		int ll = word.size(), i, mark = gu - 'a';
		ch[mark] = 1;
		for (i = 0; i < ll; i++) {
			int[] dess = des.get(i);
			sort.add(dess[mark]);
		}
		Collections.sort(sort);
		int count = 0, num = 0, maxcount = 0, maxnum = 0;
		for (i = 0; i < ll; i++) {
			int j = sort.get(i);
			if (j == num) {
				count++;
			} else {
				if (count > maxcount) {
					maxcount = count;
					maxnum = num;
					count = 1;
					num = j;
				} else {
                    count = 1;
					num = j;
				}
			}
		}

		if (count > maxcount) {
			maxcount = count;
			maxnum = num;
		}
		for (i = 0; i < ll;) { // delete all the other words
			if (des.get(i)[mark] != maxnum) {
				des.remove(i);
				word.remove(i);
				ll--;
			} else {
				i++;
			}
		}
		i = 0;
		if (maxnum == 0)
			guessnum--;
		while (maxnum != 0) { // use descriptor
			if (maxnum % 2 == 1) {
				h[i] = gu;
			}
			maxnum /= 2;
			i++;
		}

		for (i = 0; i < length; i++) {
			if (h[i] == 0)
				return false;
		}
		return true;
	}
}
