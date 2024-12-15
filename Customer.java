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


public class Customer {
	private String name;
	private int age;
	
	Customer(String n, int a) {
		this.name = n;
		this.age = a;
		
	}
	
	Customer(Customer otherCust) {
		this.name = otherCust.getName();
		this.age = otherCust.getAge();
	}
	
	// Accesses
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String x) {
		this.name = x;
	}
	
	public void setAge(int x) {
		this.age = x;
	}
	
	// String Output
	@Override
	public String toString() {
		return name + ", " + age;
	}
}
