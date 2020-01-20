package com.ontologypartners.training;

public class RedPlayer extends Player {
	static final int PLAYER_START = 39;
	static final int PLAYER_FINAL = 34;
	
	public RedPlayer() {
		super("red");
	}

	@Override
	public int getInitialPosition() {
		return PLAYER_START;
	}
	@Override
	public int getLastSquareInBoard() {
		return PLAYER_FINAL;
	}
	
	@Override
	public int getFirstSquareInBoard() {
		return PLAYER_START;
	}
}
