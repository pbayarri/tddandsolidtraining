package com.ontologypartners.training;

/**
* Entry point for Parcheesi console application
*/
public class ParcheesiConsoleMain {

	public static void main(String[] args) {
		System.out.println("Parcheesi game start...");
		Game game = new Game();
		game.prepareGame();
		game.play();
		System.out.println("Parcheesi game ends.");
		System.out.println(game.getWinner().getColor() + " wins the game!!!");
	}
}
