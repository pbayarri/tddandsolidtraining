package com.ontologypartners.training;

public class GreenPlayer extends Player {
	static final int PLAYER_START = 56;
	static final int PLAYER_FINAL = 51;
	
	public GreenPlayer() {
		super("green");
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
