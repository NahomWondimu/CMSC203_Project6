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


public class Coffee extends Beverage{
	private final double EXTRA_SHOT_COST = 0.5;
	private final double EXTRA_SYRUP_COST = 0.5;
	private boolean extraSyrup;
	private boolean extraShot;
	
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	
	// Accesses
	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	
	public boolean getExtraShot() {
		return extraShot;
	}
	
	// Methods
	@Override
	public double calcPrice() {
		double price = super.addSizePrice();
		if(extraShot) {
			price += EXTRA_SHOT_COST;
		}
		if(extraSyrup) {
			price += EXTRA_SYRUP_COST;
		}
		return price;
	}
	
	@Override
	public boolean equals(Beverage anotherBev) {
		if(!(anotherBev instanceof Coffee)) {
			return false;
		}
		
		if(!super.equals(anotherBev)) {
			return false;
		}
		
		Coffee coffeeObj = (Coffee) anotherBev;
		if(this.getExtraShot() == coffeeObj.getExtraShot() && (this.getExtraSyrup() == coffeeObj.getExtraSyrup())) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		String result = super.toString();
		String withExtraShot = extraShot ? "with extra shot" : "without extra shot";
		String withExtraSyrup = extraSyrup ? "with extra syrup" : "without extra syrup";
		return result + ", " + withExtraShot + ", " + withExtraSyrup;
	}
}
