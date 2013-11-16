package project4;

public class Node<E extends Comparable<E>> implements Comparable<Node<E>> {

    Node left, right;
    E key;

    public Node(E e) {
        this.key = e;
    }

    @Override
    public int compareTo(Node<E> n) {
        return this.key.compareTo(n.key);
    }
}
