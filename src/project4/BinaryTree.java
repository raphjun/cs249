package project4;

import java.util.LinkedList;

/**
 * BinaryTree creates a binary tree from the characters of a String
 *
 * @author Jason Travis
 */
public class BinaryTree {

    public static void main(String[] args) {
        BinaryTree btree = new BinaryTree();
        //btree.insert("abcdefghij");
        btree.insert("lnhyYLN");
        btree.levelorder(btree.root);
        System.out.println();
        btree.preOrder(btree.root);
        System.out.println();
        btree.inOrder(btree.root);
        System.out.println();
        btree.postOrder(btree.root);
    }

    public Node root;

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

    public void inOrder(Node n) {
        if (n != null) {
            inOrder(n.left);
            System.out.print(n.c + " ");
            inOrder(n.right);
        }
    }
    
    public void preOrder(Node n) {
        if (n != null) {
            System.out.print(n.c + " ");
            preOrder(n.left);
            preOrder(n.right);
        }
    }
    public void postOrder(Node n) {
        if (n != null) {
            postOrder(n.left);
            postOrder(n.right);
            System.out.print(n.c + " ");
        }
    }

    public void levelorder(Node root) {
        LinkedList<Node> q = new LinkedList();
        q.addLast(root);
        while (!q.isEmpty()) {
            Node n = q.removeFirst();
            System.out.print(n.c + " ");
            if (n.left != null) {
                q.addLast(n.left);
            }
            if (n.right != null) {
                q.addLast(n.right);
            }
        }
    }

    private class Node {

        Node left, right;
        char c;

        private Node(char c) {
            this.c = c;
        }
    }
}
