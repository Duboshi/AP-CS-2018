/*
 * With Chap14.java
 * @author Dubos
 */

public class Deck2 extends CardCollection {
	//This means a Deck2 object has the same instance variables and methods as a 
	//CardCollection. Deck2 inherits from CardCollection. Constructors are not
	//inherited. CardCollection is a superclass, and Deck2 is one of its subclass.
	
	//In Java, classes may only extend one superclass. Classes that do not specify
	//a superclass automatically inherit from java.lang.Object.

	public Deck2(String label) {
		super(label);
		//This invokes the constructor of the superclass.
		
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				cards.add(new Card(rank, suit));
			}
		}
		//A Deck2 inherits instance variables and methods from CardCollection and
		//provides a different constructor.
	}
}

//We can create a Deck2 object in Chap14.java:
//Deck2 deck = new Deck2("Deck");
