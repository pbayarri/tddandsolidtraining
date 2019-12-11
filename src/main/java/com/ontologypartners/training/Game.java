package com.ontologypartners.training;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.ontologypartners.training.players.BluePlayer;
import com.ontologypartners.training.players.GreenPlayer;
import com.ontologypartners.training.players.RedPlayer;
import com.ontologypartners.training.players.YellowPlayer;

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
            new YellowPlayer(),
            new BluePlayer(),
            new RedPlayer(),
            new GreenPlayer()
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
					if (numberOfSix == 3 && !player.getIsInFinalPath()) {
						player.kill();
					} else {

						board.move(player, score, players);
						
						if (board.isWinner(player)) {
							winner = player;
						}
					}
				}
				while(score == 6 && numberOfSix != 3 && !isGameOver());
			}
		} 
		while (!isGameOver());
	}
}
