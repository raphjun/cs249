package worksheet3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jason Travis
 */
public class CircListTest {

    CircList instance;

    public CircListTest() {
    }

    @Before
    public void setUp() {
        instance = new CircList();
    }

    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of isEmpty method, of class CircList.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        assertTrue("It should be empty when instantiated", instance.isEmpty());
        instance.insert(42);
        assertFalse("It should not be empty when an item is inserted", instance.isEmpty());
    }

    /**
     * Test of getSize method, of class CircList.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        assertEquals("getSize should be zero when instantiated", 0, instance.getSize());
        instance.insert(42);
        assertEquals("getSize should be one when an item is inserted", 1, instance.getSize());
        instance.delete();
        assertEquals("getSize should be zero when an item is deleted", 0, instance.getSize());
        instance.insert(42);
        instance.delete(42);
        assertEquals("getSize should be zero when a specific item is deleted", 0, instance.getSize());
    }

    /**
     * Test of insert method, of class CircList.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        instance.insert(42);
        assertEquals("getSize should be one when an item is inserted", 1, instance.getSize());
    }

    /**
     * Test of delete method, of class CircList.
     */
    @Test
    public void testDelete_0args() {
        System.out.println("delete");
        assertEquals("It should return null when the list is instantiated", null, instance.delete());
        instance.insert(42);
        assertEquals("It should return the deleted node", 42, instance.delete().iData);
        assertNull("It should return null when the list is empty", instance.delete());
    }

    /**
     * Test of find method, of class CircList.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        assertNull("It should return null when the list is instantiated", instance.find(0));
        instance.insert(42);
        assertNull("It should return null when the item is not in the list", instance.find(0));
        assertEquals("It should return the node when the item is in the list", 42, instance.find(42).iData);
    }

    /**
     * Test of delete method, of class CircList.
     */
    @Test
    public void testDelete_long() {
        System.out.println("delete");
        assertNull("It should return null when the list is instantiated", instance.delete(0));
        instance.insert(42);
        assertNull("It should return null when the item is not in the list", instance.delete(0));
        assertEquals("It should return the node when the deleted node when the item is in the list", 42, instance.delete(42).iData);
        assertNull("It should return null when the list is empty", instance.delete(42));
    }
}