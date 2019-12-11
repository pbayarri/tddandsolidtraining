package com.ontologypartners.training;

import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

/**
* Player class
*/
public abstract class Player {
	private static final int AT_HOME_POSITION = 0;
	
	@Getter @Setter(AccessLevel.PROTECTED) private String color;
	@Getter @Setter private int positionAtBoard;
	@Getter private int positionAtFinalPath;
	@Getter @Setter(AccessLevel.PROTECTED) private Boolean isInFinalPath;
	
	public Player() {
		positionAtBoard = AT_HOME_POSITION;
		positionAtFinalPath = AT_HOME_POSITION;
		isInFinalPath = false;
	}
	
	/**
	* Is player at home
	*/
	public Boolean isAtHome() {
		return positionAtBoard == AT_HOME_POSITION;
	}
	public void kill() {
		positionAtBoard = AT_HOME_POSITION;
		positionAtFinalPath = AT_HOME_POSITION;
		isInFinalPath = false;
	}
	public abstract void setAtInitialPosition();
	public abstract Boolean isAtInitialPosition();
	public abstract int getLastSquareInBoard();
	public abstract int getFirstSquareInBoard();
	
	protected Boolean arrivesToFinalPath(int score) {
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
	
	public void move(int score, int scoreForExitFromHome, int maxFinalPathSquares, int maxBoardSquares) {
		if (isAtHome()) {
			moveAtHome(score, scoreForExitFromHome);
			return;
		}
		
		if (getIsInFinalPath() && scoreIsValidForFinalPath(score, maxFinalPathSquares)) {
			setPositionAtFinalPath(getPositionAtFinalPath() + score);
			return;
		}
		
		if (arrivesToFinalPath(score)) {
			int scoreInTheFinalPath = calculateHowManySquaresGetInsideTheFinalPath(score);
			if (scoreInTheFinalPath <= maxFinalPathSquares) {
				setPositionAtFinalPath(scoreInTheFinalPath);
			}
			return;
		}
			
		simpleMove(score, maxBoardSquares);
	}
	private void simpleMove(int score, int maxBoardSquares) {
		int newPosition = calculateNewPosition(getPositionAtBoard(), score, maxBoardSquares);;
		setPositionAtBoard(newPosition);
	}
	private int calculateNewPosition(int currentPosition, int score, int maxBoardSquares) {
		int newPosition = currentPosition + score;
		newPosition = newPosition > maxBoardSquares ? newPosition % maxBoardSquares : newPosition;
		return newPosition;
	}
	public void setPositionAtFinalPath(int scoreInTheFinalPath) {
		setPositionAtBoard(getLastSquareInBoard());
		setIsInFinalPath(true);
		positionAtFinalPath = scoreInTheFinalPath;
	}
	private int calculateHowManySquaresGetInsideTheFinalPath(int score) {
		return getPositionAtBoard() + score - getLastSquareInBoard();
	}
	private void moveAtHome(int score, int scoreForExitFromHome) {
		if (score == scoreForExitFromHome) {
			setAtInitialPosition();
		}
	}
	private Boolean scoreIsValidForFinalPath(int score, int maxFinalPathSquares) {
		return getPositionAtFinalPath() + score <= maxFinalPathSquares;
	}
	public Boolean collides(Player player) {
		if (player == this) {
			return false;
		}
		
		return getPositionAtBoard() == player.positionAtBoard;
	}
}
