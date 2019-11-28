package com.ontologypartners.training;

public class ParchisConsoleMain {

	public static void main(String[] args) {
		System.out.println("Parchis game start...");
		Game game = new Game();
		game.prepareGame();
		game.play();
		System.out.println("Parchis game ends.");
		System.out.println(game.getWinner().getColor() + " wins the game!!!");
	}
}
