/*
 * Chap14 Objects of objects
 * with CardCollection.java
 * with Deck2.java
 * with Hand.java
 * with Player.java
 * with Eights.java
 */

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.PrintStream;

public class Chap14 {
	public static void main(String[] args) {
		PrintStream out = System.out;
		
		//By now we can create 
		//a Card(int rank, int suit) which is an object,
		//a Card[] which is an array of objects,
		//a Deck(int n) which is an object of Card[], or an object of arrays.
		
		//In this chapter we will make a game: Crazy Eights.
		//Play it online - https://cardgames.io/crazyeights/
		//Our rules are simpler:
		
		//1. The main objective is to be the first player to get rid of all your 
		//	cards.
		//2. Deal 5 cards to each player to create a "hand" for each player.
		//	Deal one card face up to create the "discard pile". 
		//	Place the remaining cards face down to create the "draw pile".
		//	A hand, the discard pile and the draw pile should can be displayed.
		//3. Each player takes turns placing a single card on the discard pile.
		//	The card must match the rank or suit of the last card on the discard
		//	pile, or an eight, which is a "wild card".
		//4. When players don't have a matching card or an eight, they must draw
		//	new cards until they get one.
		//5. If the draw pile ever runs out, the discard pile is shuffled except the
		//	last card and becomes the new draw pile.
		//6. As soon as a player has no cards, the game ends and all other players 
		//	score penalty points for their remaining cards. Eights are worth 20, 
		//	face cards (Jacks, Queens and Kings) are worth 10, and all others are
		//	worth their rank.
		
		out.println("14.1 & 14.2 Decks and hands. CardCollection");
		//We need to create a deck of cards, a discard pile, a draw pile, and 
		//a hand for each player. And we need to deal, draw, and discard cards.
		
		//Deck, hands and piles have different sizes, and their sizes change as the 
		//game progresses. We solve this problem by using an ArrayList, which is in
		//the java.util package. An ArrayList is a collection, which is an object
		//that contains other objects, so an ArrayList is an object of objects.
		//It provides methods to add and remove elements, and it grows and shrinks
		//automatically.
		
		//Learn to create the CardCollection class.
		out.println();
		
		out.println("14.3 & 14.4 Inheritance");
		//The CardCollection class provides the common features of hands and piles.
		//But Deck, hands and piles have some different features.
		
		//The deck should have a constructor that makes a standard 52-card ArrayList.
		
		//A hand, the draw pile and the discard pile should can be displayed. They do
		//	not need to be standard 52-card ArrayLists. They have the same features and
		//	differ from that of the deck.
		
		//Create the Deck2 class inheriting from the CardCollection class.
		Deck2 deck = new Deck2("Deck");	
		
		//Create the Hand class inheriting from the CardCollection class.
		//We can create hands, a draw pile, a discard pile using the Hand class.
		Hand hand1 = new Hand("Hand1");
		Hand drawPile = new Hand("Draw pile");
		out.println();
		
		//Get familiar with the objects and methods.
		out.println(deck.getLabel());
		out.println(deck.size());
		out.println(deck.empty());
		out.println(deck.getCard(0));
		out.println(deck.getCard(1));
		out.println(deck.getCard(50));
		out.println(deck.getCard(51));
		out.println();
		
		deck.shuffle();
		
		//Deal five cards to hand1 and the rest into the drawPile.
		deck.deal(5, hand1);
		hand1.display();
		
		deck.dealAll(drawPile);
		drawPile.display();
		
		out.println("14.5 The Player class");
		
		//We are able to create a deck of cards, a discard pile, a draw pile, and 
		//a hand for each player. We are also able to deal cards.

		//Now we need to create a Player object who follows the Rule 3 and 4 of 
		//playing and drawing cards. When the game ends, a Player computes penalty
		//points for cards left in his or her hand.
		//A Player has two private attributes: a name and a hand.
		
		out.println("14.6 The Eights class");
		
		//Then we will need an Eights class that has two Players, a drawPile and 
		//a discardPile as private variables.
		//According to Rule 3 it should make the players take turns.
		//According to Rule 5 if the draw pile ever runs out, it should shuffle the
		//	discard pile except the top card and generates the new draw pile.
		//According to Rule 6 it need to check whether the game is over.
		
		//Now learn to create the Player class and the Eights class.
		
		out.println("Let's start a game.");
		out.println();
		Eights crazyEight = new Eights();
		crazyEight.autoGame();
		out.println();

		//The autoGame() is played by the computer with itself.
		//Now create a method game() in the Eights.java and
		//a method userPlay(Eights eights, Card prev) then start a real game.
		Eights realGame = new Eights();
		realGame.game();
	}
}
