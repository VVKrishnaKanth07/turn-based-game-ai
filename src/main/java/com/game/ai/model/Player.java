package com.game.ai.model;

public class Player {
    String name; // e.g., "Player 1" or "AI"
    int symbol; // e.g., "X" or "O" for Tic Tac Toe

    public Player(String name, int symbol) {
        this.name = name;
        this.symbol = symbol;
    }
    public String getName() {
        return name;
    }
    public int getSymbol() {
        return symbol;
    }
}
