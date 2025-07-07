package com.game.ai;

import com.game.ai.board.TicTacToeBoard;
import com.game.ai.gameEngine.GameResult;
import com.game.ai.model.Board;
import com.game.ai.model.Cell;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TurnBasedGameAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurnBasedGameAiApplication.class, args);
		startGame();
	}
	private static void startGame() {
		System.out.println("Starting Turn-Based Game AI...");
		TicTacToeBoard board = new TicTacToeBoard();
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
				Cell cell = new Cell(row, col);
				cell.setValue(1);// Assuming player 1 is making the move
				board.setCell(cell);
				board.makeAIMove();
				board.printCells();
				if (board.isWinner(1).getResult() == GameResult.Result.WIN) {
					System.out.println("Player 1 wins!");
					return;
				} else 	if (board.isWinner(2).getResult() == GameResult.Result.WIN) {
					System.out.println("AI wins!");
					return;
				}else if (board.isFull().getResult() == GameResult.Result.DRAW) {
					System.out.println("The game is a draw!");
					return;
				}
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter two numbers separated by space.");
				i--; // Repeat this turn
			}
		}
	}
}
