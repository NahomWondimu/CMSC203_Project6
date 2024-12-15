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


public class Smoothie extends Beverage {
	private int numOfFruits;
	private boolean addProtein;
	public final double FRUIT_COST = 0.5;
	public final double PROTEIN_COST = 1.5;
	
	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
		super(bevName, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
	}
	
	// Accesses
	public int getNumOfFruits() {
		return numOfFruits;
	}
	
	public boolean getAddProtein() {
		return addProtein;
	}
	
	@Override
	public double calcPrice() {
		double price = 0;
		price += super.addSizePrice();
		price += FRUIT_COST * numOfFruits;
		if(addProtein) {
			return price + PROTEIN_COST;
		}else {
			return price;
		}
	}
	
	@Override
	public boolean equals(Beverage anotherBev) {
		if(!(anotherBev instanceof Smoothie)) {
			return false;
		}
		
		if(!super.equals(anotherBev)) {
			return false;
		}
		
		Smoothie smForCheck = (Smoothie) anotherBev;
		if(this.getNumOfFruits() == smForCheck.getNumOfFruits() && (this.getAddProtein() == smForCheck.getAddProtein())) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		String result = super.toString();
		String withProtein = addProtein ? "with protein" : "without protein";
		return result + ", " + numOfFruits + ", " + withProtein;
	}
	
	
}
