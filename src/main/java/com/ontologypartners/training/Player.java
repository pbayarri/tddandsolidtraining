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
	@Getter @Setter private int positionAtFinalPath;
	@Getter @Setter private Boolean isInFinalPath;
	
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
		if (!isInFinalPath) {
			positionAtBoard = AT_HOME_POSITION;
		}
	}
	public abstract void setAtInitialPosition();
	public abstract Boolean isAtInitialPosition();
}
