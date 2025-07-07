package com.game.ai.service;

import com.game.ai.board.TicTacToeBoard;
import com.game.ai.model.Board;
import com.game.ai.model.Cell;

public class AIEngineService {
    public void makeAIMove(Board board) {
        if (board == null) {
            System.out.println("Board is null. Cannot make AI move.");
            return;
        }
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard ticTacToeBoard = (TicTacToeBoard) board;
            int[][] cells = ticTacToeBoard.getCells();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (cells[i][j] == 0) {
                        ticTacToeBoard.setCell(new Cell(i, j), 2); // Assuming AI is player 2
                        return;
                    }
                }
            }
        } else {
            System.out.println("Unsupported board type for AI move.");
        }
    }
}
