package com.ontologypartners.training;

import java.util.Arrays;
import java.util.List;

/**
* Board class
*/
public class Board {
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
		if (player.isAtHome() && score != 5)
			return false;
		if (player.getIsInFinalPath() && player.getPositionAtFinalPath() + score > FINAL_PATH_SQUARES)
			return false;
		
		return true;
	}
	
	/**
	* Is player arrive to the win position
	*/
	public Boolean isWinner(Player player) {
		if (player == null) {
			return false;
		}
		
		return player.getIsInFinalPath() && player.getPositionAtFinalPath() == FINAL_PATH_SQUARES;
	}
	
	public void move(Player player, int score, List<Player> players) {
		if (score == 5) {
			player.setAtInitialPosition();
		} else {
			player.setPositionAtBoard(0);
		}
	}
}
