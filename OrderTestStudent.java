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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderTestStudent {

    private Customer customer;
    private Order order;

    @BeforeEach
    void setUp() {
        customer = new Customer("Alice", 25);
        order = new Order(10, Day.MONDAY, customer);
    }

    @Test
    void testConstructor() {
        assertEquals(10, order.getOrderTime());
        assertEquals(Day.MONDAY, order.getOrderDay());
        assertEquals(customer, order.getCustomer());
        assertNotNull(order.getOrderNo());
    }

    @Test
    void testAddNewBeverage_Alcohol() {
        order.addNewBeverage("Wine", Size.SMALL);
        assertEquals(1, order.getTotalItems());
        Beverage bev = order.getBeverage(0);
        assertEquals("Wine", bev.getBevName());
        assertEquals(Size.SMALL, bev.getSize());
        assertEquals(Type.ALCOHOL, bev.getType());
    }

    @Test
    void testAddNewBeverage_Coffee() {
        order.addNewBeverage("Latte", Size.MEDIUM, true, false);
        assertEquals(1, order.getTotalItems());
        Beverage bev = order.getBeverage(0);
        assertEquals("Latte", bev.getBevName());
        assertEquals(Size.MEDIUM, bev.getSize());
        assertEquals(Type.COFFEE, bev.getType());
    }

    @Test
    void testAddNewBeverage_Smoothie() {
        order.addNewBeverage("Berry Blast", Size.LARGE, 3, true);
        assertEquals(1, order.getTotalItems());
        Beverage bev = order.getBeverage(0);
        assertEquals("Berry Blast", bev.getBevName());
        assertEquals(Size.LARGE, bev.getSize());
        assertEquals(Type.SMOOTHIE, bev.getType());
    }

    @Test
    void testCalcOrderTotal() {
        order.addNewBeverage("Latte", Size.MEDIUM, true, false);
        order.addNewBeverage("Wine", Size.SMALL);
        order.addNewBeverage("Berry Blast", Size.LARGE, 2, false);
        assertTrue(order.calcOrderTotal() > 0);
    }

    @Test
    void testFindNumOfBeveType() {
        order.addNewBeverage("Latte", Size.MEDIUM, true, false);
        order.addNewBeverage("Espresso", Size.SMALL, false, false);
        order.addNewBeverage("Wine", Size.SMALL);
        order.addNewBeverage("Berry Blast", Size.LARGE, 2, true);
        assertEquals(2, order.findNumOfBeveType(Type.COFFEE));
        assertEquals(1, order.findNumOfBeveType(Type.ALCOHOL));
        assertEquals(1, order.findNumOfBeveType(Type.SMOOTHIE));
    }

    @Test
    void testIsWeekend() {
        Order weekendOrder = new Order(15, Day.SATURDAY, customer);
        assertTrue(weekendOrder.isWeekend());
        assertFalse(order.isWeekend());
    }

    @Test
    void testCompareTo() {
        Order anotherOrder = new Order(12, Day.TUESDAY, customer);
        int comparison = order.compareTo(anotherOrder);
        assertTrue(comparison != 0);
    }

    @Test
    void testToString() {
        order.addNewBeverage("Latte", Size.MEDIUM, true, false);
        String orderDetails = order.toString();
        assertTrue(orderDetails.contains("Order Number"));
        assertTrue(orderDetails.contains("Latte"));
        assertTrue(orderDetails.contains("Total:"));
    }
}
