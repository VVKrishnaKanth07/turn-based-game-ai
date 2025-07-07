package com.game.ai.model;

public class Cell {
    private int row;
    private int col;
    private int value; // 0 for empty, 1 for player 1, 2 for player 2

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.value = 0;
    }
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
