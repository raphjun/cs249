/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jason Travis
 */
public class QueueTest {
    
    public QueueTest() {
    }
    
    /**
     * Test of toString method, of class Queue.
     */
    @Test
    public void testToStringEmpty() {
        System.out.println("toString");
        System.out.println("It should print an empty string if the queue is empty");
        assertEquals("", new Queue(0).toString());
        assertEquals("", new Queue(1).toString());
    }
    
    /**
     * Test of toString method, of class Queue.
     */
    @Test
    public void testToStringOne() {
        System.out.println("toString");
        System.out.println("It should print a string with a single element if there is one element");
        Queue instance = new Queue(1);
        instance.insert(42);
        String expResult = "42";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of toString method, of class Queue.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        System.out.println("It should print the contents of the queue without indicating to the viewer whether the sequence is broken by wrapping around the end of the array");
        Queue instance = new Queue(3);
        for(int i=0; i<3; i++) {
            instance.insert(i);
        }
        instance.remove();
        instance.insert(3);
        String expResult = "1, 2, 3";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}