package com.ontologypartners.training;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import lombok.Getter;

public class Game {
	private Board board;
	private List<Player> players;
	@Getter private Player winner;
	
	public void prepareGame() {
		players = Arrays.asList(
            new Player("yellow"),
            new Player("blue"),
            new Player("red"),
            new Player("green")
         );
              
        board = new Board(players);
	}
	
	public Boolean isGameOver() {
		return winner != null;
	}
	
	public void play() {
		do
		{
			for (Player player : players) {
				int score = new Random().nextInt((6 - 1) + 1) + 1;
				if (board.canMove(player, score)) {
					
					//board.move(player, score);
					
					if (board.isWinner(player)) {
						winner = player;
						break;
					}
				}
			}
		} 
		while (isGameOver());
	}
}
