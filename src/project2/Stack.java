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
	private SinglyLinkedCircularList<E> stack;
	
	/**
	 * Returns the element on the top of the stack without removing it.
	 * @return the top element
	 */
	public E peek() {
		return stack.getFirst();
	}
	
	/**
	 * Returns the top element and removes it from the stack.
	 * @return the top element
	 */
	public E pop() {
		E e = stack.getFirst();
		stack.removeFirst();
		return e;
	}
	
	/**
	 * Adds the element to the top of the stack.
	 * @param e the element to add
	 */
	public void push(E e) {
		stack.addFirst(e);
	}
		
}