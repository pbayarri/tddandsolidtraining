package com.ontologypartners.training;

import lombok.Getter;
import lombok.Setter;

/**
* Player class
*/
public class Player {
	private static final int AT_HOME_POSITION = 0;
	
	@Getter private String color;
	@Getter @Setter private int positionAtBoard;
	@Getter @Setter private int positionAtFinalPath;
	@Getter @Setter private Boolean isInFinalPath;
	
	public Player(String color) {
		this.color = color;
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
}
