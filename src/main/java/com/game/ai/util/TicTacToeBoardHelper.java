package com.game.ai.util;

import com.game.ai.enums.GameStatus;
import com.game.ai.board.TicTacToeBoard;
import com.game.ai.model.GameResult;
import com.game.ai.model.Board;

public class TicTacToeBoardHelper {
    public static void printCells(Board board) {
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard ticTacToeBoard = (TicTacToeBoard) board;
            int[][] cells = ticTacToeBoard.getCells();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(cells[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
    public static GameResult checkForWinner(Board board) {
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard ticTacToeBoard = (TicTacToeBoard) board;
            System.out.println("Checking for winner...");
            if (ticTacToeBoard.isComplete(1).getResult() == GameStatus.WIN) {
                return new GameResult(GameStatus.WIN, "Player 1 wins!", 1, ticTacToeBoard.getCells());
            } else 	if (ticTacToeBoard.isComplete(2).getResult() == GameStatus.WIN) {
                return new GameResult(GameStatus.WIN, "AI wins!", 1, ticTacToeBoard.getCells());
            }else if (ticTacToeBoard.isFull().getResult() == GameStatus.DRAW) {
                return new GameResult(GameStatus.DRAW, "Game is draw", 1, ticTacToeBoard.getCells());
            }
        } else {
            System.out.println("Unsupported board type for checking winner.");
        }
        return new GameResult(GameStatus.IN_PROGRESS, "Game is still in progress", -1, null);
    }
}