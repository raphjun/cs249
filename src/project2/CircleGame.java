/**
 * The purpose of this project is to ensure that you understand how to work
 * with linked lists, and can use them to implement other ADTs (e.g., stack and queues) and solve
 * non-trivial problems.
 * 
 * @author Jason Travis
 */
package project2;

import java.util.ListIterator;

import project2.SinglyLinkedCircularList;

/**
 * Suppose you entered a contest to be the last person remaining in a group. The way the game
 * works is that everyone forms a circle and individuals count off up to a certain number in
 * clockwise order. Once the number is reached that person is eliminated and the count begins at 1
 * with the next person in the circle.
 * 
 * Design and implement an application to help ensure you win the contest. Inputs are the number of
 * people in the circle, the number used for counting off, and the location where counting starts.
 * The output should be the location you should start in to be the last person remaining. You should
 * use a circular singly linked list. The output is the list of persons being eliminated, each person
 * should have a name representing their original position in the circle (e.g., person1, person2, etc.).
 */
public class CircleGame {
	private int count, start;
	private SinglyLinkedCircularList<Integer> circle;

	public static void main(String[] args) {
		CircleGame circleGame = new CircleGame(9, 2, 1);
		circleGame.play();
	}
	
	/**
	 * CircleGame constructor.
	 * @param people the number of people in the circle
	 * @param count the count at which the current person is eliminated
	 * @param start the count starting position
	 */
	public CircleGame(int people, int count, int start) {
		this.count = count;
		this.start = start;
		
		// Create circle of people
		circle = new SinglyLinkedCircularList<Integer>();
		for(int i = 1; i <= people; i++) {
			circle.addLast(i);
		}
	}
	
	/**
	 * Iterate through the circle printing the position of the person removed when the count is reached.
	 * Prints the position of the last person in the circle and returns their position.
	 * @return the position of the last person in the circle
	 */
	public int play() {
		ListIterator<Integer> iter = circle.listIterator(start);
		Integer lastRemoved = -1;
		while(!circle.isEmpty()) {
			for(int i = 0; i < count; i++) {
				lastRemoved = iter.next();
			}
			iter.remove();
			if(!circle.isEmpty()) {
				System.out.println("Person" + lastRemoved + " eliminated.");
			} else {
				System.out.println("Person" + lastRemoved + " won.");
			}
		}
		return lastRemoved;
	}
}