/*
 * with Chap14.java
 * @author Dubos
 */

import java.util.Scanner;

public class Eights {
	private Player p1;
	private Player p2;
	private Hand drawPile;
	private Hand discardPile;
	private Scanner in;
	
	public Eights() {
		//Create the deck and shuffle it.
		Deck2 deck = new Deck2("Deck");
		deck.shuffle();
		
		//Deal 5 cards to each player('s hands).
		p1 = new Player("DeepDog the AI Player Version 1.37");
		deck.deal(5, p1.getHand());
		p2 = new Player("You the human player");
		deck.deal(5, p2.getHand());
		//(Turn to Player.java to create the getHand() method.)
		
		//Create the discardPile with 1 card.
		discardPile = new Hand("Dicard pile");
		deck.deal(1, discardPile);
		
		//Create the drawPile with the rest cards of the deck.
		drawPile = new Hand("Draw pile");
		deck.dealAll(drawPile);
		
		//To involve the user in the game:
		in = new Scanner(System.in);
	}
	
	//According to Rule 6 we need to check whether the game is over.
	public Boolean gameOver() {
		return p1.getHand().empty() || p2.getHand().empty();
	}
	
	//According to Rule 5 if the draw pile ever runs out, the discard pile should
	//	be shuffled except the top card and becomes the new draw pile.
	//We encapsulate this rule into the draw method, which will be invoked by the
	//	Player class.
	public Card draw() {
		if (drawPile.empty()) {
			Card temp = discardPile.popCard();
			discardPile.shuffle();
			discardPile.dealAll(drawPile);
			discardPile.addCard(temp);
		}
		return drawPile.popCard();
	}
	//(Turn to Player.java to create the Play method.)
	
	//According to Rule 3 we should make the players take turns.
	//Now it is time to create a method to start the game.
	
	public void displayState() {
		System.out.println("------------------State of the game---------------------");
		p1.getHand().display();
		p2.getHand().display();
		System.out.println("Discard pile: " + discardPile.size() + " cards with this"
				+ " one as the last: " + discardPile.last());
	}

	public void autoGame() {
		Player player = p2;
		Card prev;
		Card next;
		
		while(!gameOver()) {
			displayState();
			System.out.println("It's " + player.getName() + "'s turn to play.");
	
			prev = discardPile.last();
			next = player.autoPlay(this, prev);
			System.out.println(player.getName() + " plays " + next);
			System.out.println();
			
			discardPile.addCard(next);
			
			if (player == p1) {
				player = p2;
			} else {
				player = p1;
			}
		}
		
		System.out.println("Game Over.");
		System.out.println(p1.getName() + " get a score of " + p1.score());
		System.out.println(p2.getName() + " get a score of " + p2.score());
	}
	
	public void game() {
		Player player = p2;
		Card prev;
		Card next;
		int i;
		
		while(!gameOver()) {
			displayState();
			System.out.println("It's " + player.getName() + "'s turn to play.");
			prev = discardPile.last();
			
			if (player == p1) {
				System.out.println("Please press Enter...");
				in.nextLine();
				next = player.autoPlay(this, prev);
			} else {
				next = player.userPlay(this, prev);
			}
			
			System.out.println(player.getName() + " plays " + next);
			System.out.println();
			
			discardPile.addCard(next);
			
			if (player == p1) {
				player = p2;
			} else {
				player = p1;
			}
		}
		
		System.out.println("==============GAME OVER==================");
		System.out.println(p1.getName() + " get a score of " + p1.score());
		System.out.println(p2.getName() + " get a score of " + p2.score());
	}
	

	//The Eights.java is completed. Return to Chap14.java to start a game.
}
