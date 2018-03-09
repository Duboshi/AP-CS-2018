/*
 * with Chap14.java
 * @author Dubos
 */

import java.util.ArrayList;
import java.util.Random;

public class CardCollection {
	
	public String label;
	public ArrayList<Card> cards;
	//cards is an ArrayList of Card objects, so it is an object of objects.
	
	public CardCollection(String label) {
		this.label = label;
		this.cards = new ArrayList<Card>();
	}
	
	
	//......The getters:......
	
	
	public String getLabel() {
		return label;
	}
	
	public Card getCard(int i) {
		return cards.get(i);
	}
	//ArrayList provides the get(i) method. This is a wrapper method for get(i).
	
	//The last card is the most frequently used one in the CardCollection.
	//When a card is placed to the discard pile by a player, it should match the 
	//	last card in the discard pile.
	//When a player needs to draw a card, he/she can only draw the last card in the
	//	draw pile.
	//So we need a method getting the last card.
	public Card last() {
		int i = size() - 1;
		return cards.get(i);
	}
	//This is not a wrapper method.
	
	public int size() {
		return cards.size();
	}
	//This is a wrapper method for size(), which is provided by the ArrayList.
	
	//Create the empty() method indicating whether size() is zero.
	//When a player's hand is empty, the game is over.
	//When the draw pile is empty, the discard pile will be shuffled except the last
	//	card and becomes the new draw pile.
	public boolean empty() {
		return cards.size() == 0;
	}
	//This is not a wrapper method.

		
	//......The add and remove methods:......
	
	
	//We need to be able to add cards to the collection.
	//ArrayList provides the add method that adds an element to the collection:
	public void addCard(Card card) {
		cards.add(card);
	}
	//This is a wrapper method for add.
	
	//We also need to remove cards from the collection.
	//ArrayList provides the remove method that takes an index, removes the card
	//at that location, and shifts the following cards left to fill the gap:
	public Card popCard(int i) {
		return cards.remove(i);
	}
	//This is a wrapper method for remove.
	
	//If we are dealing cards from a shuffled deck, it's most convenient to remove
	//the last card. Here is an overloaded version of popCard:
	public Card popCard() {
		int i = size() - 1;
		return popCard(i);
	}
	//This is not a wrapper method since it's a little complicated.
	
	//The deal method removes n cards from this CardCollection and adds them to
	//another CardCollectino that.
	public void deal(int n, CardCollection that) {
		for (int i = 0; i < n; i++) {
			Card card = popCard();
			that.addCard(card);
		}
	}
	
	//The dealAll method deals all of the cards of this to that.
	public void dealAll(CardCollection that) {
		for (int i = 0; i < this.size(); i++) {
			Card card = popCard();
			that.addCard(card);
		}
	}

	
	//......The shuffle methods:......
	
	
	//ArrayList provides the set(i, element) method.
	public void swapCards(int i, int j) {
		Card temp = cards.get(i);
		cards.set(i, cards.get(j));
		cards.set(j, temp);
	}
	//This is not a wrapper method.
	
	public void shuffle() {
		Random random = new Random();
		for (int i = size() - 1; i > 0; i--) {
			int j = random.nextInt(i);//a random integer in [0, i - 1]
			swapCards(i,j);
		}
	}
		
	//The CardCollection class is completed.
}
