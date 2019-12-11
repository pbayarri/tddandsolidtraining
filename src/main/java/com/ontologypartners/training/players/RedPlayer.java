package com.ontologypartners.training.players;

import com.ontologypartners.training.Player;

public class RedPlayer extends Player {
	static final String myColor = "Red";
	static final int RED_PLAYER_START = 39;
	static final int RED_PLAYER_FINAL = 34;
	
	public RedPlayer() {
		super();
		this.setColor(myColor);
	}

	@Override
	public void setAtInitialPosition() {
		this.setPositionAtBoard(RED_PLAYER_START);
	}

	@Override
	public Boolean isAtInitialPosition() {
		return getPositionAtBoard() == RED_PLAYER_START;
	}
	
	@Override
	public int getLastSquareInBoard() {
		return RED_PLAYER_FINAL;
	}
	
	@Override
	public int getFirstSquareInBoard() {
		return RED_PLAYER_START;
	}
}
