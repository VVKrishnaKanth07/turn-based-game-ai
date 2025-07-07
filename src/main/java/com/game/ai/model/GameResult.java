package com.game.ai.model;

import com.game.ai.enums.GameStatus;

public class GameResult {
    private GameStatus result;
    private String message;
    private int winningPlayer; // Player ID of the winning player, if applicable
    private int[][] boardState; // Current state of the board, if applicable
    public GameResult(GameStatus result, String message, int winningPlayer, int[][] boardState) {
        this.result = result;
        this.message = message;
        this.winningPlayer = winningPlayer;
        this.boardState = boardState;
    }
    public GameStatus getResult() {
        return result;
    }
    public String getMessage() {
        return message;
    }
    public int getWinningPlayer() {
        return winningPlayer;
    }
    public int[][] getBoardState() {
        return boardState;
    }
    public void setResult(GameStatus result) {
        this.result = result;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setWinningPlayer(int winningPlayer) {
        this.winningPlayer = winningPlayer;
    }
    public void setBoardState(int[][] boardState) {
        this.boardState = boardState;
    }
    @Override
    public String toString() {
        return "GameResult{" +
                "result=" + result +
                ", message='" + message + '\'' +
                ", winningPlayer=" + winningPlayer +
                ", boardState=" + java.util.Arrays.deepToString(boardState) +
                '}';
    }
}
