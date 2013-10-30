/**
 * Create a two-dimensional linked list to represent a matrix. Each node (except
 * those in the top row and those in the left column) should be pointed to by
 * the link directly above it and by the link on its left. Thus, you will have
 * to update the Node class to include two pointers (e.g., right and down)
 *
 * The size of matrix should be defined by the user when the program starts. The
 * values stored at each location of the matrix (i.e., node) should be
 * initialized based on the position i,j. For example, the first node in the top
 * left corner should have the value 00, the 1st node in the 4th row should have
 * the value 03 (Note: counting should start at 0). You can assume you the
 * largest matrix would be 10 x 10.
 *
 * Your implementation should allow users to insert a specific value at a
 * specific location, fill the entire matrix with a given value, ask for the sum
 * (which should provide both row and column sums formatted at the ends of the
 * rows and columns), and/or just display the matrix.
 *
 * @author Jason Travis
 */
package project3;

public class LinkedMatrix {

    private Node first;
    private int xDim, yDim;

    public static void main(String[] args) {
        LinkedMatrix matrix = new LinkedMatrix(5, 2);
        matrix.display(3, true);
        System.out.println();
        matrix.fill(42);
        matrix.display(3, true);
        System.out.println();
        matrix.insert(1, 1, 100);
        matrix.display(3, false);
    }

    /**
     * @param xDim size in the 'x' dimension
     * @param yDim size in the 'y' dimension
     */
    public LinkedMatrix(int xDim, int yDim) {
        this.xDim = xDim;
        this.yDim = yDim;
        // Initialize first to a pre-matrix node
        this.first = new Node(0, 0);

        // Initialize rows
        Node rowStart = this.first, current;
        for (int row = 0; row < this.yDim; row++) {
            // Create a new row
            rowStart = (rowStart.down = new Node(0, row));
            // Move to the start of the row
            current = rowStart;
            // Initialize columns
            for (int column = 0; column < this.xDim - 1; column++) {
                current = (current.right = new Node(column + 1, row));
            }
        }
        // Move from the pre-matrix node to the first node of the matrix
        this.first = this.first.down;
    }

    /**
     * Displays the matrix.
     *
     * @param pad the max number of zeros to pad the node elements
     * @param withSums include row and column sums
     */
    public void display(int pad, boolean withSums) {
        int[] rowSums = new int[this.yDim];
        int[] colSums = new int[this.xDim];

        Node rowStart = this.first, current;
        for (int row = 0; row < this.yDim; row++) {
            // Move to the start of the row
            current = rowStart;
            // Print and sum the row first element
            System.out.print(String.format(" %0" + pad + "d", current.element));
            rowSums[row] += current.element;
            colSums[0] += current.element;
            // Print and sum the row elements
            // Sum the column elements
            for (int column = 1; column < this.xDim; column++) {
                current = current.right;
                rowSums[row] += current.element;
                colSums[column] += current.element;
                System.out.print(String.format(" %0" + pad + "d", current.element));
            }
            if (withSums) {
                // Print row sums
                System.out.print(String.format(" |%0" + pad + "d", rowSums[row]));
            }
            // Move to the next row
            rowStart = rowStart.down;
            System.out.println();
        }
        if (withSums) {
            // Create a divider the width of the element padding
            String divider = " ";
            for (int i = 0; i < pad; i++) {
                divider += "_";
            }
            // Print the divider between the matrix and the sums
            for (int column = 0; column < this.xDim; column++) {
                System.out.print(divider);
            }
            System.out.println();
            // Print the column sums
            for (int n : colSums) {
                System.out.print(String.format(" %0" + pad + "d", n));
            }
        }
        System.out.println();
    }

    /**
     * Fills the entire matrix with a given value
     *
     * @param value the value for the matrix nodes
     */
    public void fill(int value) {
        Node rowStart = this.first, current;
        for (int row = 0; row < this.yDim; row++) {
            // Move to the start of the row and set its value
            current = rowStart;
            current.element = value;
            // Set the value of each element
            for (int column = 0; column < this.xDim-1; column++) {
                current = current.right;
                current.element = value;
            }
            // Move to the next row
            rowStart = rowStart.down;
        }
    }

    /**
     * Inserts the given value in the node with position 'x', 'y'
     *
     * @param x the x coordinate of the node
     * @param y the y coordinate of the node
     * @param content the content for the node
     */
    public void insert(int x, int y, int content) {
        Node n = first;
        // Move to the node x coordinate
        for (int i = 0; i < x-1; i++) {
            n = n.right;
        }
        // Move to the node y coordinate
        for (int i = 0; i < y-1; i++) {
            n = n.down;
        }
        // Insert the given value
        n.element = content;
    }

    private class Node {

        private int element;
        private Node right, down;

        private Node(int x, int y) {
            this.element = y * LinkedMatrix.this.xDim + x;
        }
    }
}
