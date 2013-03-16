/**
 * Create a two-dimensional linked list to represent a matrix. Each node (except those in the top
 * row and those in the left column) should be pointed to by the link directly above it and by the link
 * on its left. Thus, you will have to update the Node class to include two pointers (e.g., right and
 * down)
 * 
 * The size of matrix should be defined by the user when the program starts. The values stored at
 * each location of the matrix (i.e., node) should be initialized based on the position i,j. For example,
 * the first node in the top left corner should have the value 00, the 1st node in the 4th row should
 * have the value 03 (Note: counting should start at 0). You can assume you the largest matrix
 * would be 10 x 10.
 *
 * Your implementation should allow users to insert a specific value at a specific location, fill the
 * entire matrix with a given value, ask for the sum (which should provide both row and column
 * sums formatted at the ends of the rows and columns), and/or just display the matrix.
 * 
 * @author Jason Travis
 */
package project2;

public class LinkedMatrix {
	private Node first;
	private int width, height;
	
	public static void main(String[] args) {
		LinkedMatrix matrix = new LinkedMatrix(5, 2);
		matrix.display(false);
	}
	
	public LinkedMatrix(int width, int height) {
		this.width = width;
		this.height = height;
		
		first = new Node(0, 0, 0);
		Node rowStart = first;
		Node current = first;
		
		// Initialize columns
		for(int row = 0; row < height; row++) {
			// Initialize row
			for(int column = 0; column < width - 1; column++) {
				current.right = new Node(column + 1, row, 0);
				current.down = new Node(column, row + 1, 0);
				current = current.right;
			}
			// Move to the start of the next row
			rowStart.down = new Node(0, row, 0);
			rowStart = rowStart.down;
			current = rowStart;
		}
		
		// Move from the pre-matrix node to the first node of the matrix
		//first = first.next;
	}
	
	/**
	 * Displays the matrix
	 * @param withSums prints with row and column sums if true
	 */
	public void display(boolean withSums) {
		// TODO format to width of largest sum and content
		// System.out.printf("%5d", n);
		//int[] rowSums = new int[width];
		//int[] colSums = new int[height];
		Node rowStart = first;
		Node current = first;
		for(int row = 0; row < height; row ++) {
			for(int column = 0; column < width; column++) {
				System.out.print(" " + current.x + current.y);
				current = current.right;
			}
			System.out.println();
			rowStart = rowStart.down;
			current = rowStart;
		}
		//Node n = first.down.next;
		//System.out.println("" + n.x + n.y);
	}
	
	/**
	 * Fills the entire matrix with a given value
	 * @param value the value for the matrix nodes
	 */
	public void fill(int value) {
		Node columnTop = first;
		Node current = first;
		// fill row
		for(int column = 0; column < width; column++) {
			// fill column
			for(int row = 0; row < height; row++) {
				current.value = value;
				current = current.down;
			}
			// move to the next column
			columnTop = columnTop.right;
			current = columnTop;
		}
	}
	
	/**
	 * Inserts the given value in the node with position 'x', 'y'
	 * @param x the x coordinate of the node
	 * @param y the y coordinate of the node
	 * @param content the content for the node
	 */
	public void insert(int x, int y, int content) {
		Node n = first;
		// Move to the node x coordinate
		for(int i = 0; i < x; i++) {
			n = n.right;
		}
		// Move to the node y coordinate
		for(int i = 0; i < y; i++) {
			n = n.down;
		}
		// Insert the given value
		n.value = content;
	}
	
	// TODO Node class comments
	private class Node {
		private int value;
		public int x = 0, y = 0;
		private Node right, down;
		
		private Node(int x, int y, int content) {
			this.x = x;
			this.y = y;
			this.value = content;
		}

		/**
		 * 
		 * @param n
		 */
		public void setNext(Node n) {
			this.right = n;
		}

		/**
		 * @return the content
		 */
		private int getContent() {
			return value;
		}
		
		/**
		 * @return the next node
		 */
		private Node getNext() {
			return right;
		}
	}

}
