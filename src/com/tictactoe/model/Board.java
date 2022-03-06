package com.tictactoe.model;

import java.util.UUID;

public class Board {
    private UUID id;
    private int size;
    private Cell[][] cells;
    public Board(int size) {
        this.id = UUID.randomUUID();
        this.size = size;
        this.cells = new Cell[size][size];
        for(int row = 0; row < size; row += 1) {
            for(int column = 0; column < size; column += 1) {
                this.cells[row][column] = new Cell(UUID.randomUUID(), row, column, this);
            }
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public boolean isFilled() {
        for(int row = 0; row < size; row += 1) {
            for(int column = 0; column < size; column += 1) {
                if(cells[row][column].getSymbol() != null) {
                    return false;
                }
            }
        }
        return true;
    }
}
