package com.application.tour;

import java.util.Arrays;

import com.application.constants.BoardConstants;

public class TourPossibilities {
	
	/**
	 * Fetches the minimum next favorable position to visit for the Piece.
	 * 
	 * @param rowPos
	 * @param colPos
	 * @param visitedBlocks
	 * @return
	 */
	public int[] fetchTheMinimumAmountOfPossibilities(int rowPos, int colPos, int[][] visitedBlocks) {
		int[] nextFavourablePosition = new int[2];
		Arrays.fill(nextFavourablePosition, -1);
		
		int prevMinPossibilityCount = Integer.MAX_VALUE;
		
		for (int row_pos = 0; row_pos < BoardConstants.ROW_CONSTRAINT_MOVES.length; row_pos++) {
			int next_rowPos = rowPos + BoardConstants.ROW_CONSTRAINT_MOVES[row_pos];
			int next_colPos = colPos + BoardConstants.COL_CONSTRAINT_MOVES[row_pos];
			if (isValidMove(next_rowPos, next_colPos)
					&& visitedBlocks[next_rowPos][next_colPos] == BoardConstants.UNVISITED_BLOCK_VALUE) {
				int minPossibilityCount = fetchTheChildCount(next_rowPos, next_colPos, visitedBlocks);
				if (minPossibilityCount < prevMinPossibilityCount && minPossibilityCount > 0) {
					prevMinPossibilityCount = minPossibilityCount;

					nextFavourablePosition[0] = next_rowPos;
					nextFavourablePosition[1] = next_colPos;
				} else if (minPossibilityCount == -1) {
					nextFavourablePosition[0] = next_rowPos;
					nextFavourablePosition[1] = next_colPos;
				}
			}
		}
		return nextFavourablePosition;
	}

	/**
	 * Gets the next possibilities count for the next position so as to choose the one with the minimum degree count.
	 * 
	 * @param rowPos
	 * @param colPos
	 * @param visitedBlocks
	 * @return
	 */
	private int fetchTheChildCount(int rowPos, int colPos, int[][] visitedBlocks) {
		int possibilityCount = -1;
		for (int row_pos = 0; row_pos < BoardConstants.ROW_CONSTRAINT_MOVES.length; row_pos++) {
			int next_rowPos = rowPos + BoardConstants.ROW_CONSTRAINT_MOVES[row_pos];
			int next_colPos = colPos + BoardConstants.COL_CONSTRAINT_MOVES[row_pos];

			if (isValidMove(next_rowPos, next_colPos)
					&& visitedBlocks[next_rowPos][next_colPos] == BoardConstants.UNVISITED_BLOCK_VALUE) {
				possibilityCount++;
			}
		}
		return possibilityCount >= 0 ? possibilityCount + 1 : possibilityCount;
	}

	/**
	 * Checks if the Piece move is Valid or not.
	 * 
	 * @param rowPos
	 * @param colPos
	 * @return
	 */
	public boolean isValidMove(int rowPos, int colPos) {
		if (rowPos < BoardConstants.LOWER_SIZE_OF_THE_BOARD ||
				rowPos >= BoardConstants.UPPER_SIZE_OF_THE_BOARD || 
				colPos < BoardConstants.LOWER_SIZE_OF_THE_BOARD ||
				colPos >= BoardConstants.UPPER_SIZE_OF_THE_BOARD) {
			return false;
		}
		return true;
	}

}
