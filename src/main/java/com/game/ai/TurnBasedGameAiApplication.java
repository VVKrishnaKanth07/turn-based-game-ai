package com.game.ai;

import com.game.ai.board.TicTacToeBoard;
import com.game.ai.gameEngine.GameEngine;
import com.game.ai.model.Cell;
import com.game.ai.model.Move;
import com.game.ai.model.Player;
import com.game.ai.service.AIEngineService;
import com.game.ai.util.TicTacToeBoardHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TurnBasedGameAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurnBasedGameAiApplication.class, args);
		runGame();
	}
	private static void runGame() {
		System.out.println("Starting Turn-Based Game AI...");
		GameEngine gameEngine = new GameEngine();
		TicTacToeBoard board = (TicTacToeBoard) gameEngine.startGame("Tic-Tac-Toe");
		AIEngineService aiEngineService = new AIEngineService();
		Move playerMove = new Move(new Player("Human", 1), null);
		System.out.println("Game started. You can now make moves on the Tic Tac Toe board.");
		for (int i = 0; i < 9; i++) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter your move (row and column) separated by space (0-2 for both): ");
			String input = scanner.nextLine();
			String[] parts = input.split(" ");
			try {
				int row = Integer.parseInt(parts[0]);
				int col = Integer.parseInt(parts[1]);
				if (row < 0 || row > 2 || col < 0 || col > 2) {
					System.out.println("Invalid move. Please enter values between 0 and 2.");
					i--; // Repeat this turn
					continue;
				}
				playerMove.setCell(new Cell(row, col));
				gameEngine.makeMove(playerMove, board);
				aiEngineService.makeAIMove(board);
				TicTacToeBoardHelper.printCells(board);
				System.out.println(TicTacToeBoardHelper.checkForWinner(board).getMessage());
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter two numbers separated by space.");
				i--; // Repeat this turn
			}
		}
	}
}
