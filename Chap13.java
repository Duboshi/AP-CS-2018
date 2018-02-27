/*
 * Chap 13 Object of arrays
 * with Deck.java
 */

import java.io.PrintStream;

public class Chap13 {

	public static void main(String[] args) {
		PrintStream out = System.out;
		
		out.println("13.1 The Deck class");
		//Create the deck class. Then create a standard Deck here. 
		Deck deck = new Deck();
		
		//Print the standard deck.
		deck.print();
		out.println();

		out.println("13.2 Shuffling decks");
		//for each index i {
		//	randomInt: choose a random number between i and (length - 1);
		//	swapCards: swap the ith card and the randomly selected card.
		//}
		
		//The process of Writing pseudo code first and then writing methods
		//to make it work is called top-down development.
		
		//Write the randomInt(int low, int high) and swapCards(int n, int m)
		//methods for Deck.java.
		
		//Write the shuffle() method for Deck.java.
		deck.shuffle();
		deck.print();
		out.println();
		
		out.println("13.3 Selection sort");
		//Put the messed-up deck back in order. We can use the selection sort 
		//algorithm.
		
		//public void selectionSort() {
		//	for each index i {
		//		lowestIndex: Find the lowest card at or to the right of i
		//		swapCards: Swap the ith card and the lowest card found
		//	}
		//}
		deck.selectionSort();
		deck.print();
		out.println();
		
		out.println("13.4 - 13.6 Merge sort");
		deck.shuffle();
		deck.print();
		out.println();
		//We can also use the merge sort algorithm:	
		
		//public void mergeSort() {
		//	If the deck has 0 or 1 cards, return itself.
		//	subdeck: Split the deck into two
		//	mergeSort(): sort the subdecks
		//	Merge: Merge the two subdecks and return the result
		
		//public void mergeSort() {
		//	If the deck has 0 or 1 cards, return itself.
		//	subdeck(): split the deck into two, d1 and d2.
		//	mergeSort(): sort the subdecks d1 and d2
		//	merge(Deck d1, Deck d2): compare the first card from each sorted 
		//		subdeck and choose the lower one. Add it to the merged deck. 
		//		Repeat until one of the subdecks is empty. Then take the 
		//		remaining cards and add them to the merged deck.

		
		//First, write subdeck(int low, int high) in Deck.java that returns a new
		//deck that contains the specified subset of the deck.
		
//		public Deck merge(Deck d1, Deck d2) {
//			//use the index i to keep track of where we are at in the first deck,
//			//and the index j for the second deck
//			int i = 0;
//			int j = 0;
//			//the index k traverses the resulting this deck
//			for (int k = 0; k < this.card.length; k++) {
//				//Compare the two cards d1.cards[i] and d2.cards[j], add the smaller
//				//	to this deck at position k
//				//increment either i or j
				//If all cards of any subdeck have been added to this deck, add
				//	all the remaining cards of the other deck to this deck.
//			}
//			//return this deck
//		}
		deck.mergeSort().print();
		out.println();
		
		
		out.println("Asymptotic analysis of algorithms");
		//The running time of an algorithm on a particular input is the number of 
		//primitive operations or ¡°steps¡± executed. The worst-case running time
		//gives us an upper bound on the running time. We usually consider one
		//algorithm to be more efficient than another if its worst-case running
		//time has a lower order of growth. (CLRS 2.2)
		
		//The selection sort is not very efficient. To sort n items, it has to 
		//traverse the array at most n-1 times. Each traversal takes an amount of time
		//proportional to at most n. The total time is proportional to 
		//n * (n ¨C 1).	
		//We say that the selection sort has a worst-case running time of 
		//\Theta \left( n^{2}\right)
		//(prounced "theta of n-squared").
		
		//The merge sort is more efficient. It has a worst-case running time of
		//\Theta \left( n\log_{2}n\right)		
	}

}
