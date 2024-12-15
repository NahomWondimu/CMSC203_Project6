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

public class BevShop implements BevShopInterface {
    private ArrayList<Order> orders;
    private Order currentOrder;

    public BevShop() {
        orders = new ArrayList<>();
    }

    
    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    
    public boolean isEligibleForMore() {
        return getNumOfAlcoholDrink() < MAX_ORDER_FOR_ALCOHOL;
    }

    
    public int getNumOfAlcoholDrink() {
        return currentOrder.findNumOfBeveType(Type.ALCOHOL);
    }

    
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        currentOrder = new Order(time, day, new Customer(customerName, customerAge));
        orders.add(currentOrder);
    }

    
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    
    public void processAlcoholOrder(String bevName, Size size) {
        if (isEligibleForMore()) {
            currentOrder.addNewBeverage(bevName, size);
        } else {
            throw new IllegalStateException("Maximum number of alcohol beverages reached for this order.");
        }
    }

    
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        if (isMaxFruit(numOfFruits)) {
            throw new IllegalArgumentException("Number of fruits exceeds the maximum allowed.");
        }
        currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo) {
                return i;
            }
        }
        return -1;
    }

    
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index == -1) {
            throw new IllegalArgumentException("Order not found.");
        }
        return orders.get(index).calcOrderTotal();
    }

    
    public double totalMonthlySale() {
        double total = 0;
        for (Order order : orders) {
            total += order.calcOrderTotal();
        }
        return total;
    }

    
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    
    public Order getCurrentOrder() {
        return currentOrder;
    }

    
    public Order getOrderAtIndex(int index) {
        if (index < 0 || index >= orders.size()) {
            throw new IndexOutOfBoundsException("Invalid index.");
        }
        return orders.get(index);
    }

    
    public void sortOrders() {
        for (int i = 0; i < orders.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < orders.size(); j++) {
                if (orders.get(j).getOrderNo() < orders.get(minIndex).getOrderNo()) {
                    minIndex = j;
                }
            }
            Order temp = orders.get(minIndex);
            orders.set(minIndex, orders.get(i));
            orders.set(i, temp);
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (Order order : orders) {
            result += order.toString() + "\n";
        }
        result += "Total Monthly Sale: " + totalMonthlySale();
        return result;
    }
}
