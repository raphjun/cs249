/**
 * The purpose of this project is to ensure that you understand how to work
 * with linked lists, and can use them to implement other ADTs (e.g., stack and queues) and solve
 * non-trivial problems.
 * 
 * @author Jason Travis
 */
package project2;

/**
 * Implement a stack class based on a circular singly linked list. One should be able to push and pop
 * items onto the stack, just as we discussed with an array implementation of a stack.
 */
public class Stack<E> {
	
	private Node first = null, last = null;
	
	/**
	 * Returns the element on the top of the stack without removing it.
	 * @return the top element
	 */
	public E peek() {
		if(this.isEmpty()) {
			return null;
		}
		return first.getElement();
	}
	
	/**
	 * Returns the top element and removes it from the stack.
	 * @return the top element
	 */
	public E pop() {
		// If the list is empty, return null
		if(this.isEmpty()) {
			return null;
		}
		// If there is one node, set all pointers to null and return the content of the node
		if(first.getNext() == null) {
			Node tmp = first;
			first = null;
			last = null;
			return tmp.getElement();
		}
		// All other cases, remove the first node and return its content
		first = first.getNext();
		return first.getElement();
	}
	
	/**
	 * Adds the element to the top of the stack.
	 * @param the element to add
	 */
	public void push(E element) {
		Node n = new Node(element, first);
		if(this.isEmpty()) {
			last = n;
		}
		first = n;
		last.setNext(n);
	}
	
	/**
	 * Returns true if the stack is empty.
	 * @return true if the stack is empty
	 */
	private boolean isEmpty() {
		return first == null;
	}
	
	/**
	 * Node represents a node in a singly Linked List.
	 */
	private class Node {
		private E e;
		private Node next = null;
		
		/**
		 * Creates a new node with the given element and pointing to the next node.
		 * @param e the element to be added
		 * @param n the next node
		 */
		private Node(E e, Node n) {
			this.e = e;
			this.next = n;
		}

		/**
		 * Sets the pointer to the next node.
		 * @param n the next node
		 */
		public void setNext(Node n) {
			this.next = n;
		}

		/**
		 * Returns the node element.
		 * @return the element
		 */
		private E getElement() {
			return e;
		}
		
		/**
		 * Returns the next node.
		 * @return the next node
		 */
		private Node getNext() {
			return next;
		}
	}
	
}