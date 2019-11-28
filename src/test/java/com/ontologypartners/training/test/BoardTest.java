package com.ontologypartners.training.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.ontologypartners.training.Board;
import com.ontologypartners.training.Player;

public class BoardTest {
	
	static final List<Player> players = Arrays.asList(
            new Player("yellow"),
            new Player("blue"),
            new Player("red"),
            new Player("green")
         );
	
	@Test
	public void fiveScoreCanMovePlayerAtHome() {
		Board board = new Board(players);
		assertTrue(board.canMove(players.get(0), 5));
	}
	@Test
	public void NoFiveScoreCanotnMovePlayerAtHome() {
		Board board = new Board(players);
		assertFalse(board.canMove(players.get(0), 3));
	}
}
