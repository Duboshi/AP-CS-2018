/*
 * Chap 12 Arrays of objects
 * with Card.java
 */

import java.util.Arrays;
import java.io.PrintStream;

public class Chap12 {
	
	public static void main(String[] args) {
		PrintStream out = System.out;
		
		out.println("12.1, 12.2, 12.4 Creating the Card class");
		//Create the Card class.
		//Mapping for suits: Clubs = 0, Diamonds = 1, Hearts = 2, Spades = 3;
		
		//Create card objects: Ace of Hearts and 2 Diamonds.
		Card aceHearts = new Card(1, 2);
		Card twoDiamonds = new Card(2, 1);
		
		//Create the toString method using arrays for Card class so that the result of
		//System.out.println(aceHearts);
		//is Ace of Hearts and the result of
		//System.out.println(twoDiamonds);
		//is 2 of Diamonds.
		out.println(aceHearts);
		out.println(twoDiamonds);
		
		//Create the equals method.
		out.println(aceHearts.equals(twoDiamonds));	
		
		//Create the compareTo method.
		//Comparison of suits comes first: Clubs < Diamonds < Hearts < Spades.
		out.println(aceHearts.compareTo(twoDiamonds));
		
		//Create the getters.
		out.println(aceHearts.getRank());
		out.println(aceHearts.getSuit());
		out.println();
		
		out.println("12.3 Class variables");
		//Class variables are defined in a class, before the method definitions.
		//They are public (we can access them by calling Card.RANKS),
		//static (shared across all instances of the class ),
		//and final (can not be reassigned).
		//Declare class variables String[] RANKS and String[] SUITS after the instance
		//variables of the Card class.
		out.println(Arrays.toString(Card.RANKS));
		out.println(Arrays.toString(Card.SUITS));
		out.println();
		
		out.println("12.5 final instance variables");
		//We do not want to modify any existing card, so we make the Card class
		//immutable. Not creating setter is not enough.
		//Declare the instance variables final, so that no other programmers could
		//add a modifier later. Once the instance variables of an instance object is
		//assigned, they can never be reassigned.		
		out.println();
		
		out.println("12.6 Array of objects");
		Card[] cards = new Card[52];
		//Creation of references to 52 Card objects, not creation of 52 Card objects.
		//The elements are initialized to null.
		//Write a method anyCard(Card[] cards) to check if all elements of cards are
		//null.
		anyCard(cards);
		
		//Since there is no cards, we cannot get any instance variables from any 
		//element of cards.
		//out.println(cards[0].getRank());
	
		//Now we populate the array.
		int i = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				cards[i] = new Card(rank, suit);
				i++;
			}
		}
		
		//Display the 52-card deck.
		printDeck(cards);
		out.println();
		
		out.println("12.7 - 12.10 Binary search");
		//Write a search(Card[] cards, Card target) method to search for an object
		//in the array of objects.
		out.println(search(cards, twoDiamonds));
		
		//If the cards are in order, we can use a better algorithm: Binary search.
		//1. Choose an index between low and high and call it mid. Compare the card
		//	at mid to the target.
		//2. If they are equal, return the index.
		//3. If the card at mid is lower than the target, search the range from
		//	mid + 1 to high.
		//4. If the card at mid is higher than the target, search the range from
		//	low to mid - 1.
		//Write the biSearch(Card[] cards, Card target) method.
		out.println(biSearch(cards, twoDiamonds));
		//If the array contains n elements, binary search requires log2n comparisons,
		//and sequential search requires n. For large value of n, binary search can
		//be much faster.
		
		//If the method you just wrote is iterative, write the recursive version.
		//Vice versa.	
		out.println(biSearch(cards, twoDiamonds, 0, cards.length - 1));
	}
	
	public static void anyCard(Card[] cards) {
		boolean check = false;
		for (int i = 0; i < cards.length; i++) {
				check = check || cards[i] != null;
		}
		if (check == false) {
			System.out.println("No card yet.");
		} else {
			System.out.println("There is at least one card.");
		}
	}
	
	public static void printDeck(Card[] cards) {
		for (int i = 0; i < cards.length; i++) {
			System.out.println(cards[i]);
		}
	}
	
//	public static int search(Card[] cards, Card target) {
//		for (int i = 0; i < cards.length; i++) {
//			if (cards[i] == target) {
//				return i;
//			}
//		}
//		return -1;	
//	}
	
		public static int search(Card[] cards, Card target) {
			for (int i = 0; i < cards.length; i++) {
				if (cards[i].equals(target)) {
					return i;
				}
			}
			return -1;
	}
		
		//Iterative version of biSearch.
		public static int biSearch(Card[] cards, Card target) {
			int low = 0;
			int high = cards.length - 1;
			while (low <= high) {
				int mid = (low + high) / 2;
				if (cards[mid].compareTo(target) == 0) {
					return mid;
				}
				if (cards[mid].compareTo(target) < 0) {
					low = mid + 1;
				}
				if (cards[mid].compareTo(target) > 0) {
					high = mid - 1;
				}
			}
			return -1;
	}
		
		//Recursive version of biSearch.
		public static int biSearch(Card[] cards, Card target, int low, int high) {
			if (low > high) {
				return -1;
			} else {
				int mid = (low + high) / 2;
				if (cards[mid].compareTo(target) == 0) {
					return mid;
				} else {
					if (cards[mid].compareTo(target) > 0) {
						return biSearch(cards, target, low, mid - 1);
					} else {
						return biSearch(cards, target, mid + 1, high);
					}
				}
			}
		}
}
