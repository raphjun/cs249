package project1;

// queue.java
// demonstrates queue
// to run this program: C>java QueueApp
////////////////////////////////////////////////////////////////
class Queue {

    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;
//--------------------------------------------------------------
    public Queue(int s) // constructor
    {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
//--------------------------------------------------------------
    public void insert(long j) // put item at rear of queue
    {
        if (rear == maxSize - 1) // deal with wraparound
        {
            rear = -1;
        }
        queArray[++rear] = j;
// increment rear and insert
        nItems++;
// one more item
    }
//--------------------------------------------------------------
    public long remove() // take item from front of queue
    {
        long temp = queArray[front++]; // get value and incr front
        if (front == maxSize) // deal with wraparound
        {
            front = 0;
        }
        nItems--;
// one less item
        return temp;
    }
//--------------------------------------------------------------
    public long peekFront() // peek at front of queue
    {
        return queArray[front];
    }
//--------------------------------------------------------------
    public boolean isEmpty() // true if queue is empty
    {
        return (nItems == 0);
    }
//--------------------------------------------------------------
    public boolean isFull() // true if queue is full
    {
        return (nItems == maxSize);
    }
//--------------------------------------------------------------
    public int size() // number of items in queue
    {
        return nItems;
    }
//--------------------------------------------------------------
    @Override
    /**
     * toString prints the contents of the queue
     * @return a string representing the queue contents
     */
    public String toString() {
        int index = front;
        String s = "";
        for(int i=0; i<nItems; i++) {
            s += queArray[index++] + ", ";
            if(index == maxSize) {
                // Wrap around if we hit the end of the array
                index = 0;
            }
        }
        // Trim the trailing ', ' if the string is not empty
        return (s.equals("") ? s : s.substring(0, s.length()-2));
    }
} // end class Queue