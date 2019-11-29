package com.ontologypartners.training.players;

import com.ontologypartners.training.Player;

public class GreenPlayer extends Player {
	static final String myColor = "Blue";
	static final int GREEN_PLAYER_START = 56;
	static final int GREEN_PLAYER_FINAL = 51;
	
	public GreenPlayer() {
		super();
		this.setColor(myColor);
	}

	@Override
	public void setAtInitialPosition() {
		this.setPositionAtBoard(GREEN_PLAYER_START);
	}

	@Override
	public Boolean isAtInitialPosition() {
		return getPositionAtBoard() == GREEN_PLAYER_START;
	}
	
}
