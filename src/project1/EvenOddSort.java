/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

/**
 *
 * @author jason
 */
public class EvenOddSort {
    
    int[] arr;
    
    public EvenOddSort(int[] arr) {
        this.arr = arr;
    }
    
    /**
     * sort uses the even-odd sort algorithm to sort the array.
     * An example of where an algorithm like this would be particularly
     * useful would be on a multiprocessor computer, distributed system, or
     * General-purpose processing on Graphics Processing Units (GPGPU) program
     * where a subset of data could be sorted by a processor without stepping on
     * the work of any other.
     * @return the sorted array
     */
    public int[] sort() {
        boolean even = true;
        boolean sorted = false;
        while(!sorted) {
            // Assume the array is sorted
            sorted = true;
            // Alternate between even and odd passes
            for(int i = (even ? 0 : 1); i<arr.length-1; i+=2) {
                if(arr[i] > arr[i+1]) {
                    // The array is not sorted
                    sorted = false;
                    // Use the XOR trick to swap without a temp variable
                    arr[i] ^= arr[i+1];
                    arr[i+1] ^= arr[i];
                    arr[i] ^= arr[i+1];
                }
            }
            even = !even;
        }
        return arr;
    }
    
}
