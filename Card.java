/*
 * with Chap12.java
 */

public class Card {
	//Declaring the instance variables:
	//private int rank;
	//private int suit;
	//Mapping for suits: Clubs = 0, Diamonds = 1, Hearts = 2, Spades = 3;
	//Mapping for ranks: Ace = 1, Jack = 11, Queen = 12, King = 13;
	//We declare rank and suit as int to compare cards which has a higher rank or 
	//suit.
	
	private final int rank;
	private final int suit;
	
	public static final String[] RANKS = {null, "Ace", "2", "3", "4", "5", "6", "7",
			"8", "9", "10",	"Jack", "Queen","King"};
	public static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
	//In this class, RANKS and SUITS are mostly used in the toString method.
	//Having them defined as class variables, we need not to create and 
	//garbage-collect them every time when toString is invoked.
	
	//Value constructor:
	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
//	public String toString() {
//		String[] ranks = {null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10",
//				 "Jack", "Queen","King"};
//		//null indicates an unused element.
//		String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
//		return ranks[this.rank] + " of " + suits[this.suit];
//	}
	
	public String toString() {
		return RANKS[this.rank] + " of " + SUITS[this.suit];
	}
	
	public boolean equals(Card that) {
		return this.rank == that.rank && this.suit == that.suit;
	}
	
	public int compareTo(Card that) {
		if (this.suit < that.suit) {
			return -1;
		}
		if (this.suit > that.suit) {
			return 1;
		}
		if (this.rank < that.rank) {
			return -1;
		}
		if (this.rank > that.rank) {
			return 1;
		}
		return 0;
	}
	
	public int getRank() {
		return this.rank;
	}
	
	public int getSuit() {
		return this.suit;
	}
}