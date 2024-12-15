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


import java.util.ArrayList;

public class Order implements OrderInterface, Comparable<Order> {
	private int orderTime;
	private int orderNo; // Not passed
	private Day orderDay;
	private Customer customer;
	private ArrayList<Beverage> beverage;

	public Order(int orderT, Day orderD, Customer cust) {
		this.orderTime = orderT;
		this.orderDay = orderD;
		this.customer = cust;
		generateOrder();
		this.beverage = new ArrayList<Beverage>();
	}

	public void addNewBeverage(String bevName, Size size) {
		if(isWeekend()) {
			beverage.add(new Alcohol(bevName, size, true));
			return;
		}
		
		beverage.add(new Alcohol(bevName, size, false));
	}

	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		beverage.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}

	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		beverage.add(new Smoothie(bevName, size, numOfFruits, addProtein));
	}

	public double calcOrderTotal() {
		double totalPrice = 0;
		for(int i = 0; i < beverage.size(); i++) {
			totalPrice += beverage.get(i).calcPrice();
		}
		return totalPrice;
	}
	
	@Override
    public int compareTo(Order anotherOrder) {
        return Integer.compare(this.orderNo, anotherOrder.getOrderNo());
    }
	
	public int findNumOfBeveType(Type type) {
		int counter = 0;
		for(int i = 0; i < beverage.size(); i++) {
			if(beverage.get(i).getType() == type) {
				counter++;
			}
		}
		return counter;
	}
	
	public int generateOrder() {
		int orderNum = (int) (Math.random() * 8001) + 1000;
		this.orderNo = orderNum;
		return orderNum;
	}
	
	public Beverage getBeverage(int itemNo) {
		return beverage.get(itemNo);
	}
	
	public Customer getCustomer() {
		return this.customer;
	}
	
	public Day getOrderDay() {
		return orderDay;
	}
	
	public Day getDay() {
		return orderDay;
	}
	
	public int getOrderNo() {
		return orderNo;
	}
	
	public int getOrderTime() {
		return orderTime;
	}
	
	public int getTotalItems() {
		return beverage.size();
	}
	
	//Methods
	public boolean isWeekend() {
		if(orderDay == Day.SATURDAY || orderDay == Day.SUNDAY) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public String toString() {
	    String result = "";
	    result += "Order Number: " + orderNo + "\n";
	    result += "Order Time: " + orderTime + "\n";
	    result += "Order Day: " + orderDay + "\n";
	    result += "Customer: " + customer.getName() + ", Age: " + customer.getAge() + "\n";
	    result += "Beverages:\n";
	    for (Beverage bev : beverage) {
	        result += bev.toString() + "\n";
	    }
	    result += "Total: " + calcOrderTotal();
	    return result;
	}

}
