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

class BevShopTestStudent {

    private BevShop bevShop;

    @BeforeEach
    void setUp() {
        bevShop = new BevShop();
    }

    @Test
    void testIsValidTime() {
        assertTrue(bevShop.isValidTime(10));
        assertTrue(bevShop.isValidTime(23));
        assertFalse(bevShop.isValidTime(7));
        assertFalse(bevShop.isValidTime(24));
    }

    @Test
    void testGetMaxNumOfFruits() {
        assertEquals(BevShopInterface.MAX_FRUIT, bevShop.getMaxNumOfFruits());
    }

    @Test
    void testGetMinAgeForAlcohol() {
        assertEquals(BevShopInterface.MIN_AGE_FOR_ALCOHOL, bevShop.getMinAgeForAlcohol());
    }

    @Test
    void testIsMaxFruit() {
        assertTrue(bevShop.isMaxFruit(BevShopInterface.MAX_FRUIT + 1));
        assertFalse(bevShop.isMaxFruit(BevShopInterface.MAX_FRUIT));
    }

    @Test
    void testGetMaxOrderForAlcohol() {
        assertEquals(BevShopInterface.MAX_ORDER_FOR_ALCOHOL, bevShop.getMaxOrderForAlcohol());
    }

    @Test
    void testIsEligibleForMore() {
        // Mocking a scenario to test
        bevShop.startNewOrder(12, Day.MONDAY, "John Doe", 30);
        for (int i = 0; i < BevShopInterface.MAX_ORDER_FOR_ALCOHOL; i++) {
            bevShop.processAlcoholOrder("Wine", Size.SMALL);
        }
        assertFalse(bevShop.isEligibleForMore());
    }

    @Test
    void testIsValidAge() {
        assertTrue(bevShop.isValidAge(BevShopInterface.MIN_AGE_FOR_ALCOHOL));
        assertFalse(bevShop.isValidAge(BevShopInterface.MIN_AGE_FOR_ALCOHOL - 1));
    }

    @Test
    void testStartNewOrder() {
        bevShop.startNewOrder(12, Day.MONDAY, "Alice", 25);
        Order currentOrder = bevShop.getCurrentOrder();
        assertNotNull(currentOrder);
        assertEquals("Alice", currentOrder.getCustomer().getName());
        assertEquals(25, currentOrder.getCustomer().getAge());
    }

    @Test
    void testProcessCoffeeOrder() {
        bevShop.startNewOrder(12, Day.TUESDAY, "Bob", 28);
        bevShop.processCoffeeOrder("Espresso", Size.MEDIUM, true, false);
        Order currentOrder = bevShop.getCurrentOrder();
        assertEquals(1, currentOrder.getTotalItems());
    }

    @Test
    void testProcessAlcoholOrder() {
        bevShop.startNewOrder(15, Day.WEDNESDAY, "Chris", 30);
        bevShop.processAlcoholOrder("Beer", Size.LARGE);
        Order currentOrder = bevShop.getCurrentOrder();
        assertEquals(1, currentOrder.getTotalItems());
    }

    @Test
    void testProcessSmoothieOrder() {
        bevShop.startNewOrder(10, Day.THURSDAY, "Diana", 22);
        bevShop.processSmoothieOrder("Berry Blast", Size.SMALL, 3, true);
        Order currentOrder = bevShop.getCurrentOrder();
        assertEquals(1, currentOrder.getTotalItems());
    }

    @Test
    void testFindOrder() {
        bevShop.startNewOrder(14, Day.FRIDAY, "Evan", 40);
        int orderNo = bevShop.getCurrentOrder().getOrderNo();
        assertEquals(0, bevShop.findOrder(orderNo));
    }

    @Test
    void testTotalOrderPrice() {
        bevShop.startNewOrder(12, Day.SATURDAY, "Fiona", 27);
        bevShop.processCoffeeOrder("Latte", Size.LARGE, true, true);
        int orderNo = bevShop.getCurrentOrder().getOrderNo();
        assertTrue(bevShop.totalOrderPrice(orderNo) > 0);
    }

    @Test
    void testTotalMonthlySale() {
        bevShop.startNewOrder(12, Day.SUNDAY, "George", 35);
        bevShop.processAlcoholOrder("Whiskey", Size.SMALL);
        assertTrue(bevShop.totalMonthlySale() > 0);
    }

    @Test
    void testTotalNumOfMonthlyOrders() {
        bevShop.startNewOrder(10, Day.MONDAY, "Hannah", 29);
        bevShop.startNewOrder(11, Day.TUESDAY, "Ian", 25);
        assertEquals(2, bevShop.totalNumOfMonthlyOrders());
    }

    @Test
    void testSortOrders() {
        bevShop.startNewOrder(10, Day.MONDAY, "Jack", 30);
        bevShop.startNewOrder(11, Day.TUESDAY, "Kelly", 22);
        bevShop.startNewOrder(12, Day.WEDNESDAY, "Liam", 28);
        bevShop.sortOrders();
        assertTrue(bevShop.getOrderAtIndex(0).getOrderNo() < bevShop.getOrderAtIndex(1).getOrderNo());
    }
}
