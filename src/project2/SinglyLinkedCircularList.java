/**
 * The purpose of this project is to ensure that you understand how to work
 * with linked lists, and can use them to implement other ADTs (e.g., stack and queues) and solve
 * non-trivial problems.
 * 
 * @author Jason Travis
 */
package project2;

import java.util.ListIterator;

public class SinglyLinkedCircularList<E> {
	private Node first = null, last = null;
	private int size = 0;
	
	/**
	 * Add the element at the specified index.
	 * @param index the list index to insert the element
	 * @param e the element to add
	 */
	public void add(int index, E e) throws IndexOutOfBoundsException {
		if(index > size) throw new IndexOutOfBoundsException("Tried to add an element at index " + index + " to a list with " + size + " elements.");
		if(index == 0) {
			// The index is at the beginning
			addFirst(e);
		} else if(index == size) {
			// The index is at the end
			addLast(e);
		} else {
			// The index is somewhere in the middle
			Node n = new Node(e);
			Node tmp = first;
			for(int i = 0; i < index - 1; i++) {
				tmp = tmp.getNext();
				tmp.setNext(n);
			}
			n.setNext(tmp.getNext());
		}
	}
	
	/**
	 * Adds the element to the beginning of the list.
	 * @param e the element to add
	 */
	public void addFirst(E e) {
		Node n = new Node(e);
		if(this.isEmpty()) {
			n.setNext(n);
			first = n;
			last = n;
		} else {
			n.setNext(first);
			last.setNext(n);
		}
	}
	
	/**
	 * Adds the element to the end of the list.
	 * @param e the element to add
	 */
	public void addLast(E e) {
		Node n = new Node(e);
		if(this.isEmpty()) {
			n.setNext(n);
			first = n;
			last = n;
		} else {
			n.setNext(first);
			last.setNext(n);
			last = n;
		}
	}
	
	/**
	 * Returns the first element.
	 * @return the first element
	 */
	public E getFirst() {
		if(first != null) {
			return first.getContent();
		}
		return null;
	}
	
	/**
	 * Returns true if the list is empty.
	 * @return true if the list is empty
	 */
	public boolean isEmpty() {
		return first == null;
	}
	
	/**
	 * Returns the list iterator starting at the given index
	 * @param index the starting index
	 * @return the list iterator starting at the given index
	 */
	public ListIterator<E> listIterator(int index) {
		return new Iterator(index);	
	}
	
	/**
	 * Removes the first element.
	 */
	public void removeFirst() {
		if(this.isEmpty()) {
			// NoOp, the list is empty
		} else if(first.getNext() == null) {
			// If there is one node, set all pointers to null 
			first = null;
			last = null;
		} else {
			// All other cases, cleanup the first node pointer and point to the next element
			Node n = first.getNext();
			first.setNext(null);
			first = n;
		}
	}
	
	/**
	 * Returns the number of elements.
	 * @return the number of elements
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Iterator iterates over the elements of the list.
	 */
	public class Iterator implements ListIterator<E> {
		private Node current = first, prev = null;
		private int index = 0;
		
		/**
		 * Creates an iterator starting at the given index. 
		 * @param index the starting index
		 */
		public Iterator(int index) {
			// Move to starting index
			for(int i = 0; i < index; i++) {
				prev = current;
				current = current.getNext();
				index++;
			}
		}

		@Override
		public void add(E e) {
			Node n = new Node(e);
			n.setNext(current.getNext());
			current.setNext(n);
			prev = current;
			current = n;
			index++;
		}

		@Override
		public boolean hasNext() {
			return current.getNext() != null;
		}

		@Override
		public boolean hasPrevious() {
			return false;
		}

		@Override
		public E next() {
			if(hasNext()) {
				prev = current;
				current = current.getNext();
				index++;
				return current.getContent();
			}
			return null;
		}

		@Override
		public int nextIndex() {
			if(hasNext()) {
				return index + 1;
			}
			return -1;
		}

		@Override
		public E previous() {
			return null;
		}

		@Override
		public int previousIndex() {
			return -1;
		}

		@Override
		public void remove() {
			prev.setNext(current.getNext());
			current.setNext(null);
		}

		@Override
		public void set(E e) {
			current.setContent(e);			
		}
	}
	
	/**
	 * Node represents a node in a Linked List.
	 */
	private class Node {
		private E e;
		private Node n = null;
		
		/**
		 * Creates a node with the given content.
		 * @param e the node content
		 */
		private Node(E e) {
			this.e = e;
		}

		/**
		 * Returns the element stored in the node.
		 * @return the node element
		 */
		private E getContent() {
			return e;
		}
		
		/**
		 * Sets the node content.
		 * @param e the node content
		 */
		private void setContent(E e) {
			this.e = e;
		}
		
		/**
		 * Returns the next node in the list.
		 * @return the next node
		 */
		private Node getNext() {
			return n;
		}
		
		/**
		 * Sets the pointer to the next node in the list
		 * @param n the next node
		 */
		private void setNext(Node n) {
			this.n = n;
		}
	}
}