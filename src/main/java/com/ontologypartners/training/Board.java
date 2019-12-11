package com.ontologypartners.training;

import java.util.Arrays;
import java.util.List;

/**
* Board class
*/
public class Board {
	static final int EXIT_HOME_SCORE = 5;
	static final int BOARD_SQUARES = 68;
	static final int FINAL_PATH_SQUARES = 8;
	static final List<Integer> REST_SQUARES = Arrays.asList(5, 12, 17, 22, 29, 34, 39, 46, 51, 56, 63, 68);
	
	/**
	 * Evaluate if a player Can with this score.
	 *
	 * @deprecated use {@link #move(player, score, players)} instead.  
	 */
	@Deprecated
	public Boolean canMove(Player player, int score) {
		if (player.isAtHome() && score != EXIT_HOME_SCORE)
			return false;
		if (player.getIsInFinalPath() && player.getPositionAtFinalPath() + score > FINAL_PATH_SQUARES)
			return false;
		
		return true;
	}
	
	/**
	* Is player arrived to the win position
	*/
	public Boolean isWinner(Player player) {
		if (player == null) {
			return false;
		}
		
		return player.getIsInFinalPath() && player.getPositionAtFinalPath() == FINAL_PATH_SQUARES;
	}
	
	public void move(Player player, int score, List<Player> players) {
		player.move(score, EXIT_HOME_SCORE, FINAL_PATH_SQUARES, BOARD_SQUARES);
		
		int playerCount = 0;
		do
		{
			Player p = players.get(playerCount);
			if (canPlayerKillAnotherPlayer(player, p)) {
				p.kill();
				player.move(20, EXIT_HOME_SCORE, FINAL_PATH_SQUARES, BOARD_SQUARES);
				playerCount = 0;
			}
			else
			{
				++playerCount;
			}
		}
		while (playerCount < players.size());
	}
	
	private Boolean canPlayerKillAnotherPlayer(Player player, Player anotherPlayer) {
		return !player.isAtHome() && !player.getIsInFinalPath() && !REST_SQUARES.contains(player.getPositionAtBoard()) 
				&& player.collides(anotherPlayer);
	}
}
