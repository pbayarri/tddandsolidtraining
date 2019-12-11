package com.ontologypartners.training.players;

import com.ontologypartners.training.Player;

public class YellowPlayer extends Player {
	static final String myColor = "Yellow";
	static final int YELLOW_PLAYER_START = 5;
	static final int YELLOW_PLAYER_FINAL = 68;
	
	public YellowPlayer() {
		super();
		this.setColor(myColor);
	}

	@Override
	public void setAtInitialPosition() {
		this.setPositionAtBoard(YELLOW_PLAYER_START);
	}

	@Override
	public Boolean isAtInitialPosition() {
		return getPositionAtBoard() == YELLOW_PLAYER_START;
	}

	@Override
	public int getLastSquareInBoard() {
		return YELLOW_PLAYER_FINAL;
	}
	
	@Override
	public int getFirstSquareInBoard() {
		return YELLOW_PLAYER_START;
	}
	
	@Override
	public Boolean arrivesToFinalPath(int score) {
		if (getIsInFinalPath()) {
			return true;
		}
		
		if (getPositionAtBoard() + score > getLastSquareInBoard()) {
			return true;
		}
		
		return false;
	}
}
