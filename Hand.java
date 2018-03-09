/*
 * with Chap14.java
 * @author Dubos
 */

public class Hand extends CardCollection {
	//This means a Hand object has the same instance variables and methods as a 
	//CardCollection. Hand inherits from CardCollection. Constructors are not
	//inherited. CardCollection is a superclass, and Hand is one of its subclass.
	
	public Hand(String label) {
		super(label);
		//This invokes the constructor of the superclass.
	}
	//A hand inherits instance variables and methods from CardCollection and has the 
	//	same constructor.
	
	public void display() {
		System.out.println(getLabel() + ": ");
		for (int i = 0; i < size(); i++) {
			System.out.println(getCard(i));
		}
		System.out.println();
	}
	//A Hand provides an additional method, display().
}

//We can create a Hand object in Chap14.java:
//Hand hand1 = new Hand("hand1");
//Hand drawPile = new Hand("Draw pile");
