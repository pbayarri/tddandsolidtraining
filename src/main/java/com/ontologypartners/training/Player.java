package com.ontologypartners.training;

import lombok.Getter;
import lombok.Setter;

public class Player {
	private static final int AT_HOME_POSITION = 0;
	
	@Getter private String color;
	@Getter @Setter private int position;
	@Getter @Setter private int finalPosition;
	@Getter @Setter private Boolean isInFinalPath;
	
	public Player(String color) {
		this.color = color;
		position = AT_HOME_POSITION;
		finalPosition = AT_HOME_POSITION;
		isInFinalPath = false;
	}
	
	public Boolean isAtHome() {
		return position == AT_HOME_POSITION;
	}
}
