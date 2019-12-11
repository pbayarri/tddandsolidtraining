package com.ontologypartners.training.test;

import com.ontologypartners.training.Player;

public final class TestUtils {
	public static void setPlayerToThreeSquaresOfWin(Player player) {
		player.setIsInFinalPath(true);
		player.setPositionAtBoard(player.getLastSquareInBoard());
		player.setPositionAtFinalPath(5);
	}
}
