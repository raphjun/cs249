/**
 * Implement a stack class based on a circular singly linked list. One should be able to push and pop
 * items onto the stack, just as we discussed with an array implementation of a stack.
 * @author Jason Travis
 */
package project2;

public class Stack<T> {
	
	private Node first = null, last = null;
	
	/**
	 * 
	 * @return the content of the first node
	 */
	public T peek() {
		if(this.isEmpty()) {
			return null;
		}
		return first.getContent();
	}
	
	/**
	 * 
	 * @return the content of the first node
	 */
	public T pop() {
		// If the list is empty, return null
		if(this.isEmpty()) {
			return null;
		}
		// If there is one node, set all pointers to null and return the content of the node
		if(first.getNext() == null) {
			Node tmp = first;
			first = null;
			last = null;
			return tmp.getContent();
		}
		// All other cases, remove the first node and return its content
		first = first.getNext();
		return first.getContent();
	}
	
	/**
	 * 
	 * @param content
	 */
	public void push(T content) {
		Node n = new Node(content, this.first);
		if(this.isEmpty()) {
			last = n;
		}
		first = n;
		last.setNext(n);
	}
	
	/**
	 * 
	 * @return true if the stack is empty
	 */
	private boolean isEmpty() {
		return first == null;
	}
	
	private class Node {
		private T content;
		private Node next = null;
		
		private Node(T t, Node n) {
			this.content = t;
			this.next = n;
		}

		/**
		 * 
		 * @param n
		 */
		public void setNext(Node n) {
			this.next = n;
		}

		/**
		 * @return the content
		 */
		private T getContent() {
			return content;
		}
		
		/**
		 * @return the next node
		 */
		private Node getNext() {
			return next;
		}
	}
	
}