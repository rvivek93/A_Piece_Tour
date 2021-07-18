package com.application.tour;

import java.util.logging.Logger;

import com.application.constants.BoardConstants;

public class TourInitializer {
	
	private static Logger logger = Logger.getLogger(TourInitializer.class.getName());

	private int[][] visitedBlocks;
	private int row_Position;
	private int col_Position;
	private int start_Pos_Count;
	private TourJourney journey;

	/**
	 * Initializing all the required positions and defaulting the board value to 0.
	 * 
	 * @param row_Position
	 * @param col_Position
	 * @param start_Pos_Count
	 */
	public TourInitializer(int row_Position, int col_Position, int start_Pos_Count) {
		visitedBlocks = new int[BoardConstants.UPPER_SIZE_OF_THE_BOARD][BoardConstants.UPPER_SIZE_OF_THE_BOARD];
		this.row_Position = row_Position;
		this.col_Position = col_Position;
		this.start_Pos_Count = 1;
		this.initializeBoard();
	}

	private void initializeBoard() {
		logger.info("Initializing the Board.");
		logger.info("\n");
		for (int row_pos = BoardConstants.LOWER_SIZE_OF_THE_BOARD; row_pos < BoardConstants.UPPER_SIZE_OF_THE_BOARD; row_pos++) {
			for (int col_pos = BoardConstants.LOWER_SIZE_OF_THE_BOARD; col_pos < BoardConstants.UPPER_SIZE_OF_THE_BOARD; col_pos++) {
				this.visitedBlocks[row_pos][col_pos] = BoardConstants.UNVISITED_BLOCK_VALUE;
			}
		}
		String pieceVisitedBlocks = DisplayTour.buildPieceJourney(visitedBlocks).toString();
		System.out.print(pieceVisitedBlocks);
	}

	/**
	 * Starting the journey of a Piece from the assigned position.
	 * 
	 */
	public void journeyofAPiece() {

		journey = new TourJourney();
		journey.pieceJourney(row_Position, col_Position, start_Pos_Count, visitedBlocks);
	}

	public int[][] getVisitedBlocks() {
		return visitedBlocks;
	}

}
