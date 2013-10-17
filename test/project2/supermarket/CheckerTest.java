/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project2.supermarket;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jason Travis
 */
public class CheckerTest {

    Checker instance;

    public CheckerTest() {
    }

    @Before
    public void setUp() {
        instance = new Checker(3);
    }

    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of elapseTime method, of class Checker.
     */
    @Test
    public void testElapseTime() {
        System.out.println("elapseTime");
        instance.elapseTime(42);
        assertEquals("It should do nothing when the queue is empty", 0, instance.getTotalItems());
        for (int i = 5; i <= 15; i+=5) {
            instance.enqueue(new MockCustomer(i));
        }
        instance.elapseTime(2);
        assertEquals("It should be able to partially process a customer", 28, instance.getTotalItems());
        assertTrue("It should not remove a customer until their cart is empty", instance.isFull());
        instance.elapseTime(8);
        assertEquals("It should be able to process multiple customers", 20, instance.getTotalItems());
        instance.elapseTime(21);
        assertEquals("It should stop when ", 0, instance.getTotalItems());
        assertTrue("The queue should be empty", instance.isEmpty());
    }

    /**
     * Test of enqueue method, of class Checker.
     */
    @Test
    public void testEnter() {
        System.out.println("enter");
        for (int i = 5; i <= 15; i+=5) {
            instance.enqueue(new MockCustomer(i));
        }
        assertEquals("It should set the totalItems to the sum of the items of each customer in line", 30, instance.getTotalItems());
    }

    /**
     * Test of dequeue method, of class Checker.
     */
    @Test
    public void testExit() {
        System.out.println("exit");
        for (int i = 5; i <= 15; i+=5) {
            instance.enqueue(new MockCustomer(i));
        }
        instance.dequeue();
        assertEquals("It should set the totalItems to the sum of the items of the remaining customers", 25, instance.getTotalItems());

    }

    /**
     * Test of totalItems method, of class Checker.
     */
    @Test
    public void testTotalItems() {
        System.out.println("totalItems");
        assertEquals("It should return 0 when the queue is empty", 0, instance.getTotalItems());
    }
}