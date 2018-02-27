/*
 * Chap11 Classes
 * with Time.java
 */

import java.io.PrintStream;

public class Chap11 {

	public static void main(String[] args) {
		PrintStream out = System.out;
		
		//Defining a class creates a new object type with the same name.
		//Every object is an instance of some class.
		
		//A class definition is like a template for objects: it specifies what
		//attributes the objects have and what methods can operate on them.
		
		//The methods that operate on an object type are defined in the class for 
		//that object.
		
		out.println("11.1 - 11.3 Instance variables, constructors");
		//Now Create the Time class: Time.java
		
		//Create a Time object, time1.
		Time time1 = new Time();
		//When we invoke new, Java creates the object and calls the constructor to
		//initialize the instance variables. Then new returns a reference to the new
		//object.
		
		//Now create a value constructor in the Time class.
		
		//Create a Time object, time2, in Chap11.java with 
		//hour = 24, minute = 59 and second = 60.
		Time time2 = new Time(24, 59, 60);
		out.println();
		
		out.println("11.5 Displaying objects");
		out.println(time1);
		out.println(time2);
		//The results are not what we want.
		//Create an instance method printTime()
		time1.printTime();
		time2.printTime();
		out.println();
		
		out.println("11.4 Getters and setters");
		//out.println(time1.hour);
		//Because the instance variables of Time are private. We cannot access them
		//from outside the Time class.
		
		//To access the instance variables from outside, we need to create methods 
		//in the Time class called getters.
		//To modify the instance variables from outside, we need to create methods
		//in the Time class called setters.
		out.println(time1.getHour());
		out.println(time2.getHour());
		time2.setHour(2);
		time1.printTime();
		time2.printTime();
		out.println();

		out.println("11.6 The toString method");
		String name = "John von Neumann";
		out.println(name);
		//Every object type has a toString method that returns a String
		//representation of the object. Create a toString method for Time class. 
		out.println(time1);
		out.println(time2);
		out.println();
		
		out.println("11.7 The equals method");
		//The == operator checks whether variables refer to the same object.
		//Write a equals method for Time class checking whether variables have 
		//the same value.
		out.println(time1.equals(time2));
		out.println();
		
		out.println("11.8 Pure methods");
		Time goToBed = new Time(23, 0, 0);
		//If you wake up 10 hours, 20 minutes and 30 seconds later, what will be 
		//the time?
		Time sleep = new Time(10, 20, 30);
		//Write a method add(Time t1, Time t2) and invoke 
		//Time.add(goTOBed, sleep)to solve the problem. Is it a static or 
		//instance method?
		out.println(Time.add(goToBed, sleep));
		//Write an method add(Time t) and invoke goToBed.add(sleep) to solve the
		//problem. Is it a static or instance method?
		out.println(goToBed.add(sleep));
		
		//Write a method increment(Time t) that does not return a new Time object
		//but modifies the existing Time object. Is it a static or instance method?
		out.println(goToBed.modifier(sleep));
		out.println(goToBed);
		//The method modifier(Time t)has modified the arguments of goToBed.
		
		//Methods like add are pure methods:
		//(1) The return value of the pure methods solely depends on its 
		//		arguments. Hence, if you invoke the pure methods with the same set
		//		of arguments, you will always get the same return values.
		//(2) They do not have any side effects like output to I/O devices.
		//		In computer science, a function or expression is said to have a 
		//		side effect if it modifies some state outside its scope or has 
		//		an observable interaction with its calling functions or the outside
		//		world besides returning a value.
		//		- https://en.wikipedia.org/wiki/Side_effect_(computer_science)
		//(3) They do not modify the arguments which are passed to them.
		//https://stackoverflow.com/questions/22395311/difference-between-pure-and-impure-function
		
		//Math.random() is impure because it may return different values
		//out.println() is impure because it causes output to an I/O device as a 
		//side effect.
		//goToBed.modifier(Time t) is impure because it modifies the arguments.
		
		//To make a class immutable, we should not provide modifier methods.
		out.println();
	}
}