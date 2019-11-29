package com.ontologypartners.training.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.ontologypartners.training.Board;
import com.ontologypartners.training.Player;
import com.ontologypartners.training.players.BluePlayer;
import com.ontologypartners.training.players.GreenPlayer;
import com.ontologypartners.training.players.RedPlayer;
import com.ontologypartners.training.players.YellowPlayer;

public class BoardTest {
	static final Player playerAtHome = new RedPlayer();
	static final Player playerCloseEndOfBoard = new GreenPlayer();
	static final Player playerCloseFinalPath = new YellowPlayer();
	static final Player playerInRest = new BluePlayer();
	
	static final List<Player> players = Arrays.asList(playerAtHome,
			playerCloseEndOfBoard,
			playerCloseFinalPath,
			playerInRest
			);
	
	public BoardTest() {
		playerAtHome.setPositionAtBoard(0);
		playerCloseEndOfBoard.setPositionAtBoard(66);
		playerCloseFinalPath.setPositionAtBoard(65);
		playerInRest.setPositionAtBoard(68);
	}
	
	@Test
	public void fiveScoreCanMovePlayerAtHomeTest() {
		Board board = new Board();
		assertTrue(board.canMove(playerAtHome, 5));
	}
	@Test
	public void noFiveScoreCannotMovePlayerAtHomeTest() {
		Board board = new Board();
		assertFalse(board.canMove(playerAtHome, 3));
	}
	@Test
	public void playerAtHomeNoMovementIfNoFiveScore() {
		Board board = new Board();
		board.move(playerAtHome, 2, players);
		assertEquals(0, playerAtHome.getPositionAtBoard());
	}
	@Test
	public void playerAtHomeStartsWithFiveScore() {
		Board board = new Board();
		board.move(playerAtHome, 5, players);
		assertTrue(playerAtHome.isAtInitialPosition());
	}
}
