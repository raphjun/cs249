package worksheet1;

import worksheet1.Apple;
import worksheet1.Bag;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class BagTest {
    
    public BagTest() {
    }

    /**
     * Test add method
     */
    @Test
    public void testAddZeroCapacity() {
        Apple apple = new Apple();
        Bag instance = new Bag(0);
        boolean expResult = false;
        int expCount = 0;
        boolean result = instance.add(apple);
        assertEquals(expResult, result);
        assertEquals(expCount, instance.getCount());
    }
    
    /**
     * Test add method
     */
    @Test
    public void testAddOneCapacity() {
        Apple apple = new Apple();
        Bag instance = new Bag(1);
        boolean expResult = true;
        int expCount = 1;
        boolean result = instance.add(apple);
        assertEquals(expResult, result);
        assertEquals(expCount, instance.getCount());
    }
    
    /**
     * Test add method
     */
    @Test
    public void testAddFull() {
        Bag instance = new Bag(1);
        instance.add(new Apple());
        boolean expResult = false;
        int expCount = 1;
        boolean result = instance.add(new Apple());
        assertEquals(expResult, result);
        assertEquals(expCount, instance.getCount());
    }

    /**
     * Test remove method
     */
    @Test
    public void testRemoveZeroCapacity() {
        Bag instance = new Bag(0);
        Apple expResult = null;
        int expCount = 0;
        Apple result = instance.remove();
        assertEquals(expResult, result);
        assertEquals(expCount, instance.getCount());
    }
    
    /**
     * Test remove method
     */
    @Test
    public void testRemoveEmptyOneCapacity() {
        Bag instance = new Bag(1);
        Apple expResult = null;
        int expCount = 0;
        Apple result = instance.remove();
        assertEquals(expResult, result);
        assertEquals(expCount, instance.getCount());
    }
    
    /**
     * Test remove method
     */
    @Test
    public void testAddRemoveOneCapacity() {
        Apple apple = new Apple();
        Bag instance = new Bag(1);
        if(!instance.add(apple)) {
            fail("Failed to add apple to the bag");
        }
        assertEquals(1, instance.getCount());
        Apple expResult = apple;
        int expCount = 0;
        Apple result = instance.remove();
        assertEquals(expResult, result);
        assertEquals(expCount, instance.getCount());
    }
    
    /**
     * Test remove method
     */
    @Test
    public void testAddAddRemoveTwoCapacity() {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Bag instance = new Bag(2);
        if(!instance.add(apple1)) {
            fail("Failed to add apple1 to the bag");
        }
        if(!instance.add(apple2)) {
            fail("Failed to add apple2 to the bag");
        }
        int expCount = 1;
        Apple result = instance.remove();
        assertThat(result, anyOf(is(apple1), is(apple2)));
        assertEquals(expCount, instance.getCount());
    }
}