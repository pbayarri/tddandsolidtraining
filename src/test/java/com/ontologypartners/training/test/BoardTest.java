package com.ontologypartners.training.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.ontologypartners.training.BluePlayer;
import com.ontologypartners.training.Board;
import com.ontologypartners.training.GreenPlayer;
import com.ontologypartners.training.Player;
import com.ontologypartners.training.RedPlayer;
import com.ontologypartners.training.YellowPlayer;

public class BoardTest {
	Board board;
	Player playerAtHome;
	Player playerCloseEndOfBoard;
	Player playerCloseFinalPath;
	Player playerInRest;
	Player playerInFinalPath;
	
	public List<Player> getPlayers() {
		return Arrays.asList(playerAtHome,
				playerCloseEndOfBoard,
				playerCloseFinalPath,
				playerInRest
				);
	}
	
	public BoardTest() {
		board = new Board();
		
		playerAtHome = new RedPlayer();
		playerAtHome.setPositionAtBoard(0);
		playerCloseEndOfBoard = new GreenPlayer();
		playerCloseEndOfBoard.setPositionAtBoard(66);
		playerCloseFinalPath = new YellowPlayer();
		playerCloseFinalPath.setPositionAtBoard(65);
		playerInRest = new BluePlayer();
		playerInRest.setPositionAtBoard(68);
		playerInFinalPath = new YellowPlayer();
		playerInFinalPath.setPositionAtFinalPath(5);
	}
	
	@Test
	public void fiveScoreCanMovePlayerAtHomeTest() {
		assertTrue(board.canMove(playerAtHome, 5));
	}
	@Test
	public void noFiveScoreCannotMovePlayerAtHomeTest() {
		assertFalse(board.canMove(playerAtHome, 3));
	}
	
	@Test
	public void testMove_whenPlayerIsAtHomeAndScoreIsNotFive() {
		board.move(playerAtHome, 2, getPlayers());
		assertTrue(playerAtHome.isAtHome());
	}
	
	@Test
	public void testMove_whenPlayerIsAtHomeAndScoreIsFive() {
		board.move(playerAtHome, 5, getPlayers());
		assertEquals(playerAtHome.getInitialPosition(), playerAtHome.getPositionAtBoard());
	}
	
	@Test
	public void testMove_WhenPlayerMakesSimpleMovementOnBoard() {
		board.move(playerCloseFinalPath, 2, getPlayers());
		assertEquals(67, playerCloseFinalPath.getPositionAtBoard());
	}
	
	@Test
	public void testMove_WhenPlayerMakesMovementCrossingTheLimitOfBoard() {
		board.move(playerCloseEndOfBoard, 4, getPlayers());
		assertEquals(2, playerCloseEndOfBoard.getPositionAtBoard());
	}
	
	@Test
	public void testMove_WhenPlayerMakesMovementAndEnterInTheFinalPath() {
		board.move(playerCloseFinalPath, 5, getPlayers());
		assertTrue(playerCloseFinalPath.getIsInFinalPath());
		assertEquals(2, playerCloseFinalPath.getPositionAtFinalPath());
		assertEquals(68, playerCloseFinalPath.getPositionAtBoard());
	}
	
	@Test
	public void testMove_WhenPlayerMakesMovementInsideTheFinalPath() {
		board.move(playerInFinalPath, 1, getPlayers());
		assertEquals(68, playerInFinalPath.getPositionAtBoard());
		assertEquals(6, playerInFinalPath.getPositionAtFinalPath());
	}
	
	@Test
	public void testMove_WhenPlayerMakesMovementInsideTheFinalPathAndExceedTheFinal() {
		board.move(playerInFinalPath, 4, getPlayers());
		assertEquals(68, playerInFinalPath.getPositionAtBoard());
		assertEquals(5, playerInFinalPath.getPositionAtFinalPath());
	}
}
