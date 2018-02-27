/**
 * Chap04 Void method
 *
 */

public class Chap04 {

	public static void main(String[] args) {
		double root, angle, degrees, height, x, y;
		String s, t, day, month;
		int year, date, hour, minute;
		
		System.out.println("4.1 Math methods");
		root = Math.sqrt(25.0);
		System.out.println("The square root of 25 is: " + root);
		newLine();
		
		angle = 0.5 * Math.PI;
		height = Math.sin(angle);
		degrees = Math.toDegrees(angle);
		System.out.println("Sine of 0.5 pi ridians is: " + height);
		System.out.println("0.5 pi radians is equal to " + degrees + " degrees");
		newLine();
		
		degrees = 270.0;
		angle = Math.toRadians(degrees);
		height = Math.sin(angle);
		System.out.println("Sine of 270 degrees is: " + height);
		System.out.print("270 degrees is equal to " + angle / Math.PI);
		System.out.println(" pi radians");
		newLine();
		
		y = Math.pow(2.0, 10.0);
		System.out.println("y = 2 ^ 10 = " + y);
		System.out.println(Math.exp(10));
		System.out.println(Math.log(Math.exp(10)));
		System.out.println(Math.round(1.888));
		newLine();
		
		System.out.println("4.2 Euler's number, composition");
		System.out.println("The Euler's number, e, is: " + Math.E);
		System.out.println("y = e ^ x");
		System.out.println("y is the xth power of base e. Or:");
		System.out.print("x is the exponent to the base e such that the ");
		System.out.println("power is y.");
		y = Math.exp(2);
		System.out.println("The second power of e is y = e ^ 2 = " + y);
		newLine();
		
		System.out.println("x = ln y");
		x = Math.log(y);
		System.out.println("x is the logarithm to the base e of the power y. Or");
		System.out.println("x is the natural logarithm of y");
		System.out.println("x = ln 7.38905609893065 = " + x);
		System.out.println(Math.log(Math.exp(2)));
		newLine();
		
		System.out.println("4.5 & 4.6 Parameters and arguments.");
		s = "Print this line twice.";
		t = "We are OIers.";
		printTwice(s);
		printTwice(t);
		hour = 14;
		minute = 18;
		year = 2012;
		date = 30;
		printTime(hour, minute);
		printTime(year, date);
		printTime(11, 19);
		//Flow of execution: Execution always begins at first statement of main, 
		//regardless of where it is in the source code.
		//When you write a method, you name the parameters.
		//When you use(invoke) a method, you provide the arguments.
		
		//For example, printTwice has a parameter named s with type String.
		//When we invoke printTwice, we have to provide an argument with type
		//String. This process is called parameter passing.
		//Parameters and other variables only exist inside their own methods, so 
		//they are often call local parameters.
		
		//The hour and minute here in method main are local variables. They are
		//NOT the same as those in method printTime, although they have the same
		//names. hour in printTime and hour in main refer to different storage
		//locations, and THEY CAN HAVE DIFFERENT VALUES.
		newLine();
		
		System.out.println("Exercise 4.2");
		zool(906, "Charles", "Dubos");
		newLine();
		
		System.out.println("Exercise 4.3");
		day = "Monday";
		month = "August";
		date = 21;
		year = 2017;
		printAmerican(day, month, date, year);
		printEuropean(day, month, date, year);
		newLine();
	}

	public static void newLine() {
		System.out.println();
	}
	
	public static void printTwice(String s) {
		System.out.println(s);
		System.out.println(s);
	}

	public static void printTime(int hour, int minute) {
		System.out.print(hour);
		System.out.print(":");
		System.out.println(minute);
	}
	
	public static void zool(int ID, String firstName, String lastName) {
		System.out.print("Hello, my name is " + firstName + " " + lastName);
		System.out.println(". My ID is " + ID + ".");
	}
	
	public static void printAmerican(String day, String month, int date, int year) {
		System.out.println("American format:");
		System.out.println(day + "," + month + " " + date + "," + year);
	}
	
	public static void printEuropean(String day, String month, int date, int year) {
		System.out.println("European format:");
		System.out.println(day + "," + date + " " + month + "," + year);
	}
} 