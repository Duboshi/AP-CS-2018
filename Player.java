/*
 * with Chap14.java
 */

import java.util.Scanner;

public class Player {
	private String name;
	private Hand hand;
	private Scanner in;
	
	public Player(String name) {
		this.name = name;
		this.hand = new Hand(name);
	}
	
	//(Now turn to create Eights.java)
	
	public String getName() {
		return this.name;
	}
	
	public Hand getHand() {
		return this.hand;
	}
	//(Turn to Eight.java to continue to create the discardPile)
	
	//According to Rule 3, when a player places a single card on the discard pile,
	//	the card must match the rank or suit of the top card on the discard pile,
	//	or it is an eight, which is a "wild card".
	//According to Rule 4, when a player does not have a matching card or an eight,
	//	he/she must draw new cards until they get one.
	//We encapsulate these rules into the autoPlay method.
	public Card autoPlay(Eights eights, Card prev) {
		Card card = searchForMatch(prev);
		if (card == null) {
			card = drawForMatch(eights, prev);
		}
		return card;
	}
	
	public Card searchForMatch(Card prev) {
		for (int i = 0; i < hand.size(); i++) {
			Card card = hand.getCard(i);
			if (cardMatch(card, prev)) {
				return hand.popCard(i);
			}
		}
		return null;
	}
	
	public boolean cardMatch(Card card, Card prev) {
		if (card.getSuit() == prev.getSuit() ||
				card.getRank() == prev.getRank() ||
				card.getRank() == 8) {
			return true;
		}
		return false;
	}
	
	public Card drawForMatch(Eights eights, Card prev) {
		while (true) {
			Card card = eights.draw();
			System.out.println(name + " draws " + card);
			if (cardMatch(card, prev)) {
				return card;
			}
			hand.addCard(card);
		}
	}
	
	public Card userPlay(Eights eights, Card prev) {
		int i;
		Card card = null;
		in = new Scanner(System.in);
		
		System.out.println("Please type the sequence number of the card you choose.");
		System.out.println("For example if you have n cards in your hand"
				+ " and you choose the first, please type 1. ");
		System.out.println("If you have no appropriate card, please type 0.");
		i = in.nextInt();
		
//		if (i < 0 || i > hand.size()) {
//			System.out.println("Invalid number.");
//			userPlay(eights, prev);
//		}
		if (i == 0) {
			card = drawForMatch(eights, prev);
		} else {
			card = hand.popCard(i - 1);
		}
//		if (i > 0 && i <= hand.size()) {
//			card = hand.getCard(i - 1);
//			if (card.getSuit() != prev.getSuit() &&
//					card.getRank() != prev.getRank() &&
//					card.getRank() != 8) {
//				System.out.println("Illegal card");
//				userPlay(eights, prev);
//			}
//		}
		return card;
	}
	
	//According to Rule 6, As soon as the game ends, all players get penalty points
	//for their remaining cards. Eights are worth 20, face cards
	//(Jacks, Queens and Kings) are worth 10, and all others are worth their rank.
	//The winner get penalty point of 0.
	public int score() {
		int score = 0;
		for (int i = 0; i < hand.size(); i++) {
			if (hand.getCard(i).getRank() > 10) {
				score += 10;
			} else {
				if (hand.getCard(i).getRank() == 8) {
					score += 20;
				} else {
					score += hand.getCard(i).getRank();
				}
			}
		}
		return score;
	}
	//The Player class is completed. Go back to Eights.java to create the autoGame
	//method.
}