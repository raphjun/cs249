/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package worksheet1;

public class Bag {

    private Apple[] appleBag;
    private int count;

    public Bag(int capacity) {
        appleBag = new Apple[capacity];
        count = 0;
    }
    
    public int getCount() {
        return count;
    }
    
    public int getCapacity() {
        return appleBag.length;
    }

    public boolean add(Apple apple) {
        if (count == appleBag.length) {
            return false;
        }
        // Place the apple in the next available index
        appleBag[count++] = apple;
        return true;
    }

    public Apple remove() {
        if (count < 1) {
            return null;
        }
        // Select an apple at random
        int n = (int)(Math.random()*(count));
        // remove it from the bag
        Apple apple = appleBag[n];
        appleBag[n] = null;
        // Replace it with the apple in the last filled index so there are no gaps.
        // If they happen to be the same it doesn't matter
        appleBag[n] = appleBag[--count];
        return apple;
    }
}