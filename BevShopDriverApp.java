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


import java.util.Calendar;
import java.util.Scanner;

public class BevShopDriverApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BevShop bevShop = new BevShop();

        System.out.println("Welcome to the Beverage Shop!");
        System.out.println("Note: The minimum age to order alcohol is " + bevShop.getMinAgeForAlcohol() + " years.");
        System.out.println("You can have at most " + bevShop.getMaxOrderForAlcohol() + " alcoholic drinks in an order.");

        Calendar calendar = Calendar.getInstance();
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        int calendarDay = calendar.get(Calendar.DAY_OF_WEEK);
        Day currentDay;
        switch (calendarDay) {
        case Calendar.MONDAY:
            currentDay = Day.MONDAY;
            break;
        case Calendar.TUESDAY:
        	currentDay = Day.TUESDAY;
        	break;
        case Calendar.WEDNESDAY:
        	currentDay = Day.WEDNESDAY;
        	break;
        case Calendar.THURSDAY:
        	currentDay = Day.THURSDAY;
        	break;
        case Calendar.FRIDAY:
        	currentDay = Day.FRIDAY;
        	break;
        case Calendar.SATURDAY:
        	currentDay = Day.SATURDAY;
        	break;
        case Calendar.SUNDAY:
        	currentDay = Day.SUNDAY;
        	break;
        default:
        	input.close();
            throw new IllegalArgumentException("Invalid day from Calendar API");
        }

        System.out.println("\nToday is " + currentDay + ", " + currentHour + ":00.");
        boolean shopOpen = true;
        while(shopOpen) {
        	
	        System.out.println("\nPlease enter your name:");
	        String customerName = input.nextLine();
	        System.out.println("Please enter your age:");
	        int customerAge = input.nextInt();
	        input.nextLine(); // clear the input line
	
	        // Start a new order
	        bevShop.startNewOrder(currentHour, currentDay, customerName, customerAge);
	        System.out.println("\nOrder started for " + customerName + ". Let’s begin your order!");
	
	        boolean ordering = true;
	
	        while (ordering) {
	            System.out.println("\nWhat would you like to add to your order?");
	            System.out.println("1. Alcoholic Drink");
	            System.out.println("2. Coffee");
	            System.out.println("3. Smoothie");
	            System.out.println("4. Finish Order");
	            int choice = input.nextInt();
	            input.nextLine();
	
	            switch (choice) {
	                case 1:
	                    if (customerAge < bevShop.getMinAgeForAlcohol()) {
	                        System.out.println("Sorry, you must be at least " + bevShop.getMinAgeForAlcohol() + " to order alcohol.");
	                    } else if (bevShop.isEligibleForMore()) {
	                        System.out.println("Enter the name of the alcoholic drink:");
	                        String alcoholName = input.nextLine();
	                        System.out.println("Choose a size (SMALL, MEDIUM, LARGE):");
	                        Size alcoholSize = Size.valueOf(input.nextLine().toUpperCase());
	                        bevShop.processAlcoholOrder(alcoholName, alcoholSize);
	                        System.out.println(alcoholName + " added to your order.");
	                    } else {
	                        System.out.println("You have reached the maximum number of alcoholic beverages for this order.");
	                    }
	                    break;
	
	                case 2:
	                    System.out.println("Enter the name of the coffee:");
	                    String coffeeName = input.nextLine();
	                    System.out.println("Choose a size (SMALL, MEDIUM, LARGE):");
	                    Size coffeeSize = Size.valueOf(input.nextLine().toUpperCase());
	                    System.out.println("Add extra shot (yes/no):");
	                    boolean extraShot = input.nextLine().equalsIgnoreCase("yes");
	                    System.out.println("Add extra syrup (yes/no):");
	                    boolean extraSyrup = input.nextLine().equalsIgnoreCase("yes");
	                    bevShop.processCoffeeOrder(coffeeName, coffeeSize, extraShot, extraSyrup);
	                    System.out.println(coffeeName + " added to your order.");
	                    break;
	
	                case 3:
	                    System.out.println("Enter the name of the smoothie:");
	                    String smoothieName = input.nextLine();
	                    System.out.println("Choose a size (SMALL, MEDIUM, LARGE):");
	                    Size smoothieSize = Size.valueOf(input.nextLine().toUpperCase());
	                    System.out.println("Enter the number of fruits:");
	                    int numOfFruits = input.nextInt();
	                    input.nextLine();
	                    System.out.println("Add protein powder (yes/no):");
	                    boolean addProtein = input.nextLine().equalsIgnoreCase("yes");
	                    bevShop.processSmoothieOrder(smoothieName, smoothieSize, numOfFruits, addProtein);
	                    System.out.println(smoothieName + " added to your order.");
	                    break;
	
	                case 4:
	                    ordering = false;
	                    break;
	
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	
	            if (ordering) {
	                System.out.println("\nCurrent total: $" + bevShop.getCurrentOrder().calcOrderTotal());
	                System.out.println("Total items in your order: " + bevShop.getCurrentOrder().getTotalItems());
	            }
	        }
        

	        System.out.println("\nFinalizing your order...");
	        System.out.println("Total items: " + bevShop.getCurrentOrder().getTotalItems());
	        System.out.println("Total price: $" + bevShop.getCurrentOrder().calcOrderTotal());
	        
	        System.out.println("Start new Order? (yes/no)");
	        String shoppingNotDone = input.nextLine();
	        if(!shoppingNotDone.equals("yes")) {
	        	shopOpen = false;
	        }
        }
        System.out.println("Thank you for visiting the Beverage Shop!");
        input.close();
    }
}
