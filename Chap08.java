/* 
 * Chap08 Arrays
 */

import java.util.*;
//We import java.util.Scanner, java.util.Arrays and java.util.Random
//A wildcard is a symbol used to replace or represent one or more characters.
import java.io.*;
//We import java.io.PrintStream

public class Chap08 {
	
	private static Scanner in;

	public static void main(String[] args) {
		PrintStream out = System.out;
		in = new Scanner(System.in);
		
		out.println("8.1 Creating arrays");
		//An array is a sequence of values. The values in the array are call
		//elements. All the values in an array must have the same type.
		
		int[] a; //Declaration of a variable with an int array type.
		a = new int[4]; //Assignment. Creation of the array of four integer elements.
		//int[] counts = new int[4];
		//The size of an array can be any non negative integer.
		out.println();
		
		out.println("8.2 Accessing elements");
		//Values of counts is a reference to the array.
		//An array is not the same things the variable referring to it.
		//We can assign different variables to refer to the same array, and we
		//can change the value of a variable to refer to a different array.
		
		//The indexes of an array of n elements are: 0, 1, 2, ... n - 1.
		
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;
		
		int[] b = {5, 6, 7, 8};
		//Array constants can only be used in initializers.
		out.println();
		
		out.println("8.3 & 8.5 Displaying arrays, array length");
		out.println("println(a) = " + a);
		out.println("println(b) = " + b);
		//The bracket indicates that the value is an array. "I" stands for 
		//"integer", and the rest represents the address of the array.
		printArray(a);
		printArray(b);
		out.println(Arrays.toString(a));
		out.println(Arrays.toString(b));
		out.println();
		
		out.println("8.4 Copying arrays");
		int[] c = a;
		printArray(c);
		a[0] = 2;
		printArray(c);
		//a and c are different variables referring to the same array.
		//They are called aliases. As we change the value of a, c changes with it.
		out.println();
		
		int[] d = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			d[i] = a[i];
		}
		a[0] = 3;
		printArray(a);
		printArray(d);
		//We actually copy the array that a referring to. So d does not change with a.
		out.println();
		
		int[] e = Arrays.copyOf(a, 4);
		a[0] = 4;
		printArray(a);
		printArray(e);
		//We actually copy the array that a referring to. So e does not change with a.
		out.println();
		
		int[] f = Arrays.copyOfRange(a, 2, 4);
		//Copy the range that 2< = index of a < 4
		printArray(f);
		out.println();
		
		out.println("8.6 Array traversal and search");
		//Looping through the elements of an array is called a traversal.
		a[0] = 1;
		printArray(a);
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) Math.pow(a[i], 2);
		}
		printArray(a);
		out.println();
		
		//Search involves traversing an array looking for a particular 
		//element. The following example displays the index where the 
		//target value first appears.
		a[0] = 0;
		a[1] = 0;
		a[2] = 0;
		a[3] = 0;
		out.print("Array a = ");
		printArray(a);
		out.print("Search for the integer n you type in array a. n = ");
		int n = in.nextInt();
		if (search(a, n) >= 0) {
			out.printf("%d first appears at index = %d.\n", n, search(a, n));
		} else {
			out.printf("%d does not appear in array a.\n", n);
		}
		out.println();
		
		//A reduce operation reduces an array of values down to a single
		//value. The following example displays the sum of elements of 
		//array a.
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;
		out.print("Array a = ");
		printArray(a);
		out.printf("The sum of elements of array a is %d.\n", sum(a));
		out.println();
		
		//Write a method min(a) to return the minimum value of elements
		//of array a.
		out.print("Array a = ");
		printArray(a);
		out.printf("The minimum value of elements of array a is %d.\n", 
				min(a));
		out.println();
		
		out.println("8.7 Random numbers");
		int[] integers = ranArray(100);
		out.println("We have generated an array of which the 100 elements are"
				+ " random integers between 1 and 100. The array is: ");
		printArray(integers);
		out.println();
		
		out.println("8.8 Traverse and count");
		out.print("We want to count how many times a certain integer n appears in "
				+ "the array. n = ");
		n = in.nextInt();
		out.printf("%d appeares %d times in the array.\n", n, count(integers, n));
		out.println();
		
		//Write a method, interval(int[]a, int low, int high),
		//counting how many elements in the array fall in the interval (low, high].
		out.println("We want to count how many elements in the array fall in the "
				+ "inteval (low, high].");
		out.print("low = ");
		int low = in.nextInt();
		out.print("high = ");
		int high = in.nextInt();
		out.printf("%d elements fall in the interval (%d, %d].\n",
				interval(integers, low, high), low, high);
		out.println();
		
		//Create an array int[] frequencies = new int[10], of which the 10 elements
		//counting how many random integers fall in the interval (0, 10], (10, 20]
		//...(90, 100] respectively. Display array frequency.
		
		int[] frequencies = new int[10];
		
//		for (int i = 0; i < frequencies.length; i++) {
//			frequencies[i] = interval(integers, 10 * i, 10 * i + 10);
//		}
//		printArray(frequencies);
//		out.println();
//		//Every time the loop invokes interval(array, low, high), it traverses the
//		//entire array. Try to traverss the array only once:
//		
//		for (int iIntg = 0; iIntg < integers.length; iIntg++) {
//			int iFreq = (integers[iIntg] - 1) / 10;					
//			frequencies[iFreq]++;
//		}
//		printArray(frequencies);
//		out.println();
		
		out.println("8.10 The enhanced for loop");
		//It is conventional to use plural nouns for array variables and 
		//singular nouns for element variables.
		for (int integer : integers) {
			int iFreq = (integer - 1) / 10;
			frequencies[iFreq]++;
		}	
		printArray(frequencies);
		out.println();

	}
	
	public static void printArray(int[] a) {
		System.out.print("{" + a[0]);
		for (int i = 1; i < a.length; i++) {
			System.out.print(", " + a[i]);
		}
		System.out.println("}");
	}
	
	public static int search(int[] a, int n) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == n) {
				return i;
			}
		}
		return -1;
	}

	public static int sum(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}

	public static int min(int[] a) {
		int min = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] < a[i - 1]) {
				min = a[i];
			}
		}
		return min;
	}
	
	public static int[] ranArray(int n) {
		Random ran = new Random();
		int[] ranArray = new int[100];
		for (int i = 0; i < 100; i++) {
			ranArray[i] = ran.nextInt(100) + 1;
			//The method nextInt takes an integer argument n, and returns a random
			//integer between 0 and n - 1 (inclusive), that is [0, n - 1]
		}
		return ranArray;
	}

	public static int count(int[]a, int n) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == n) {
				count++;
			}
		}
		return count;
	}
	
	public static int interval(int[]a, int low, int high) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (low < a[i] && a[i] <= high) {
				count++;
			}
		}
		return count;
	}

}
