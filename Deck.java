/*
 * with Chap13.java
 */

import java.util.Random;

public class Deck {
	public Card[] cards;
	private Random random = new Random();
	
	public Deck() {
		this.cards = new Card[52];
		int index = 0;
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				this.cards[index] = new Card(rank,suit);
				index++;
			}
		}	
	}
	//A Deck is an object of cards. So it is an object of arrays.
	
	public Deck(int n) {
		this.cards = new Card[n];
	}
	//The value constructor creates arrays with n Card objects.
	
	public void print() {
		for (int i = 0; i < this.cards.length; i++) {
			System.out.println(this.cards[i]);
		}
	}
	
	public int randomInt(int low, int high) {
		return low + this.random.nextInt(high - low + 1);
	}
	
	public void swapCards(int m, int n) {
		Card temp = this.cards[m];
		this.cards[m] = this.cards[n];
		this.cards[n] = temp;
	}
	
	public void shuffle() {
		for (int i = 0; i < this.cards.length; i++) {
			swapCards(i, randomInt(i, this.cards.length - 1));
		}
	}
	
	public int indexLowest(int i) {
		int indexLowest = i;
		for (int j = i + 1; j < this.cards.length; j++) {
			if (this.cards[indexLowest].compareTo(this.cards[j]) > 0) {
				indexLowest = j;
			}
		}
		return indexLowest;
	}
	
	public void selectionSort() {
		for (int i = 0; i < this.cards.length; i++) {
			swapCards(i, indexLowest(i));
		}
	}
	
	public Deck subdeck(int low, int high) {
		Deck sub = new Deck(high - low + 1);
		for (int i = 0; i < sub.cards.length; i++)
			sub.cards[i] = this.cards[low + i];
		return sub;
	}
	
	public Deck merge(Deck d1, Deck d2) {
		int i = 0;
		int j = 0;
		for (int k = 0; k < this.cards.length; k++) {
			if (i == d1.cards.length) {
				if (j < d2.cards.length) {
					this.cards[k] = d2.cards[j];
					j++;
				}
			} else {
				if (j == d2.cards.length) {
					this.cards[k] = d1.cards[i];
					i++;
				} else {
					if (d1.cards[i].compareTo(d2.cards[j]) <= 0) {
						this.cards[k] = d1.cards[i];
						i++;
					} else {
						this.cards[k] = d2.cards[j];
						j++;
					}
				}
			}
		}
		return this;
	}
	
//	public static Deck merge(Deck d1, Deck d2) {
//		Deck result = new Deck(d1.cards.length + d2.cards.length);
//		int i = 0; //i is the index of d1
//		int j = 0; //j is the index of d2
//		for (int k = 0; k < result.cards.length; k++) {
//			if (i == d1.cards.length) {
//				if (j < d2.cards.length) {
//					result.cards[k] = d2.cards[j];
//					j++;
//				}
//				//if d1 has 0 element and j has at least 1 element, 
//				//copy d2 to result.
//			} else {
//				if (j == d2.cards.length) {
//					result.cards[k] = d1.cards[i];
//					i++;
//				//if d1 has at least 1 element and d2 has 0 element,
//				//copy d1 to result.
//				} else {
//					if (d1.cards[i].compareTo(d2.cards[j]) <= 0) {
//						result.cards[k] = d1.cards[i];
//						i++;
//					} else {
//						result.cards[k] = d2.cards[j];
//						j++;
//					}
//				}
//			}
//		}
//		return result;
//	}
	
	public Deck mergeSort() {
		if (this.cards.length <= 1) {
			return this;
		}
		Deck d1 = subdeck(0, (this.cards.length - 1) / 2);
		Deck d2 = subdeck((this.cards.length + 1) / 2, this.cards.length - 1);
		return merge(d1.mergeSort(), d2.mergeSort());
	}
	
}