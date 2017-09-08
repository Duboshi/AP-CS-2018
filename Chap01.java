/**
 * @author Dubos
 *
 */

public class Chap01{
	public static void main(String[] args) {
		
		//This is a comment.
		//Java program are made up of class and method definitions.
		//Methods are made of of statements.
		//This program defines one method named main and a class named Chapter01.
		
		System.out.println("1. Class, method, statement and comment"); 
		System.out.println("Hello, World!"); //This line is a print statement.
		System.out.println();
		
		System.out.println("2. \"print\" versus \"println\"");
		System.out.print("Hello, ");
		System.out.println("World!");
		System.out.println("This example also shows the escape sequence \" \\\" \"");
		System.out.println();
		
		System.out.println("3. The escape sequence \"\\n\"");
		//It is \n, \t, \" and \\. Not /
		System.out.println("(1) Hello,\nWorld!");
		System.out.println("(2) Hello,/nWorld!"); //This is wrong.
		System.out.println();
		
		System.out.println("4. The escape sequence: \"\\t\"");
		System.out.println("Hello,\tWorld!");
		System.out.println("Hello,\n\tWorld!");
		System.out.println("(1)Hello,\tWorld!");
		System.out.println("(2)Hello,\n\tWorld!");
		System.out.println();
		
		System.out.println("(5) He said: \"Hello, World!\"");
		System.out.println("(6) Hello, World!\\\\");
		System.out.println();
	}
}