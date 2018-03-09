/*
 * with Chap11.java
 * @author Dubos
 */

//One common reason to define a class is to encapsulate related data in 
//an object that can be treated as a single unit. (Data encapsulation)

public class Time {
//The Time class is public which means it can be used in other classes.

//Attributes are also called instance variables. What instance variables do we need?
	
	private int hour;
	private int minute;
	private double second;
	//The instance variables are private, which means they can only be accessed
	//from inside the Time class.
	//Private instance variables help keep classes isolated from each other so that
	//changes in one class will not require changes in other classes.
	//(information hiding).
	
	//After declaring the instance variables, the next step is to define a 
	//constructor, which is a special method that initializes the instance variables.
	public Time() {
	//The name of the constructor is the same as the name of the class.
	//Constructors have no return type or return value.
		this.hour = 0;
		this.minute = 0;
		this.second = 0;
		//This constructor does not take any arguments.
		
		//The name this is a keyword that refers to the object we are creating.
		//Each line initializes an instance variable to 0.
		
		//This constructor make it possible to create a Time object with default
		//attributes.
		
		//Now create a Time object, time1, in Chap11.java.
	}
	
	//Now create a value constructor.	
	public Time(int hour, int minute, double second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		
		if (this.second >= 60) {
			this.second -= 60;
			this.minute += 1;
		}
		if (this.minute >= 60) {
			this.minute -= 60;
			this.hour += 1;
		}
		if (this.hour >= 24) {
			this.hour -= 24;
		}
	}
	//To invoke this value constructor, we have to provide arguments after the new
	//operator.
	
	//The proceeding constructors are overloading. Overloading constructors provide
	//the flexibility to create an object first and then fill in the attributes.
	//Now create a Time object, time2, in Chap11.java with
	//hour = 24, minute = 59 and second = 60
	
	//Create an instance method printTime()
	public void printTime() {
		System.out.printf("%02d:%02d:%04.1f\n", this.hour, this.minute, this.second);
	}
	//An in stance method is not static. We have to invoke it on an instance of the 
	//class.
	
	//Create getters and setters.
	public int getHour() {
		return this.hour;
	}
	
	public int getMinute() {
		return this.minute;
	}

	public double getSecond() {
		return this.second;
	}
	//These methods are instance methods.
	
	public void setHour(int hour) {
		this.hour = hour;
	}
	
	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	public void setSecond(double second) {
		this.second = second;
	}
	//Recall that Strings are immutable. To make a class immutable we should not
	//provide setters.
	
	public String toString() {
		return String.format("%02d:%02d:%04.1f", 
				this.hour, this.minute, this.second);
	}
	
	public boolean equals(Time that) {
		return this.hour == that.hour 
				&& this.minute == that.minute 
				&& this.second == that.second;
	}
	
	public static Time add(Time t1, Time t2) {
		return new Time(t1.hour + t2.hour, t1.minute + t2.minute, 
				t1.second + t2.second);
	}
	
	public Time add(Time t) {
		return new Time(this.hour + t.hour,  this.minute + t.minute, 
				this.second + t.second);	
	}
	
	public Time modifier(Time t1) {
		this.second += t1.second;
		this.minute += t1.minute;
		this.hour += t1.hour;
		
		if (this.second >= 60) {
			this.second -= 60;
			this.minute += 1;
		}
		if (this.minute >= 60) {
			this.minute -= 60;
			this.hour += 1;
		}
		if (this.hour >= 24) {
			this.hour -= 24;
		}
		
		return this;
	}
}



