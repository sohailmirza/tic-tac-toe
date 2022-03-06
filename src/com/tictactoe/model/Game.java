package com.tictactoe.model;

import com.tictactoe.exception.AlreadyOccupiedException;
import com.tictactoe.exception.InvalidMoveException;

import java.util.UUID;

public class Game {
    private UUID id;
    private Player player1;
    private Player player2;
    private Board board;
    private Status status;
    private Player winner;
    public Game(Player player1, Player player2, int size) {
        this.id = UUID.randomUUID();
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board(size);
        this.status = Status.UNFINISHED;
    }

    public void move(int row, int column, Symbol symbol) throws AlreadyOccupiedException, InvalidMoveException {
        if (row < 0 || column < 0 || row >= board.getSize() || column >= board.getSize()) {
            throw new InvalidMoveException("Row " + row + " Column " + column + " is invalid");
        }
        if (board.getCells()[row][column].getSymbol() != null) {
            throw new AlreadyOccupiedException("Row " + row + " Column " + column + " is already occupied");
        }
        board.getCells()[row][column].setSymbol(symbol);
        if (isRowMatch(row, symbol) || isColumnMatch(column, symbol) || isLeftToRightDiagonalMatch(symbol)
                || isRightToLeftDiagonalMatch(symbol)) {
            status = Status.FINISHED;
        } else if (board.isFilled()) {
            status = Status.TIE;
        }
    }

    private boolean isRowMatch(int row, Symbol symbol) {
        for (int column = 0; column < board.getSize(); column += 1) {
            if(board.getCells()[row][column].getSymbol() != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean isColumnMatch(int column, Symbol symbol) {
        for (int row = 0; row < board.getSize(); row += 1) {
            if(board.getCells()[row][column].getSymbol() != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean isLeftToRightDiagonalMatch(Symbol symbol) {
        for (int index = 0; index < board.getSize(); index += 1) {
            if(board.getCells()[index][index].getSymbol() != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean isRightToLeftDiagonalMatch(Symbol symbol) {
        for (int index = 0; index < board.getSize(); index += 1) {
            if(board.getCells()[index][board.getSize() - 1 - index].getSymbol() != symbol) {
                return false;
            }
        }
        return true;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
