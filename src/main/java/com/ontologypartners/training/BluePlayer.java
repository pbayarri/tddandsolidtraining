package com.ontologypartners.training;

public class BluePlayer extends Player {
	static final int PLAYER_START = 22;
	static final int PLAYER_FINAL = 17;
	
	public BluePlayer() {
		super("blue");
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
