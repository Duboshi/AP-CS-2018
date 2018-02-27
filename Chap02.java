/**
 * Chap02 Variables and operators
 *
 */

public class Chap02 {
	public static void main(String[] args) {
		//"public" method such as main can be invoked from other classes (P52) 
		//"static" (P179)
		//"void" means the method does not yield a result (unlike the Math
		//	method, for example). (P52)
		//main has a single parameter, called args, which has type String[].
		//	That means whoever invokes main must pro  vide array of strings (P52)
		
		System.out.println("2.1 Declaration, assignment, and the String type");
		String message = "Hello, world! ";
		//this statement is a declaration. It declares that the variable
		//message has the type String.
		System.out.print(message);
		message = "My name is Dubos.";
		//this is an assignment statement.
		System.out.println(message);
		System.out.println();

		System.out.println("2.8 Order of operations");
		System.out.println(1 + 2 * 3);
		System.out.println((1 + 2) * 3);
		System.out.println(1 + 2 + "Hello");
		System.out.println("Hello" + 1 + 2);
		//order of operations
		System.out.println();
		
		System.out.println("2.2 Initialization, and the int type");
		int hour = 13, minute = 24, second = 07;
		//initializing variable with the same type on one line. We can also:
		//int hour, minute, second;
		//hour = 13; minute = 24; second = 00; which is actually on 4 lines
		//(see section 9 "Exercise 2.3"0 for example)
		//hour = 13, minute = 24, second = 0; it won't work.
		//notice it prints as "13:24:0".
		//!!!I don't know how to fix it.
		System.out.print("The current time is " + hour + ":" + minute + ":");
		System.out.println(second + ".");
		System.out.println();
		
		System.out.println("2.2 Octal");
		//In Java and several other languages, an integer literal beginning
		//with 0 is interpreted as an octal (base 8) quantity.
		//So for single-digit numbers (other than 08 and 09, which are not
		//allowed), the result is the same, so you might not notice that
		//they are being interpreted as octal. However, if you write numbers
		//with more than one significant digit you might be confused by the 
		//result.
		//System.out.println(08);
		System.out.println(010);
		System.out.println(0123);
		hour = 13; minute = 24; second = 8;
		System.out.print("The current time is ");
		System.out.print(hour + ":" + minute + ":");
		System.out.println(second + ".");
		System.out.println();
				
		System.out.println("2.5 Arithmetic operators, integer division");
		//Java performs integer division when the operands are integers.
		//The displayed result is the floor integer of the real result.
		System.out.print("Number of minutes since midnight: ");
		System.out.println(hour * 60 + minute);
		System.out.print("Fraction of the hour that has passed: ");
		System.out.println(minute / 60);
		System.out.println(-4 / 3); //-1
		System.out.println(-3 / 3);
		System.out.println(-2 / 3); //0
		System.out.println(-1 / 3);
		System.out.println(1 / 3); //0
		System.out.println(2 / 3); //0
		System.out.println(3 / 3);
		System.out.println(4 / 3);
		System.out.println(5 / 3); //1
		System.out.println(6 / 3);
		System.out.println();
		
		System.out.println("2.6 The floating-point type: double");
		//The default floating-point type in Java is called double,
		//short for "double-precision".
		System.out.println(-4 / 3.0);
		System.out.println(-3 / 3.0);
		System.out.println(-2 / 3.0);
		System.out.println(-1 / 3.0);
		System.out.println(1 / 3.0);
		System.out.println(2 / 3.0);
		System.out.println(3 / 3.0);
		System.out.print("Fraction of the hour that has passed: ");
		System.out.println(minute / 60.0);
		double y = 1 / 3;
		System.out.println(y);
		//common mistake, y will be performed as integer division
		System.out.println();
		
		System.out.println("2.7 Rounding error");
		System.out.println(0.1);
		System.out.println(0.1 + 0.1);
		System.out.println(0.1 + 0.1 + 0.1);
		System.out.println(0.1 + 0.1 + 0.1 + 0.1);
		System.out.println(0.1 + 0.1 + 0.1 + 0.1 + 0.1);
		System.out.println(0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1);
		System.out.println(0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1);
		System.out.println(0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1);
		System.out.println(0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1);
		System.out.println(0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1);
		System.out.println(0.1 * 10);
		//We can avoid the problem by using integers as long as they are smaller than
		//2,147,483,648
		System.out.println();
		
		System.out.println("2.10 Types of errors");
		//compile-time errors occur when you violate the syntax rules of Java:
		//System.out.println(7)
		//run-time errors occur after the program has started running
		//System.out.println(7 /0);
		System.out.println();
		
		System.out.println("Exercise 2.2");
		String day = "Saturday", month = "August";
		int date = 12, year = 2017;
		System.out.println("American format:");
		System.out.println("\t" + day + "," + month + " " + date + "," + year);
		System.out.println("European format:");
		System.out.println("\t" + day + "," + date + " " + month + "," + year);
		System.out.println();
		
		System.out.println("Exercise 2.3");
		System.out.print("The starting time of this exercise is ");
		System.out.println(hour + ":" + minute + ":" + second + ".");
		int secondSinceMidnight = hour * 3600 + minute * 60 + second;
		double percentOfDay = secondSinceMidnight / (24 * 3600.0);
		System.out.print("\tThe number of seconds since midnight is ");
		System.out.println(secondSinceMidnight + ".");
		System.out.println("\tIt has passed " + percentOfDay + "% of the day.");
		//hour = 13; minute = 41; second = 50; it works.
		int hour2, minute2, second2;
		hour2 = 13; minute2 = 41; second2 = 50;
		System.out.print("The ending time is ");
		System.out.println(hour2 + ":" + minute2 + ":" + second2 + ".");
		System.out.print("I spent ");
		System.out.print(hour2 - hour + " hours, ");
		System.out.print(minute2 - minute + " minutes, and ");
		System.out.print(second2 - second + " seconds");
		System.out.println(" on this exercise.");
		System.out.println();
	}
}