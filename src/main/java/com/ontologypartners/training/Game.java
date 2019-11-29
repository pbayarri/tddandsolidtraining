package com.ontologypartners.training;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import lombok.Getter;

/**
* Game engine class
*/
public class Game {
	private Board board;
	private List<Player> players;
	@Getter private Player winner;
	
	/**
	* Initialize players and board
	*/
	public void prepareGame() {
		players = Arrays.asList(
            new Player("yellow"),
            new Player("blue"),
            new Player("red"),
            new Player("green")
         );
              
        board = new Board();
	}
	
	/**
	* Game ends when is a winner
	*/
	public Boolean isGameOver() {
		return winner != null;
	}
	
	/**
	* Play method with game loop
	*/
	public void play() {
		do
		{
			for (Player player : players) {
				if (isGameOver()) {
					break;
				}
				
				int numberOfSix = 0;
				int score;
				do
				{
					score = new Random().nextInt((6 - 1) + 1) + 1;
					if (score == 6) {
						++numberOfSix;
					}
					if (numberOfSix == 3) {
						player.kill();
					} else if (board.canMove(player, score)) {

   // TDD IMPLEMENT --> board.move(player, score, players);
						
						if (board.isWinner(player)) {
							winner = player;
						}
					}
				}
				while(score == 6 && numberOfSix != 3 && !isGameOver());
			}
		} 
		while (isGameOver());
	}
}
