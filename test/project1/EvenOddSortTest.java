package project1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jason Travis
 */
public class EvenOddSortTest {
    
    public EvenOddSortTest() {
    }
    
    /**
     * Test of sort method, of class EvenOddSort.
     */
    @Test
    public void testSort0() {
        System.out.println("sort");
        System.out.println("It should sort a 0 element array");
        int[] arr = new int[0];
        EvenOddSort instance = new EvenOddSort(arr);
        int[] expResult = new int[0];
        int[] result = instance.sort();
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test of sort method, of class EvenOddSort.
     */
    @Test
    public void testSort1() {
        System.out.println("sort");
        System.out.println("It should sort a single element array");
        int[] arr = {0};
        EvenOddSort instance = new EvenOddSort(arr);
        int[] expResult = {0};
        int[] result = instance.sort();
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test of sort method, of class EvenOddSort.
     */
    @Test
    public void testSort3() {
        System.out.println("sort");
        System.out.println("It should sort a three element array");
        int[] arr = {3,2,1};
        EvenOddSort instance = new EvenOddSort(arr);
        int[] expResult = {1,2,3};
        int[] result = instance.sort();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of sort method, of class EvenOddSort.
     */
    @Test
    public void testSort10() {
        System.out.println("sort");
        System.out.println("It should sort an even length array");
        int[] arr = {9,8,7,6,5,4,3,2,1,0};
        EvenOddSort instance = new EvenOddSort(arr);
        int[] expResult = {0,1,2,3,4,5,6,7,8,9};
        int[] result = instance.sort();
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test of sort method, of class EvenOddSort.
     */
    @Test
    public void testSort11() {
        System.out.println("sort");
        System.out.println("It should sort an odd length array");
        int[] arr = {10,9,8,7,6,5,4,3,2,1,0};
        EvenOddSort instance = new EvenOddSort(arr);
        int[] expResult = {0,1,2,3,4,5,6,7,8,9,10};
        int[] result = instance.sort();
        assertArrayEquals(expResult, result);
    }
}