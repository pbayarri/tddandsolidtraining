package com.ontologypartners.training;

public class YellowPlayer extends Player {
	static final int PLAYER_START = 5;
	static final int PLAYER_FINAL = 68;
	
	public YellowPlayer() {
		super("yellow");
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
