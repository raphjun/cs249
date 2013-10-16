package project1;

/**
 * Dequeue represents a generic double-ended queue
 *
 * @author Jason Travis
 */
public class Dequeue<E> {

    private Object[] dequeue;
    private int start, end;

    public Dequeue(int capacity) {
        dequeue = new Object[capacity];
        start = -1;
        end = -1;
    }

    /**
     * insertLeft inserts an element on the left-side of the queue
     * 
     * @param e the element to insert
     * @return true if successful
     */
    public boolean insertLeft(E e) {
        if (isFull() || e == null) {
            // The queue is full or the object is invalid
            return false;
        }
        if (isEmpty()) {
            // Move the pointers to the first position
            start = 0;
            end = 0;
        } else if (start == 0) {
            // If there's no space to the left, wrap around to the last index
            start = dequeue.length - 1;
        } else {
            // Move the start pointer left
            start--;
        }
        dequeue[start] = e;
        return true;
    }

    /**
     * insertRight inserts elements on the right-side of the queue
     * 
     * @param e the element to insert
     * @return true if successful
     */
    public boolean insertRight(E e) {
        if (isFull() || e == null) {
            // The queue is full or the object is invalid
            return false;
        }
        if (isEmpty()) {
            // Move the pointers to the first position
            start = 0;
            end = 0;
        } else if (end == dequeue.length - 1) {
            // If there's no space to the right, wrap around to the first index
            end = 0;
        } else {
            // Move the start pointer left
            end++;
        }
        dequeue[end] = e;
        return true;
    }

    /**
     * removeLeft removes elements from the left-side of the queue
     * 
     * @return the removed element
     */
    public E removeLeft() {
        if (isEmpty()) {
            return null;
        }
        E e = (E) dequeue[start];
        dequeue[start] = null;
        if (start == end) {
            // This was the last item, move the pointers off the queue
            start = -1;
            end = -1;
        } else if(start == dequeue.length-1) {
            // If there's no space to the right, wrap around to the first index
            start = 0;
        } else {
            // Move the start pointer right
            start++;
        }
        return e;
    }

    /**
     * removeRight removes elements from the right-side of the queue
     * 
     * @return the removed element
     */
    public E removeRight() {
       if (isEmpty()) {
            return null;
        }
        E e = (E) dequeue[end];
        dequeue[end] = null;
        if (start == end) {
            // This was the last item, move the pointers off the queue 
            start = -1;
            end = -1;
        } else if(end == 0) {
            // If there's no space to the left, wrap around to the last index
            end = dequeue.length-1;
        } else {
            // Move the pointer left
            end--;
        }
        return e;
    }

    /**
     * isEmpty returns true if the queue is empty
     * 
     * @return true if empty
     */
    public boolean isEmpty() {
        return start == -1 && end == -1;
    }

    /**
     * isFull returns true if the queue is full
     * 
     * @return true if full
     */
    public boolean isFull() {
        return (end == start - 1) || (start == 0 && end == dequeue.length - 1) || dequeue.length == 0;
    }
}
