package com.application.test.tour;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.application.tour.DisplayTour;

public class DisplayTourTest {
	
	private DisplayTour displayTour;
	
	@Test
	public void testPrintBoard() {
		int[][] visitedPieceTour = { { 2, 48, 59, 17, 47, 91, 74, 44, 90, 75},
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
		String expectedPieceTour = "2	48	59	17	47	91	74	44	90	75	\n"
					  + "33	19	4	34	65	5	35	66	6	36	\n"
					  + "58	16	1	86	79	70	87	78	71	43	\n"
					  + "3	49	60	18	46	92	73	45	89	76	\n"
					  + "32	20	82	100	64	83	97	67	7	37	\n"
					  + "57	15	30	85	80	69	88	77	72	42	\n"
					  + "24	50	61	25	53	93	26	40	96	11	\n"
					  + "31	21	81	99	63	84	98	68	8	38	\n"
					  + "56	14	29	55	13	28	54	12	27	41	\n"
					  + "23	51	62	22	52	94	9	39	95	10	";
		
		String actualPieceTour = displayTour.buildPieceJourney(visitedPieceTour).toString();
		assertEquals(expectedPieceTour, actualPieceTour);
	}

}
