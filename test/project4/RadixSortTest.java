package project4;

import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jason Travis
 */
public class RadixSortTest {

    /**
     * Test of binarySort method, of class RadixSort.
     */
    @Test
    public void testBinarySort() {
        LinkedList<Integer> list = new LinkedList();
        RadixSort instance = new RadixSort();
        assertEquals("It should sort an empty list", "[]", instance.binarySort(list).toString());
        list.add(42);
        assertEquals("It should sort a single item", "[42]", instance.binarySort(list).toString());
        list.add(-9); list.add(0); list.add(2); list.add(-9);
        assertEquals("It should sort a list", "[-9, -9, 0, 2, 42]", instance.binarySort(list).toString());
    }

}
