package com.ontologypartners.training;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;

public class Board {
	static final int COMMON_SQUARES = 68;
	static final int FINAL_PATH_SQUARES = 8;
	static final List<Integer> REST_SQUARES = Arrays.asList(5, 12, 17, 22, 29, 34, 39, 46, 51, 56, 63, 68);
	
	static final int YELLOW_PLAYER_START = 5;
	static final int YELLOW_PLAYER_FINAL = 68;
	
	static final int BLUE_PLAYER_START = 22;
	static final int BLUE_PLAYER_FINAL = 17;
	
	static final int RED_PLAYER_START = 39;
	static final int RED_PLAYER_FINAL = 34;
	
	static final int GREEN_PLAYER_START = 56;
	static final int GREEN_PLAYER_FINAL = 51;
	
	private Player yellowPlayer;
	private Player bluePlayer;
	private Player redPlayer;
	private Player greenPlayer;
	
	public Board(List<Player> players) {
		if (players == null || players.size() != 4) {
			throw new InvalidParameterException("This game is only available for four players");
		}
		
		yellowPlayer = players.get(0);
		bluePlayer = players.get(1);
		redPlayer = players.get(2);
		greenPlayer = players.get(3);
	}
	
	public Boolean canMove(Player player, int score) {
		if (player.isAtHome() && score != 5)
			return false;
		if (player.getIsInFinalPath() && player.getFinalPosition() + score > FINAL_PATH_SQUARES)
			return false;
		
		return true;
	}
	
	public Boolean isWinner(Player player) {
		return player.getIsInFinalPath() && player.getFinalPosition() == FINAL_PATH_SQUARES;
	}
}
