package project2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jason Travis
 */
public class StackTest {
    
    public StackTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of peek method, of class Stack.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Stack instance = new Stack();
        assertTrue("It should be empty after initialization", instance.isEmpty());
        instance.push(new Object());
        assertFalse("It should not be empty after an element is pushed", instance.isEmpty());
    }
    
    /**
     * Test of peek method, of class Stack.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        Object e1 = new Object(), e2 = new Object(), e3 = new Object();
        Stack instance = new Stack();
        assertNull("It should return null after initialization", instance.peek());
        instance.push(e1); instance.push(e2); instance.push(e3);
        assertEquals("It should return the last item pushed", e3, instance.peek());
    }

    /**
     * Test of push/pop method, of class Stack.
     */
    @Test
    public void testPushPop() {
        System.out.println("pop");
        Integer e1 = new Integer(1), e2 = new Integer(2), e3 = new Integer(3);
        Stack<Integer> instance = new Stack();
        assertNull("It should return null after initialization", instance.pop());
        instance.push(e1); instance.push(e2); instance.push(e3);
        assertEquals("It should return the last item pushed", e3, instance.pop());
        assertEquals("It should return the middle item pushed", e2, instance.pop());
        assertEquals("It should return the first item pushed", e1, instance.pop());
        assertNull("It should return null when empty", instance.pop());
    }
    
    /**
     * Test of push/pop method, of class Stack.
     */
    @Test
    public void testPushPopWithADifferentObjectType() {
        System.out.println("pop");
        Double e1 = new Double(1), e2 = new Double(2), e3 = new Double(3);
        Stack<Double> instance = new Stack();
        assertNull("It should return null after initialization", instance.pop());
        instance.push(e1); instance.push(e2); instance.push(e3);
        assertEquals("It should return the last item pushed", e3, instance.pop());
        assertEquals("It should return the middle item pushed", e2, instance.pop());
        assertEquals("It should return the first item pushed", e1, instance.pop());
        assertNull("It should return null when empty", instance.pop());
    }
}