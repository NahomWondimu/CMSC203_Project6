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

public class SmoothieTestStudent {

    @Test
    public void testCalcPrice_WithProteinAndFruits() {
        Smoothie smoothie = new Smoothie("Berry Blast", Size.LARGE, 3, true);
        double expectedPrice = 3.0 + (3 * 0.5) + 1.5;
        assertEquals(expectedPrice, smoothie.calcPrice(), 0.001);
    }

    @Test
    public void testCalcPrice_NoExtras() {
        Smoothie smoothie = new Smoothie("Tropical", Size.SMALL, 0, false);
        double expectedPrice = 2.0;
        assertEquals(expectedPrice, smoothie.calcPrice(), 0.001);
    }

    @Test
    public void testGetNumOfFruits() {
        Smoothie smoothie = new Smoothie("Green Machine", Size.MEDIUM, 2, false);
        assertEquals(2, smoothie.getNumOfFruits());

        Smoothie smoothie2 = new Smoothie("Citrus Burst", Size.LARGE, 0, true);
        assertEquals(0, smoothie2.getNumOfFruits());
    }

    @Test
    public void testGetAddProtein() {
        Smoothie smoothie = new Smoothie("Protein Punch", Size.LARGE, 1, true);
        assertTrue(smoothie.getAddProtein());

        Smoothie smoothie2 = new Smoothie("Fruit Delight", Size.SMALL, 3, false);
        assertFalse(smoothie2.getAddProtein());
    }

    @Test
    public void testEquals_SameAttributes() {
        Smoothie smoothie1 = new Smoothie("Mango Mania", Size.MEDIUM, 2, true);
        Smoothie smoothie2 = new Smoothie("Mango Mania", Size.MEDIUM, 2, true);
        assertTrue(smoothie1.equals(smoothie2));
    }

    @Test
    public void testEquals_DifferentAttributes() {
        Smoothie smoothie1 = new Smoothie("Peach Paradise", Size.SMALL, 1, false);
        Smoothie smoothie2 = new Smoothie("Peach Paradise", Size.SMALL, 2, false);
        assertFalse(smoothie1.equals(smoothie2));
    }

    @Test
    public void testToString() {
        Smoothie smoothie = new Smoothie("Tropical Twist", Size.MEDIUM, 2, true);
        String expectedString = "Tropical Twist, SMOOTHIE, MEDIUM, 2, with protein";
        assertEquals(expectedString, smoothie.toString());
    }
}
