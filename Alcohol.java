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



public class Alcohol extends Beverage {
	private boolean isWeekend;
	private final double WEEKEND_COST = 0.6;
	
	public Alcohol(String bevName, Size size, boolean isWeekend) {
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}
	
	// Accesses
	public boolean isWeekend() {
		return isWeekend;
	}

	@Override
	public double calcPrice() {
		double price = 0;
		price += super.addSizePrice();
		if(isWeekend) {
			return price + WEEKEND_COST;
		}else {
			return price;
		}
	}
	
	@Override
	public boolean equals(Beverage anotherBev) {
		if (!(anotherBev instanceof Alcohol)) {
	        return false;
	    }
		
		Alcohol alcForCheck = (Alcohol) anotherBev;
		
		if(super.equals(anotherBev) && (this.isWeekend() == alcForCheck.isWeekend())) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		String result = super.toString();
		String weekendString = isWeekend ? "is weekend" : "is not weekend";
		return result + ", " + weekendString;
	}
	
}
