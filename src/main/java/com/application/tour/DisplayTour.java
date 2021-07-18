package com.application.tour;

import com.application.constants.BoardConstants;

public class DisplayTour {
	
	/**
	 * Used for Displaying the Piece's tour.
	 * 
	 * @param visitedBlocks
	 * @return
	 */
	public static StringBuilder buildPieceJourney(int[][] visitedBlocks) {
		StringBuilder buildPieceTour = new StringBuilder();
		for (int row_pos = BoardConstants.LOWER_SIZE_OF_THE_BOARD; row_pos < BoardConstants.UPPER_SIZE_OF_THE_BOARD; row_pos++) {
			for (int col_pos = BoardConstants.LOWER_SIZE_OF_THE_BOARD; col_pos < BoardConstants.UPPER_SIZE_OF_THE_BOARD; col_pos++) {
				buildPieceTour.append(visitedBlocks[row_pos][col_pos]);
				buildPieceTour.append("\t");
			}
			if(row_pos==BoardConstants.UPPER_SIZE_OF_THE_BOARD-1)
				continue;
			buildPieceTour.append("\n");
		}
		return buildPieceTour;
	}

}
