package com.application.test.tour;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.application.tour.TourPossibilities;

public class TourPossibilityTest {

	private final TourPossibilities tourPossibility = new TourPossibilities();
	
	@Test
	public void testNextMinimumPossibility_whenPositionIsValid_thenReturnMinimumPossibiltyPosition() {
		int rowPos = 1;
		int colPos = 1;
		int[][] visitedBlocks = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				                  { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
				                  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				                  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				                  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				                  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				                  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				                  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				                  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				                  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } 
				                };

		int[][] possibilitiesOf_X1_Y1 = { { 1, 4 }, { 3, 3 }, { 4, 1 } };
		
		int[][] possibilityOf_X1_Y4 = { { 1, 7 }, { 3, 6 }, { 3, 2 }, { 4, 4 } };
		int[][] possibilityOf_X3_Y3 = { { 0, 3 }, { 3, 0 }, { 5, 1 }, { 1, 5 }, { 5, 5 } };
		int[][] possibilityOf_X4_Y1 = { { 2, 3 }, { 7, 1 }, { 6, 3 } };

		int[] expectedNextPossibility = { 4, 1 };
		int[] actualNextPossibility = tourPossibility.fetchTheMinimumAmountOfPossibilities(rowPos, colPos,
				visitedBlocks);
		assertTrue(Arrays.equals(expectedNextPossibility, actualNextPossibility));
	}
	
	@Test
	public void testIsAValidMove_ThenReturnTrue() {
		int rowPos = 4;
		int colPos = 1;
		boolean actualMove = tourPossibility.isValidMove(rowPos, colPos);
		assertTrue(actualMove);
	}
	
	@Test
	public void testIsAInValidMove_ThenReturnFalse() {
		int rowPos = -4;
		int colPos = 1;
		boolean actualMove = tourPossibility.isValidMove(rowPos, colPos);
		assertFalse(actualMove);
	}

}
