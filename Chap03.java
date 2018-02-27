/**
 * Chap03 Input and output
 *
 */

import java.util.Scanner;
//This import statement is used for "2. The Scanner class".
//Import statement cannot be inside a class definition.

//12345678901234567890123456789012345678901234567890123456789012345678901234567890
//When statements get longer than 80 characters, it is better to break them
//across multiple lines.
		
public class Chap03 {
	private static Scanner in;

	public static void main(String[] args) {
		
		String line, name;
		double inch, cm, inchDouble, remainderDouble;
		final double CM_PER_INCH = 2.54;
		int inchInt, quotient, remainderInt, age;
		in = new Scanner(System.in);
		//By convention, all variables and constants are declared at the top of main.
		
		System.out.println("3.1 The System class");
		System.out.println(System.out);
		//The result indicates that System.out is a PrintStream.
		//ThinkJava says  that out is a ¡°special value¡± provided by the System class.
		//System is a class defined in the java.lang package.
		//"out" is a field in the System class (JavaLibrary). 
		//PrintStream is a class defined in the java.io package.
		//https://docs.oracle.com/javase/7/docs/api/java/lang/System.html#out
		//https://docs.oracle.com/javase/7/docs/api/java/io/PrintStream.html
		System.out.println();
		
		System.out.println("3.2 The Scanner class, and the nextLine method");
		//"in" is a field in the System class (JavaLibrary). ThinkJava says
		//that the System class also provides the special value System.in.
		//Scanner is a class defined in the java.util package. Before we can
		//use Scanner, We have to import it at the beginning of the file.

		System.out.print("Type something: ");
		line = in.nextLine();
		//The nextLine method read a line of input from the keyboard and returns
		//a String. It reads characters until it gets to a new line.
		System.out.println("You said: " + line);
		
		System.out.print("Type something else: ");
		line = in.nextLine();
		System.out.println("You also said: " + line);
		System.out.println();
		
		System.out.println("3.4-3.5 nextInt, nextDouble, and constants");
		System.out.print("What is your height in centimeters? ");
		cm = in.nextDouble();
		//nextInt reads input from the keyboard and returns a floor integer.
		//nextDouble reads input and returns a floating-point number.
		//nextInt and nextDouble read characters until it gets to a non-digit.
		//Use 2.8765 for example.
		inch = cm / CM_PER_INCH;
		System.out.print(cm + " centimeters = ");
		System.out.println(inch + " inches");
		System.out.println();
		
		System.out.println("3.10 The Scanner bug, and the %s %d format specifier");
		//nextInt and nextDouble read until it gets to a non-digit.
		//nextLine reads characters until it gets to a new line.
				
		System.out.print("What is your name? ");
		in.nextLine(); //read the new line, because a /n was typed before.
		name = in.nextLine();
		System.out.print("What is your age? ");
		age = in.nextInt();
		System.out.println("Hello " + name + ", age " + age + ".");
		System.out.printf("Hello %s, age %d.\n", name, age);
		//The format specifier %s indicates that the following value should be
		//displayed as String.
		System.out.println();
		
		System.out.print("What is your age? ");
		age = in.nextInt();
		in.nextLine(); //read the new line
		System.out.print("What is your name? ");
		name = in.nextLine();
		System.out.printf("Hello %s, age %d.\n", name, age);
		System.out.println();
		
		System.out.println("3.6 The printf method, the %f and %d format specifiers");
		System.out.print("An example of the \"%f\" format specifier: ");
		System.out.printf("%.1f centimeters = %.4f inches\n", cm, inch);
		//The inch variable I declared is of double type, so I use the %f format.
		//If inch is of int type, I should specify with %d. For example:
		System.out.println("Four examples of the \"%d\" format specifier: ");
		System.out.printf("%08d\n", 1234);
		System.out.printf("%08d\n", 123456789);
		//%08d display the integer padded with zeros, at least 8 digits wide.
		System.out.printf("%d\n", 5,6,7);
		System.out.printf("%d %d\n", 5,6,7);
		System.out.printf("%d %d %d\n", 5,6,7);
		System.out.println();  
		
		System.out.println("3.7 Type cast");
		inchInt = (int) inch;
		inchDouble = (double) inchInt;
		System.out.println("You are about " + inchInt + " inches. (inchInt)");
		System.out.println("You are about " + inchDouble + " inches. (inchDouble)");
		System.out.printf("You are about %.0f inches.", inch);
		System.out.println(" (%.0f)");
		//The (int) operator rounds toward 0.
		//The %.0f format specifier displays the closest integer.
		System.out.println();
		
		System.out.println("3.8 Modulus operator");
		quotient = inchInt / 12;
		remainderInt = inchInt % 12;
		remainderDouble = inch % 12;
		System.out.printf("The quotient of (%d / 12) is %d", inchInt, quotient);
		System.out.printf(",\nthe remaiderInt of (%d / 12) is %d,\n", inchInt, remainderInt);
		System.out.printf("and the remainderDouble of (%f /12 ) is %f.\n", inch, remainderDouble);
		System.out.printf("%f cm is about %d feet %.0f inches.\n", cm, quotient, remainderDouble);
		System.out.println(- 76 / 12);
		System.out.println(- 76 % 12);
		System.out.println(76 / - 12);
		System.out.println(76 % - 12);
		//When either dividend or divisor is negative, the naive definition breaks
		//down and programming languages differ in how these values are defined.
		//In Java, results of integer modulo operator % and floating-point modulo
		//operator % have the same sign as dividend.
		System.out.println(51.5 % 12.5);
		System.out.println();
	}
}