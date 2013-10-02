package worksheet3;

public class CircList {

    private Node current;          // ref to current link
    private int count;             // # of links on list

    public CircList() {             // constructor
        count = 0;                  // no links on list yet
        current = null;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int getSize() {
        return count;
    }

    /**
     * insert inserts the element in a new node before the current node
     * 
     * @param id the element to insert
     */
    public void insert(long id) {   // insert  before current
        Node prev = getPrev(current);
        Node newNode = new Node(id);
        if (prev == null) {
            current = newNode;
            current.next = current;
        } else {
            newNode.next = prev.next;
            prev.next = newNode;
        }
        count++;
    }

    /**
     * delete removes the current node from the list
     * 
     * @return the node that was removed
     */
    public Node delete() {         // delete current
        if (current == null) {
            return null;
        }
        Node n = current;
        Node prev = getPrev(n);
        prev.next = n.next;
        n.next = null;
        current = prev.next;
        count--;
        return n;
    }

    /**
     * find returns the first node after current with the given key
     * 
     * @param key the data the node should contain
     * @return the first node after current with the given key or null if not found
     */
    public Node find(long key) {     // find first link after current with given key
        if (current == null) {
            return null;
        }
        Node iter = current;
        do {
            iter = iter.next;
        } while (iter.next != current && iter.iData != key);
        if (iter.iData == key) {
            return iter;
        } else {
            return null;
        }
    }

    /**
     * delete removes the link with the given key
     * 
     * @param key the data the node should contain
     * @return the node that was removed or null if not found
     */
    public Node delete(long key) {    // delete link with given key
        if (current == null) {
            return null;
        }
        Node n = find(key);
        if (n == null) {
            return null;
        }
        Node prev = getPrev(n);
        prev.next = n.next;
        n.next = null;
        current = prev.next;
        count--;
        return n;
    }

    /*
     * getPrev returns the previous node
     * 
     * @param n the current node
     * @return the previous node
     */
    private Node getPrev(Node n) {
        if (n == null) {
            return null;
        }

        Node iter = n;
        do {
            iter = iter.next;
        } while (iter.next != n);
        return iter;




    }

    public class Node {

        public long iData;              // data item (key)
        public Node next;              // next link in list

// -------------------------------------------------------------
        public Node(long id) {           // constructor
            iData = id;		// (next automatically null)
        }

// -------------------------------------------------------------
        public void displayNode() {     // display yourself
            System.out.print(iData + " ");
        }
    }  // end class Node
}  // end class CircList