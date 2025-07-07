package com.game.ai.model;

public class Player {
    String name; // e.g., "Player 1" or "AI"
    String symbol; // e.g., "X" or "O" for Tic Tac Toe

    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }
    public String getName() {
        return name;
    }
    public String getSymbol() {
        return symbol;
    }
}
