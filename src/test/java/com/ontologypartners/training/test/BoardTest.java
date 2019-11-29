package com.ontologypartners.training.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ontologypartners.training.Board;
import com.ontologypartners.training.Player;

public class BoardTest {
	static final Player playerAtHome = new Player("red");
	
	@Test
	public void fiveScoreCanMovePlayerAtHomeTest() {
		Board board = new Board();
		assertTrue(board.canMove(playerAtHome, 5));
	}
	@Test
	public void NoFiveScoreCannotMovePlayerAtHomeTest() {
		Board board = new Board();
		assertFalse(board.canMove(playerAtHome, 3));
	}
}
