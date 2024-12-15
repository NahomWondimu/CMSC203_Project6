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


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTestStudent {

    @Test
    void testConstructorWithNameAndAge() {
        Customer customer = new Customer("Alice", 25);
        assertEquals("Alice", customer.getName());
        assertEquals(25, customer.getAge());
    }

    @Test
    void testCopyConstructor() {
        Customer original = new Customer("Bob", 30);
        Customer copy = new Customer(original);
        assertEquals("Bob", copy.getName());
        assertEquals(30, copy.getAge());
        copy.setName("Charlie");
        copy.setAge(35);
        assertNotEquals(original.getName(), copy.getName());
        assertNotEquals(original.getAge(), copy.getAge());
    }

    @Test
    void testSetName() {
        Customer customer = new Customer("Dave", 40);
        customer.setName("Eve");
        assertEquals("Eve", customer.getName());
    }

    @Test
    void testSetAge() {
        Customer customer = new Customer("Frank", 45);
        customer.setAge(50);
        assertEquals(50, customer.getAge());
    }

    @Test
    void testToString() {
        Customer customer = new Customer("Grace", 28);
        assertEquals("Grace, 28", customer.toString());
    }
}
