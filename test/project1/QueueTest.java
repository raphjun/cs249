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
        instance.remove();
        instance.insert(4);
        assertEquals("2, 3, 4", instance.toString());
    }
    
    /**
     * Test of deleteMin method, of class Queue.
     */
    @Test
    public void testDeleteMin() {
        System.out.println("deleteMin");
        System.out.println("It should return 0 when the queue is empty");
        assertEquals(0, new Queue(0).deleteMin());
        assertEquals(0, new Queue(1).deleteMin());
        
        System.out.println("It should remove the minimum value when it is the first item");
        Queue instance = new Queue(3);
        for(int i=1; i<=3; i++) {
            instance.insert(i);
        }
        System.out.println("Before: " + instance.toString());
        assertEquals(1, instance.deleteMin());
        System.out.println("After: " + instance.toString());
        
        System.out.println("It should remove the minimum value when it is the last item");
        instance = new Queue(3);
        for(int i=3; i>=1; i--) {
            instance.insert(i);
        }
        System.out.println("Before: " + instance.toString());
        assertEquals(1, instance.deleteMin());
        System.out.println("After: " + instance.toString());
        
        System.out.println("It should remove the minimum value when there is wraparound");
        instance = new Queue(3);
        for(int i=1; i<=3; i++) {
            instance.insert(i);
        }
        System.out.println("Fill array: " + instance.toString());
        if(!instance.isFull()) fail("Failed to satisfy a precondition for wraparound. The array is not full.");
        instance.remove();
        System.out.println("remove(): " + instance.toString());
        instance.insert(-42);
        System.out.println("insert(-42): " + instance.toString());
        assertEquals(-42, instance.deleteMin());
        System.out.println("deleteMin(): " + instance.toString());
    }
}