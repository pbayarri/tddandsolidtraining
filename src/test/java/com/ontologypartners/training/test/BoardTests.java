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

public class BoardTests {
	Player playerAtHome;
	Player playerCloseEndOfBoard;
	Player playerCloseFinalPath;
	Player playerInRest;
	
	final List<Player> players = Arrays.asList(playerAtHome,
			playerCloseEndOfBoard,
			playerCloseFinalPath,
			playerInRest
			);
	
	private Board board;
	
	public BoardTests() {
		board = new Board();
		
		playerAtHome = new RedPlayer();
		playerAtHome.setPositionAtBoard(0);
		playerCloseEndOfBoard = new GreenPlayer();
		playerCloseEndOfBoard.setPositionAtBoard(66);
		playerCloseFinalPath = new YellowPlayer();
		playerCloseFinalPath.setPositionAtBoard(65);
		playerInRest = new BluePlayer();
		playerInRest.setPositionAtBoard(68);
	}
	
	@Test
	public void testCanMove_WhenPlayerIsAtHomeAndScoreIsFive() {
		assertTrue(board.canMove(playerAtHome, 5));
	}
	@Test
	public void testCanMove_WhenPlayerIsAtHomeAndScoreIsNotFive() {
		assertFalse(board.canMove(playerAtHome, 3));
	}
	@Test
	public void testMove_WhenPlayerIsAtHomeAndScoreIsNotFive() {
		board.move(playerAtHome, 2, players);
		assertEquals(0, playerAtHome.getPositionAtBoard());
	}
	@Test
	public void testMove_WhenPlayerIsAtHomeAndScoreIsFive() {
		board.move(playerAtHome, 5, players);
		assertTrue(playerAtHome.isAtInitialPosition());
	}
	@Test
	public void testMove_WhenPlayerMakeSimpleMovementOnBoard() {
		board.move(playerCloseEndOfBoard, 2, players);
		assertEquals(68, playerCloseEndOfBoard.getPositionAtBoard());
	}
	@Test
	public void testMove_WhenPlayerMakesMovementCrossingTheLimitOfBoard() {
		board.move(playerCloseEndOfBoard, 5, players);
		assertEquals(3, playerCloseEndOfBoard.getPositionAtBoard());
	}
	@Test
	public void testMove_WhenPlayerMakesMovementAndEnterInTheFinalPath() {
		board.move(playerCloseFinalPath, 5, players);
		assertEquals(68, playerCloseFinalPath.getPositionAtBoard());
		assertTrue(playerCloseFinalPath.getIsInFinalPath());
		assertEquals(2, playerCloseFinalPath.getPositionAtFinalPath());
	}
	@Test
	public void testMove_WhenPlayerMakesMovementInsideTheFinalPath() {
		board.move(playerCloseFinalPath, 4, players);
		assertEquals(68, playerCloseFinalPath.getPositionAtBoard());
		assertTrue(playerCloseFinalPath.getIsInFinalPath());
		assertEquals(1, playerCloseFinalPath.getPositionAtFinalPath());
		
		board.move(playerCloseFinalPath, 4, players);
		assertEquals(68, playerCloseFinalPath.getPositionAtBoard());
		assertEquals(5, playerCloseFinalPath.getPositionAtFinalPath());
	}
	@Test
	public void testMove_WhenPlayerMakesMovementInsideTheFinalPathAndArrivesToFinal() {
		TestUtils.setPlayerToThreeSquaresOfWin(playerCloseFinalPath);
		
		board.move(playerCloseFinalPath, 3, players);
		assertTrue(board.isWinner(playerCloseFinalPath));
	}
	@Test
	public void testMove_WhenPlayerMakesMovementInsideTheFinalPathAndExceedTheFinal() {
		TestUtils.setPlayerToThreeSquaresOfWin(playerCloseFinalPath);
		
		int positionAtEnd = playerCloseFinalPath.getPositionAtFinalPath();
		board.move(playerCloseFinalPath, 5, players);
		assertFalse(board.isWinner(playerCloseFinalPath));
		assertEquals(positionAtEnd, playerCloseFinalPath.getPositionAtFinalPath());
		
	}
}
