# A_Piece_Tour

# Problem:
Implement an algorithm that finds atleast one tour for a Chess Piece on a 10X10 Chessboard. A tour is a path for a Piece to visit all tiles on the board.
Constraints:
- The Piece can move 3 spaces either North, East, South or West.
- The Piece can move 2 spaces diagonally, i.e. NorthEast, SouthEast, NorthWest or SouthWest.
- Each space can only be visited once.

# Implementation:
Used Warnsdorff's rule in implementing the algorithm as the backtracking algorithm was taking long time for the boards with size greater than 6.

# Algorithm:
1. Initialize the board(10X10) with 0(NOT_VISITED).
2. Get the start position of a Piece and set the move count to 1(VISITED).
3. Implemented an Recursive function to iterate over the 8 possible constraint moves to find the next possible block.
   1. For each recursive call the warnsdorff's rule is applied to find the next favourable position.
   
      Rule:
      
      1. For each position P(X,Y) find the next all possible moves that a Piece can do.
      2. For each valid moves for the position P(X,Y), get the count of its next possible moves.
      3. Keep a track of the count and whenever a minimum next possible move count is encounterd, replace it.
      4. Get the position of the least possible move the Piece can make and assign it as the next move.
      5. Follow, the same until the tour is complete.
      
      Edge Cases:
      
      1. For the last element(i.e. 100) as per the above rule there wont be any next possible moves found.
      2. In such case, take the current position as the next possible position and assign the move count.
      3. In case, if there are no possible moves anymore for the next move and if the element is not the last element, then throw an exception saying "Tour cant be Feasible."
4. Once, the Tour is complete call the Display board function to print the board.

# Exceptions:
1. If the start position of P(X,Y) is invalid then throw, "Position is not Valid." and end the tour.
2. If the Tour cant be feasible due to no more avaialble next moves then throw, "Tour cant be Feasible."

# Test Case Scenarios
1. Implemented Test case to throw an exception when the given start position(X,Y) is invalid.
2. Implemented Test case to throw an exception when the tour cant be feasible or completed.
3. Implemented Test case to initialize the board before tour starts.
4. Implemented Test case to find all the possible moves of a Piece and complete the tour for different positions.
5. Implemented Test case to find the next minimum favorable position for the Piece to move.
6. Implemented Test case to validate if the next move is Valid or not.
7. Implemented Test case to display the board once the tour is completed with appropriate spacings.

# Build And Deploy
Instructions in running the Maven project locally.

# Prerequisites
1. Install Java 8.
2. Install Maven 3.6.

# Building the Project
1. Open CMD-PROMPT and switch the directory to the project, like C:/users/Java8/PieceTour.
2. Run mvn clean install
3. Build and Tests will run.

# Running the Project
1. Now switch to Target folder, like like C:/users/Java8/PieceTour/target.
2. Run java -jar PieceTour-0.0.1-SNAPSHOT.jar
3. Provide the starting position of the Piece(Row).
4. Provide the position of the Piece(Column).

![image](https://user-images.githubusercontent.com/67907069/126057098-af2c145d-d3a7-499b-874d-6d656e8ca354.png)

# Sample Output
![image](https://user-images.githubusercontent.com/67907069/126057140-d0d9d290-7340-4797-8f28-bae5ed9b7f9a.png)

# Author
  Vivek Rajendran

