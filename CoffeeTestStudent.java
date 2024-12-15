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


import static org.junit.Assert.*;

import org.junit.Test;

public class CoffeeTestStudent {

    @Test
    public void testCalcPrice_ExtraShotAndSyrup() {
        Coffee coffee = new Coffee("Latte", Size.LARGE, true, true);
        double expectedPrice = 3.0 + 0.5 + 0.5;
        assertEquals(expectedPrice, coffee.calcPrice(), 0.001);
    }

    @Test
    public void testCalcPrice_NoExtras() {
        Coffee coffee = new Coffee("Americano", Size.SMALL, false, false);
        double expectedPrice = 2.0;
        assertEquals(expectedPrice, coffee.calcPrice(), 0.001);
    }

    @Test
    public void testGetExtraShot() {
        Coffee coffee = new Coffee("Espresso", Size.SMALL, true, false);
        assertTrue(coffee.getExtraShot());

        Coffee coffee2 = new Coffee("Cappuccino", Size.SMALL, false, true);
        assertFalse(coffee2.getExtraShot());
    }

    @Test
    public void testGetExtraSyrup() {
        Coffee coffee = new Coffee("Mocha", Size.MEDIUM, false, true);
        assertTrue(coffee.getExtraSyrup());

        Coffee coffee2 = new Coffee("Black Coffee", Size.LARGE, true, false);
        assertFalse(coffee2.getExtraSyrup());
    }

    @Test
    public void testEquals_SameAttributes() {
        Coffee coffee1 = new Coffee("Flat White", Size.MEDIUM, true, true);
        Coffee coffee2 = new Coffee("Flat White", Size.MEDIUM, true, true);
        assertTrue(coffee1.equals(coffee2));
    }

    @Test
    public void testEquals_DifferentAttributes() {
        Coffee coffee1 = new Coffee("Macchiato", Size.SMALL, true, false);
        Coffee coffee2 = new Coffee("Macchiato", Size.SMALL, false, false);
        assertFalse(coffee1.equals(coffee2));
    }

    @Test
    public void testToString() {
        Coffee coffee = new Coffee("Iced Coffee", Size.LARGE, true, true);
        String expectedString = "Iced Coffee, COFFEE, LARGE, with extra shot, with extra syrup";
        assertEquals(expectedString, coffee.toString());
    }
}
