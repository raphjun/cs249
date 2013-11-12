package project4;

/**
 * BinaryTree creates a binary tree from the characters of a String
 * @author Jason Travis
 */
public class BinaryTree {

    private Node root;

    /**
     * insert recursively creates a tree from the characters of the given string
     * in ascending order
     *
     * @param s
     */
    public void insert(String s) {
        this.root = insert_r(null, s, 0);
    }

    /**
     * insert_r creates a tree of the characters in the given String using
     * pre-order traversal.
     *
     * @param n the current node
     * @param s the String to parse
     * @param index the character index for the current node
     * @return root node
     */
    private Node insert_r(Node n, String s, int index) {
        if (index == 0 && n == null) {
            // Insert the first node in an empty tree
            n = new Node(s.charAt(0));
        }
        if (s.length() <= 2 * index + 1) {
            // No left child
            return null;
        }
        // Insert left child
        n.left = new Node(s.charAt(2 * index + 1));
        // Recursively insert left branch
        insert_r(n.left, s, 2 * index + 1);
        if (s.length() <= 2 * index + 2) {
            // No right child
            return null;
        }
        // Insert right child
        n.right = new Node(s.charAt(2 * index + 2));
        // Recursively insert right branch
        insert_r(n.right, s, 2 * index + 2);
        return n;
    }

    private class Node {

        Node left, right;
        char c;

        private Node(char c) {
            this.c = c;
        }
    }
}
