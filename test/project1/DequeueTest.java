package project1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * DequeueTest will test each method of Dequeue generic
 * using Integer objects and Double objects
 * 
 * @author Jason Travis
 */
public class DequeueTest {

    Dequeue<Integer> intInstance;
    Dequeue<Double> dblInstance;
    Integer[] integers;
    Double[] doubles;

    public DequeueTest() {
    }

    @Before
    public void setUp() {
        intInstance = new Dequeue(3);
        dblInstance = new Dequeue(3);
        integers = new Integer[3];
        doubles = new Double[3];

        for (int i = 0; i < 3; i++) {
            integers[i] = new Integer(i);
            doubles[i] = new Double(i);
        }
    }

    @After
    public void tearDown() {
        intInstance = null;
        dblInstance = null;
        integers = null;
        doubles = null;
    }

    /**
     * Test of insertLeft method, of class Dequeue.
     */
    @Test
    public void testInsertLeft() {
        System.out.println("insertLeft");
        System.out.println("It should be full when filled to capacity from the left");
        for(int i=0; i<3; i++) {
            if(!intInstance.insertLeft(integers[i])) fail("insertLeft returned false when " + (i+1) + "/3 items were inserted.");
        }
        assertEquals(true, intInstance.isFull());
        for(int i=0; i<3; i++) {
            if(!dblInstance.insertLeft(doubles[i])) fail("insertLeft returned false when " + (i+1) + "/3 items were inserted.");
        }
        assertEquals(true, dblInstance.isFull());
    }

    /**
     * Test of insertRight method, of class Dequeue.
     */
    @Test
    public void testInsertRight() {
        System.out.println("insertRight");
        System.out.println("It should be full when filled to capacity from the right");
        for(int i=0; i<3; i++) {
            if(intInstance.isFull()) fail("isFull returned true when " + (i+1) + "/3 items were inserted.");
            if(!intInstance.insertRight(integers[i])) fail("insertRight returned false when " + (i+1) + "/3 items were inserted.");
        }
        assertEquals(true, intInstance.isFull());
        for(int i=0; i<3; i++) {
            if(dblInstance.isFull()) fail("isFull returned true when " + (i+1) + "/3 items were inserted.");
            if(!dblInstance.insertRight(doubles[i])) fail("insertRight returned false when " + (i+1) + "/3 items were inserted.");
        }
        assertEquals(true, dblInstance.isFull());
    }

    /**
     * Test of removeLeft method, of class Dequeue.
     */
    @Test
    public void testRemoveLeft() {
        System.out.println("removeLeft");
        System.out.println("It should return nothing when nothing is in the queue");
        assertEquals(null, intInstance.removeLeft());
        
        System.out.println("It should return the items in the reverse order they were inserted when inserted from the left.");
        for(int i=0; i<3; i++) {
            if(!intInstance.insertLeft(integers[i]) || !dblInstance.insertLeft(doubles[i])) fail("insertLeft returned false when " + i + "/3 items were inserted.");
        }
        for(int i=2; i>=0; i--) {
            assertEquals(integers[i], intInstance.removeLeft());
            assertEquals(doubles[i], dblInstance.removeLeft());
        }
        
        System.out.println("It should return the items in the same order they were inserted when inserted from the right.");
        for(int i=0; i<3; i++) {
            if(!intInstance.insertRight(integers[i]) || !dblInstance.insertRight(doubles[i])) fail("insertLeft returned false when " + i + "/3 items were inserted.");
        }
        for(int i=0; i<3; i++) {
            assertEquals(integers[i], intInstance.removeLeft());
            assertEquals(doubles[i], dblInstance.removeLeft());
        }
    }

    /**
     * Test of removeRight method, of class Dequeue.
     */
    @Test
    public void testRemoveRight() {
        System.out.println("removeRight");
        System.out.println("It should return nothing when nothing is in the queue");
        assertEquals(null, intInstance.removeRight());
        
        System.out.println("It should return the items in the same order they were inserted when inserted from the left.");
        for(int i=0; i<3; i++) {
            if(!intInstance.insertLeft(integers[i]) || !dblInstance.insertLeft(doubles[i])) fail("insertLeft returned false when " + i + "/3 items were inserted.");
        }
        for(int i=0; i<3; i++) {
            assertEquals(integers[i], intInstance.removeRight());
            assertEquals(doubles[i], dblInstance.removeRight());
        }
        
        System.out.println("It should return the items in the reverse order they were inserted when inserted from the right.");
        for(int i=0; i<3; i++) {
            if(!intInstance.insertRight(integers[i]) || !dblInstance.insertRight(doubles[i])) fail("insertLeft returned false when " + i + "/3 items were inserted.");
        }
        for(int i=2; i>=0; i--) {
            assertEquals(integers[i], intInstance.removeRight());
            assertEquals(doubles[i], dblInstance.removeRight());
        }
    }

    /**
     * Test of isEmpty method, of class Dequeue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        System.out.println("It should be empty when the queue has 0 capacity");
        assertEquals(true, new Dequeue(0).isEmpty());

        System.out.println("It should be empty when empty");
        assertEquals(true, intInstance.isEmpty());
        assertEquals(true, dblInstance.isEmpty());
        
        System.out.println("It should not be empty when an item has been inserted");
        if(!intInstance.insertLeft(integers[0]) || !dblInstance.insertLeft(doubles[0])) fail("insertLeft returned false");
        assertEquals(false, intInstance.isEmpty());
        assertEquals(false, dblInstance.isEmpty());
        
    }

    /**
     * Test of isFull method, of class Dequeue.
     */
    @Test
    public void testIsFull() {
        System.out.println("isFull");
        System.out.println("It should be full when the queue has 0 capacity");
        assertEquals(true, new Dequeue(0).isFull());

        System.out.println("It should not be full when empty");
        assertEquals(false, new Dequeue(1).isFull());
    }
}