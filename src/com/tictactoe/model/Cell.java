package com.tictactoe.model;

import java.util.UUID;

public class Cell {
    private UUID id;
    private int row;
    private int column;
    private Symbol symbol;
    private Board board;

    public Cell(UUID id, int row, int column, Board board) {
        this.id = id;
        this.row = row;
        this.column = column;
        this.symbol = null;
        this.board = board;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
