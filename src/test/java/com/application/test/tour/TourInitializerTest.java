package com.application.test.tour;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import com.application.tour.TourInitializer;

public class TourInitializerTest {
	
	private TourInitializer tourInitialize;
	
	@Test
	public void testInitializeBoard_beforeStartingTheTour() {
		int row_Position = 2;
	    int col_Position = 2;
		
		tourInitialize = new TourInitializer(row_Position, col_Position, 1);
		int[][] expectedInitializedBlocks = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
                	                          { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                	                          { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
                	                          { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
                	                          { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                	                          { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
                	                          { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
                	                          { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                	                          { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
                	                          { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } 
              								};
		int[][] actualInitializedBlocks = tourInitialize.getVisitedBlocks();
		assertArrayEquals(expectedInitializedBlocks, actualInitializedBlocks);
	}

}
