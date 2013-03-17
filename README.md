CS249 Project 2
============

Northern Arizona University Data Structures

Project Description: The purpose of this project is to ensure that you understand how to work with linked lists, and can use them to implement other ADTs (e.g., stack and queues) and solve non-trivial problems.

Project Submission: You should upload a zip file of your project on BBLearn. The project should contain all of your code (except IDE-specific files), a readable screen capture (or UNIX script) of your program compiling and running, and a write up. Your write-up MUST include:

* Details exactly how to execute your code to test each of the three parts
* Discusses the efficiency of each part
* Identifies anyone you collaborated* with.

*Note: Collaboration with respect to how to solve the problem is acceptable. However, you must write and comment your own code individually.

Grading: Your grade will be based on completeness and correctness (60%), design and consistent use of coding standards (e.g., formatting, comments, etc.) (30%), and the screen shot and write-up (10%).

Part A
--------

Implement a stack class based on a circular singly linked list. One should be able to push and pop
items onto the stack, just as we discussed with an array implementation of a stack.

Part B
--------

Suppose you entered a contest to be the last person remaining in a group. The way the game
works is that everyone forms a circle and individuals count off up to a certain number in
clockwise order. Once the number is reached that person is eliminated and the count begins at 1
with the next person in the circle.

Design and implement an application to help ensure you win the contest. Inputs are the number of
people in the circle, the number used for counting off, and the location where counting starts.
The output should be the location you should start in to be the last person remaining. You should
use a circular singly linked list. The output is the list of persons being eliminated, each person
should have a name representing their original position in the circle (e.g., person1, person2, etc.).

Part C
--------

Create a two-dimensional linked list to represent a matrix. Each node (except those in the top
row and those in the left column) should be pointed to by the link directly above it and by the link
on its left. Thus, you will have to update the Node class to include two pointers (e.g., right and
down)

The size of matrix should be defined by the user when the program starts. The values stored at
each location of the matrix (i.e., node) should be initialized based on the position i,j. For example,
the first node in the top left corner should have the value 00, the 1st node in the 4th row should
have the value 03 (Note: counting should start at 0). You can assume you the largest matrix
would be 10 x 10.

Your implementation should allow users to insert a specific value at a specific location, fill the
entire matrix with a given value, ask for the sum (which should provide both row and column
sums formatted at the ends of the rows and columns), and/or just display the matrix.
