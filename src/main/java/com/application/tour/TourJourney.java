package com.application.tour;

import java.util.logging.Logger;

import com.application.constants.BoardConstants;

public class TourJourney {

	private static Logger logger = Logger.getLogger(TourJourney.class.getName());

	private TourPossibilities possibleTours;

	public TourJourney() {
		this.possibleTours = new TourPossibilities();
	}

	/**
	 * Piece visits all the valid blocks and increments the move count.
	 * 
	 * @param row_Position
	 * @param col_Position
	 * @param start_Pos_Count
	 * @param visitedBlocks
	 * @return
	 */
	public int[][] pieceJourney(int row_Position, int col_Position, int start_Pos_Count, int[][] visitedBlocks) {

		if (!possibleTours.isValidMove(row_Position, col_Position)) {
			throw new IllegalArgumentException("Position of the Piece is invalid.");
		}

		visitedBlocks[row_Position][col_Position] = start_Pos_Count;
		if (pieceHasVisitedAllTheBlocks(start_Pos_Count + 1, row_Position, col_Position, visitedBlocks)) {
			logger.info("Displaying the Board.");
			logger.info("\n");
			String pieceVisitedBlocks = DisplayTour.buildPieceJourney(visitedBlocks).toString();
			System.out.print(pieceVisitedBlocks);
		} else {
			logger.info("No Possible Solutions Found.");
		}
		return visitedBlocks;
	}

	/**
	 * Recursive method to run all the valid possible moves of a Piece and increment the move count.
	 * 
	 * @param nextBlock
	 * @param rowPos
	 * @param colPos
	 * @param visitedBlocks
	 * @return
	 */
	private boolean pieceHasVisitedAllTheBlocks(int nextBlock, int rowPos, int colPos, int[][] visitedBlocks) {

		if (nextBlock > (BoardConstants.UPPER_SIZE_OF_THE_BOARD * BoardConstants.UPPER_SIZE_OF_THE_BOARD)) {
			logger.info("End of Tour.");
			return true;
		}

		for (int pos = 0; pos < BoardConstants.ROW_CONSTRAINT_MOVES.length; pos++) {
			
			int[] nextMinPossibility = possibleTours.fetchTheMinimumAmountOfPossibilities(rowPos, colPos,
					visitedBlocks);
			if (!possibleTours.isValidMove(nextMinPossibility[0], nextMinPossibility[1])) {
				throw new IllegalArgumentException("Tour cant be Feasible.");
			}
			visitedBlocks[nextMinPossibility[0]][nextMinPossibility[1]] = nextBlock;
			if (pieceHasVisitedAllTheBlocks(nextBlock + 1, nextMinPossibility[0], nextMinPossibility[1],
					visitedBlocks)) {
				return true;
			}
			
		}
		return false;
	}

}
