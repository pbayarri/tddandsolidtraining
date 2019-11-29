package com.ontologypartners.training.players;

import com.ontologypartners.training.Player;

public class BluePlayer extends Player {
	static final String myColor = "Blue";
	static final int BLUE_PLAYER_START = 22;
	static final int BLUE_PLAYER_FINAL = 17;
	
	public BluePlayer() {
		super();
		this.setColor(myColor);
	}

	@Override
	public void setAtInitialPosition() {
		this.setPositionAtBoard(BLUE_PLAYER_START);
	}

	@Override
	public Boolean isAtInitialPosition() {
		return getPositionAtBoard() == BLUE_PLAYER_START;
	}
	
}
