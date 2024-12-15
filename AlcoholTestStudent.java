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

public class AlcoholTestStudent {

    @Test
    public void testCalcPrice_Weekend() {
        Alcohol alc = new Alcohol("Whiskey", Size.MEDIUM, true);
        double expectedPrice = 2.0 + 0.6 + 0.5;
        assertEquals(expectedPrice, alc.calcPrice(), 0.001);
    }

    @Test
    public void testCalcPrice_NotWeekend() {
        Alcohol alc = new Alcohol("Vodka", Size.LARGE, false);
        double expectedPrice = 3.0;
        assertEquals(expectedPrice, alc.calcPrice(), 0.001);
    }

    @Test
    public void testIsWeekend() {
        Alcohol alc = new Alcohol("Wine", Size.SMALL, true);
        assertTrue(alc.isWeekend());

        Alcohol alc2 = new Alcohol("Beer", Size.MEDIUM, false);
        assertFalse(alc2.isWeekend());
    }

    @Test
    public void testEquals_SameAttributes() {
        Alcohol alc1 = new Alcohol("Rum", Size.LARGE, true);
        Alcohol alc2 = new Alcohol("Rum", Size.LARGE, true);
        assertTrue(alc1.equals(alc2));
    }

    @Test
    public void testEquals_DifferentAttributes() {
        Alcohol alc1 = new Alcohol("Gin", Size.SMALL, true);
        Alcohol alc2 = new Alcohol("Gin", Size.SMALL, false);
        assertFalse(alc1.equals(alc2));
    }

    @Test
    public void testToString() {
        Alcohol alc = new Alcohol("Tequila", Size.MEDIUM, true);
        String expectedString = "Tequila, ALCOHOL, MEDIUM, is weekend";
        assertEquals(expectedString, alc.toString());
    }
}
