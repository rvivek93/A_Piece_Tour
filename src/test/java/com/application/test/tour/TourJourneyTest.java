package com.application.test.tour;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.application.tour.TourJourney;

public class TourJourneyTest {

	private final TourJourney journey = new TourJourney();
	
	@Test
	public void testPieceJourney_whenStartingPositionIsInvalid_shouldThrowException() {

		int row_Position = -1;
		int col_Position = 2;
		int[][] visitedBlocks = new int[10][10];

		Throwable exception = assertThrows(IllegalArgumentException.class,
				() -> journey.pieceJourney(row_Position, col_Position, 1, visitedBlocks));
		assertEquals(exception.getMessage(), "Position of the Piece is invalid.");
	}

	@Test
	public void testPieceJourney_whenStartingPositionIsValidButCantCompleteTheTour_shouldThrowException() {
		int row_Position = 2;
		int col_Position = 3;
		int[][] visitedBlocks = new int[10][10];

		Throwable exception = assertThrows(IllegalArgumentException.class,
				() -> journey.pieceJourney(row_Position, col_Position, 1, visitedBlocks));
		assertEquals(exception.getMessage(), "Tour cant be Feasible.");
	}

	@Test
	public void testPieceJourney_givenWithValidPosition_TourShouldHaveBeenSuccessfullyCompletedByVisitingAllBlocks_1() {
		int row_Position = 2;
		int col_Position = 2;
		int[][] visitedBlocks = new int[10][10];
		int[][] expectedPieceTour = { { 2, 48, 59, 17, 47, 91, 74, 44, 90, 75},
									  { 33, 19, 4, 34, 65, 5, 35, 66, 6, 36}, 
									  { 58, 16, 1, 86, 79, 70, 87, 78, 71, 43},
				                      { 3, 49, 60, 18, 46, 92, 73, 45, 89, 76}, 
				                      { 32, 20, 82, 100, 64, 83, 97, 67, 7, 37},
				                      { 57, 15, 30, 85, 80, 69, 88, 77, 72, 42}, 
				                      { 24, 50, 61, 25, 53, 93, 26, 40, 96, 11},
				                      { 31, 21, 81, 99, 63, 84, 98, 68, 8, 38}, 
				                      { 56, 14, 29, 55, 13, 28, 54, 12, 27, 41},
				                      { 23, 51, 62, 22, 52, 94, 9, 39, 95, 10} 
				                    };

		int[][] actualPieceJourney = journey.pieceJourney(row_Position, col_Position, 1, visitedBlocks);
		assertTrue(Arrays.deepEquals(expectedPieceTour, actualPieceJourney));
	}
	
	@Test
	public void testPieceJourney_givenWithValidPosition_TourShouldHaveBeenSuccessfullyCompletedByVisitingAllBlocks_2() {
		int row_Position = 7;
		int col_Position = 2;
		int[][] visitedBlocks = new int[10][10];
		int[][] expectedPieceTour = { {23,	51,	72,	22,	52,	71,	9,	39,	70,	10},	
									  {56,	14,	29,	55,	13,	28,	54,	12,	27,	41},	
									  {31,	21,	60,	76,	73,	61,	81,	74,	8,	38},	
									  {24,	50,	94,	25,	53,	95,	26,	40,	69,	11},	
									  {57,	15,	30,	64,	92,	75,	65,	91,	80,	42},	
									  {32,	20,	59,	77,	99,	62,	82,	98,	7,	37},	
									  {3,	49,	93,	18,	46,	96,	89,	45,	68,	90},	
									  {58,	16,	1,	63,	83,	78,	66,	86,	79,	43},	
									  {33,	19,	4,  34,	100, 5,	35,	97,	6,	36},	
									  {2,	48,	84,	17,	47,	85,	88,	44,	67,	87}
								  };
				                   

		int[][] actualPieceJourney = journey.pieceJourney(row_Position, col_Position, 1, visitedBlocks);
		assertTrue(Arrays.deepEquals(expectedPieceTour, actualPieceJourney));
	}
	
	@Test
	public void testPieceJourney_givenWithValidPosition_TourShouldHaveBeenSuccessfullyCompletedByVisitingAllBlocks_3() {
		int row_Position = 6;
		int col_Position = 6;
		int[][] visitedBlocks = new int[10][10];
		int[][] expectedPieceTour = { {50,	21,	91,	49,	20,	90,	5,	19,	44,	6},	
									  {32,	55,	52,	31,	15,	53,	30,	16,	13,	29},	
									  {98,	79,	47,	99,	80,	48,	45,	81,	4,	18},	
									  {51,	22,	92,	54,	64,	89,	14,	65,	43,	7},	
									  {33,	56,	72,	40,	46,	82,	41,	17,	12,	28},	
									  {97,	78,	67,	100,	85,	66,	63,	88,	3, 60},	
									  {73,	23,	93,	76,	71,	94,	1,	70,	42,	8},	
									  {34,	57,	84,	39,	58,	83,	38,	59,	11,	27},	
									  {96,	77,	68,	95,	86,	69,	62,	87,	2,	61},	
									  {74,	24,	35,	75,	25,	36,	10,	26,	37,	9}	
								   };
				                   

		int[][] actualPieceJourney = journey.pieceJourney(row_Position, col_Position, 1, visitedBlocks);
		assertTrue(Arrays.deepEquals(expectedPieceTour, actualPieceJourney));
	}

}
