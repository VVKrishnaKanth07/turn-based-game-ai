package com.game.ai.board;

import com.game.ai.enums.GameStatus;
import com.game.ai.model.GameResult;
import com.game.ai.model.Board;
import com.game.ai.model.Cell;

public class TicTacToeBoard extends Board {
    int[][] cells;

    public TicTacToeBoard() {
        cells = new int[3][3]; // 3x3 board for Tic Tac Toe
    }
    public int getCell(Cell cell) {
        return cells[cell.getRow()][cell.getCol()];
    }
    public void setCell(Cell cell, int player) {
        cells[cell.getRow()][cell.getCol()] = player;
    }
    public int[][] getCells() {
        return cells;
    }
    public GameResult isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == 0) { // Assuming 0 means empty
                    return new GameResult(GameStatus.IN_PROGRESS, null, -1, cells);
                }
            }
        }
        return new GameResult(GameStatus.DRAW, null,-1, cells);
    }
    public GameResult isComplete(int player) {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if ((cells[i][0] == player && cells[i][1] == player && cells[i][2] == player) || // Rows
                    (cells[0][i] == player && cells[1][i] == player && cells[2][i] == player)) { // Columns
                return new GameResult(GameStatus.WIN, "Player " + player + " wins!", player, cells);
            }
        }
        // Check diagonals
        if ((cells[0][0] == player && cells[1][1] == player && cells[2][2] == player) || // Main diagonal
                (cells[0][2] == player && cells[1][1] == player && cells[2][0] == player)) { // Anti diagonal
            return new GameResult(GameStatus.WIN, "Player " + player + " wins!", player, cells);
        }
        return new GameResult(GameStatus.IN_PROGRESS, "Player " + player + " inprogress!", player, cells);
    }
}
