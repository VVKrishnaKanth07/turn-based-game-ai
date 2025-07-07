package com.game.ai.gameEngine;

import com.game.ai.board.TicTacToeBoard;
import com.game.ai.model.Board;
import com.game.ai.model.Move;

public class GameEngine {

    public Board startGame(String board) {
        System.out.println("Starting Game Engine...");
        if(board.equalsIgnoreCase("Tic-Tac-Toe")) {
            return new TicTacToeBoard();
        }else {
            System.out.println("Unsupported game type: " + board);
            return null;
        }
    }

    public void makeMove(Move move, Board board) {
        TicTacToeBoard ticTacToeBoard = (TicTacToeBoard) board;
        // Logic for making a move on the board
        System.out.println("Player " + move.getPlayer().getName() + " makes a move at (" + move.getCell().getRow() + ", " + move.getCell().getCol() + ")");
        if (ticTacToeBoard.getCell(move.getCell()) == 0) { // Assuming 0 means empty
            ticTacToeBoard.setCell(move.getCell(), move.getPlayer().getSymbol());
            System.out.println("Move made successfully.");
        } else {
            System.out.println("Cell is already occupied. Try another move.");
        }
    }
}
