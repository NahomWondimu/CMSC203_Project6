/*
 * Class: CMSC203-22502 
 * Instructor: Professor Kuijt
 * Description: (Give a brief description for each Class)
 * Due: 12/15/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Nahom Wondimu
*/

public abstract class Beverage {
	private String bevName;
	private Type type;
	private Size size;
	private final double BASE_PRICE = 2;
	private final double SIZE_PRICE = 0.5;
	
	// Constructor
	public Beverage(String bevName, Type type, Size size) {
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}
	
	// Accesses
	public String getBevName() {
		return bevName;
	}
	
	public Type getType() {
		return type;
	}
	
	public Size getSize() {
		return size;
	}
	
	// Methods
	public double addSizePrice() {
		if(size == Size.SMALL) {
			return BASE_PRICE;
		}else if(size == Size.MEDIUM) {
			return BASE_PRICE + SIZE_PRICE;
		}else {
			return BASE_PRICE + (2*SIZE_PRICE);
		}
	}
	
	public abstract double calcPrice();
	
	public boolean equals(Beverage anotherBev) {
		if(this.getBevName().equals(anotherBev.getBevName()) && this.getType() == anotherBev.getType() && this.getSize() == anotherBev.getSize()) {
			return true;
		} else {
			return false;
		}
	}
	
	
	@Override
	public String toString() {
		return bevName + ", " + type + ", " + size;
	}
	
}
