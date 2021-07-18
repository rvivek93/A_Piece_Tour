package com.application.main;

import java.util.Scanner;
import java.util.logging.Logger;

import com.application.tour.TourInitializer;

public class TourApp {
	private static Logger logger = Logger.getLogger(TourApp.class.getName());

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		logger.info("Enter the row position: ");
		int rowPos = input.nextInt();
		logger.info("Enter the column position: ");
		int colPos = input.nextInt();
		TourInitializer pieceTour = new TourInitializer(rowPos,colPos,1);
		pieceTour.journeyofAPiece();
		
	}

}
