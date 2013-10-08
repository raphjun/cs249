package project2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jason Travis
 */
public class CircListTest {

    public CircListTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of size method, of class CircList.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        Object e = new Object();
        CircList instance = new CircList();
        assertEquals("Size should be zero when instantiated", 0, instance.size());
        instance.add(e);
        assertEquals("Size should be one when an object is inserted", 1, instance.size());
        instance.remove(0);
        assertEquals("Size should be zero when the object is removed", 0, instance.size());
        instance.remove(0);
        assertEquals("Size remain zero when there is no object to remove", 0, instance.size());
    }

    /**
     * Test of isEmpty method, of class CircList.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        CircList instance = new CircList();
        assertTrue("It should be empty when instantiated", instance.isEmpty());
        if (!instance.add(new Object())) {
            fail("Unable to add object to list");
        }
        assertFalse("It should not be empty when an item is inserted", instance.isEmpty());
    }

    /**
     * Test of contains method, of class CircList.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Object e1 = new Object(), e2 = new Object(), e3 = new Object();
        CircList instance = new CircList();
        assertFalse("It should return false when the list is instantiated", instance.contains(e1));
        instance.add(e1);
        instance.add(e2);
        instance.add(e3);
        assertFalse("It should return false when the list does not contain the object", instance.contains(new Object()));
        assertTrue("It should return true when the first item is the object", instance.contains(e1));
        assertTrue("It should return true when the middle item is the object", instance.contains(e2));
        assertTrue("It should return true when the last item is the object", instance.contains(e3));
    }

    /**
     * Test of iterator method, of class CircList.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        Object e1 = new Object(), e2 = new Object(), e3 = new Object();
        CircList instance = new CircList();

        assertFalse("hasNext should return false when the list is empty", instance.iterator().hasNext());
        try {
            instance.iterator().next();
            fail("next should throw a NoSuchElementException if the list is empty");
        } catch (NoSuchElementException e) {
            // success
        }
        try {
            instance.iterator().remove();
            fail("remove should throw an IllegalStateException if the next method has not yet been called");
        } catch (IllegalStateException e) {
            // success
        }

        instance.add(e1);
        instance.add(e2);
        instance.add(e3);
        Iterator iter = instance.iterator();
        assertTrue("hasNext should return true when the list is not empty", iter.hasNext());
        assertEquals("next should return the next element in the iteration", e1, iter.next());
        iter.remove();
        try {
            iter.remove();
            fail("remove should throw an IllegalStateException if remove has already been called since the last call to the next method");
        } catch (IllegalStateException e) {
            // success
        }
    }

    /**
     * Test of toArray method, of class CircList.
     */
    @Test
    public void testToArray_0args() {
        System.out.println("toArray");
        CircList instance = new CircList();
        assertArrayEquals("It should return an empty array when instantiated", new Object[0], instance.toArray());
        Object e1 = new Object(), e2 = new Object(), e3 = new Object();
        Object[] expResult = new Object[]{e1, e2, e3};
        instance.add(e1);
        instance.add(e2);
        instance.add(e3);
        assertArrayEquals("It should return an array containing all elements in order", expResult, instance.toArray());
    }

    /**
     * Test of toArray method, of class CircList.
     */
    @Test
    public void testToArray_ObjectArr() {
        System.out.println("toArray");
        Object[] ts = null;
        CircList instance = new CircList();
        Object[] expResult = null;
        Object[] result = instance.toArray(ts);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class CircList.
     */
    @Test
    public void testAdd_Object() {
        System.out.println("add");
        Integer e1 = new Integer(1), e2 = new Integer(2), e3 = new Integer(3);
        CircList instance = new CircList();
        instance.add(e1);
        assertEquals(1, instance.size());
        instance.add(e2);
        assertEquals(2, instance.size());
        instance.add(e3);
        assertEquals(3, instance.size());
        assertEquals("It should return the first item", e1, instance.remove(0));
        assertEquals("It should return the second item", e2, instance.remove(0));
        assertEquals("It should return the third item", e3, instance.remove(0));
    }

    /**
     * Test of remove method, of class CircList.
     */
    @Test
    public void testRemove_Object() {
        System.out.println("remove");
        Object o = null;
        CircList instance = new CircList();
        boolean expResult = false;
        boolean result = instance.remove(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of containsAll method, of class CircList.
     */
    @Test
    public void testContainsAll() {
        System.out.println("containsAll");
        Collection clctn = null;
        CircList instance = new CircList();
        boolean expResult = false;
        boolean result = instance.containsAll(clctn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAll method, of class CircList.
     */
    @Test
    public void testAddAll_Collection() {
        System.out.println("addAll");
        Collection clctn = null;
        CircList instance = new CircList();
        boolean expResult = false;
        boolean result = instance.addAll(clctn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAll method, of class CircList.
     */
    @Test
    public void testAddAll_int_Collection() {
        System.out.println("addAll");
        int i = 0;
        Collection clctn = null;
        CircList instance = new CircList();
        boolean expResult = false;
        boolean result = instance.addAll(i, clctn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAll method, of class CircList.
     */
    @Test
    public void testRemoveAll() {
        System.out.println("removeAll");
        Collection clctn = null;
        CircList instance = new CircList();
        boolean expResult = false;
        boolean result = instance.removeAll(clctn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retainAll method, of class CircList.
     */
    @Test
    public void testRetainAll() {
        System.out.println("retainAll");
        Collection clctn = null;
        CircList instance = new CircList();
        boolean expResult = false;
        boolean result = instance.retainAll(clctn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class CircList.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        CircList instance = new CircList();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class CircList.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        CircList instance = new CircList();
        Object expResult = new Object();
        instance.add(expResult);
        assertNull("It should return null when the index is out of bounds", instance.get(1));
        assertNull("It should return null when the index is negative", instance.get(-1));
        assertEquals("It should return the object when it does exists", expResult, instance.get(0));
    }

    /**
     * Test of set method, of class CircList.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        Object e = new Object();
        CircList instance = new CircList();
        assertNull("It should return null when the index is out of bounds", instance.set(0, new Object()));
        assertNull("It should return null when the index is negative", instance.set(-1, new Object()));
        instance.add(new Object());
        instance.set(0, e);
        assertEquals("It should replace the element at the given index with the given element", e, instance.get(0));
    }

    /**
     * Test of add method, of class CircList.
     */
    @Test
    public void testAdd_int_Object() {
        System.out.println("add");
        int i = 0;
        Object e = null;
        CircList instance = new CircList();
        instance.add(i, e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class CircList.
     */
    @Test
    public void testRemove_int() {
        System.out.println("remove");
        Object e1 = new Object(), e2 = new Object(), e3 = new Object();
        CircList instance = new CircList();
        assertNull("It should return null when the list is empty", instance.remove(0));
        assertNull("It should not wraparound when the list is empty", instance.remove(-1));
        instance.add(e1);
        instance.add(e2);
        instance.add(e3);
        assertNull("It should return null when the index does not exist", instance.remove(3));
        assertEquals("It should return the third element", e3, instance.remove(2));
        assertEquals("It should return the second element", e2, instance.remove(1));
        assertEquals("It should return the first element", e1, instance.remove(0));
    }

    /**
     * Test of indexOf method, of class CircList.
     */
    @Test
    public void testIndexOf() {
        System.out.println("indexOf");
        Object o = null;
        CircList instance = new CircList();
        int expResult = 0;
        int result = instance.indexOf(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lastIndexOf method, of class CircList.
     */
    @Test
    public void testLastIndexOf() {
        System.out.println("lastIndexOf");
        Object o = null;
        CircList instance = new CircList();
        int expResult = 0;
        int result = instance.lastIndexOf(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listIterator method, of class CircList.
     */
    @Test
    public void testListIterator_0args() {
        System.out.println("listIterator");
        CircList instance = new CircList();
        ListIterator expResult = null;
        ListIterator result = instance.listIterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listIterator method, of class CircList.
     */
    @Test
    public void testListIterator_int() {
        System.out.println("listIterator");
        int i = 0;
        CircList instance = new CircList();
        ListIterator expResult = null;
        ListIterator result = instance.listIterator(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subList method, of class CircList.
     */
    @Test
    public void testSubList() {
        System.out.println("subList");
        int i = 0;
        int i1 = 0;
        CircList instance = new CircList();
        List expResult = null;
        List result = instance.subList(i, i1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}