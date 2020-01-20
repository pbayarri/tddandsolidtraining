package com.ontologypartners.training;

import lombok.Getter;
import lombok.Setter;

/**
* Player class
*/
public abstract class Player {
	private static final int AT_HOME_POSITION = 0;
	
	@Getter private String color;
	@Getter @Setter private int positionAtBoard;
	@Getter private int positionAtFinalPath;
	@Getter @Setter private Boolean isInFinalPath;
	
	protected Player(String color) {
		this.color = color;
		positionAtBoard = AT_HOME_POSITION;
		positionAtFinalPath = AT_HOME_POSITION;
		isInFinalPath = false;
	}
	
	public void setPositionAtFinalPath(int position) {
		positionAtFinalPath = position; 
		setPositionAtBoard(getLastSquareInBoard());
		setIsInFinalPath(true);
	}
	
	/**
	* Is player at home
	*/
	public Boolean isAtHome() {
		return positionAtBoard == AT_HOME_POSITION;
	}
	public void kill() {
		if (!isInFinalPath) {
			positionAtBoard = AT_HOME_POSITION;
		}
	}
	public abstract int getInitialPosition();
	public abstract int getLastSquareInBoard();
	public abstract int getFirstSquareInBoard();
	
	public Boolean arrivesToFinalPath(int score) {
		if (getIsInFinalPath()) {
			return true;
		}
		if (getPositionAtBoard() > getFirstSquareInBoard())
			return false;
		
		if (getPositionAtBoard() + score > getLastSquareInBoard()) {
			return true;
		}
		
		return false;
	}
	
	public void move(int score, int finalPathMaxSquares, int boardSize) {
		if (isAtHome()) {
			moveAtHome(score);
			return;
		} 
		
		if (getIsInFinalPath() && isScoreSmallerThanFinalPathLength(score, finalPathMaxSquares)) {
			setPositionAtFinalPath(getPositionAtFinalPath() + score);
			return;
		}
		
		if (arrivesToFinalPath(score)) {
			moveWhenArriveAtFinal(score);
			return ;
		}
			
		simpleMove(score, boardSize);
	}

	private void simpleMove(int score, int boardSize) {
		setPositionAtBoard(getNewPositionAtBoard(score, boardSize));
	}

	private void moveWhenArriveAtFinal(int score) {
		int scoreInTheFinalPath = getPositionAtBoard() + score - getLastSquareInBoard();
		setPositionAtFinalPath(scoreInTheFinalPath);
	}

	private void moveAtHome(int score) {
		if (score == 5) {
			setPositionAtBoard(getInitialPosition());
		} else {
			setPositionAtBoard(0);
		}
	}

	private int getNewPositionAtBoard(int score, int boardSize) {
		int newPosition = getPositionAtBoard() + score;
		newPosition = newPosition > boardSize ? newPosition % boardSize : newPosition;
		return newPosition;
	}

	private boolean isScoreSmallerThanFinalPathLength(int score, int finalPathMaxSquares) {
		return getPositionAtFinalPath() + score <= finalPathMaxSquares;
	}
}
