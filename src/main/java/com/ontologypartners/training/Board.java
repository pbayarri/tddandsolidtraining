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
		
		if (player.isAtHome()) {
			if (score == EXIT_HOME_SCORE) {
				player.setAtInitialPosition();
			} else {
				player.setPositionAtBoard(0);
			}
		} else {
			if (player.getIsInFinalPath()) {
				if (player.getPositionAtFinalPath() + score <= FINAL_PATH_SQUARES) {
					player.setPositionAtFinalPath(player.getPositionAtFinalPath() + score);
				}
			} else if (player.arrivesToFinalPath(score)) {
				int scoreInTheFinalPath = player.getPositionAtBoard() + score - player.getLastSquareInBoard();
				
				player.setPositionAtBoard(player.getLastSquareInBoard());
				player.setIsInFinalPath(true);
				player.setPositionAtFinalPath(scoreInTheFinalPath);
			} else {
				int newPosition = player.getPositionAtBoard() + score;
				newPosition = newPosition > BOARD_SQUARES ? newPosition % BOARD_SQUARES : newPosition;
				player.setPositionAtBoard(newPosition);
			}
		}		
	}
}
