package com.tictactoe.service;

import com.tictactoe.model.Game;
import com.tictactoe.model.Player;
import com.tictactoe.model.Status;
import com.tictactoe.model.Symbol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String name;
        int size;
        System.out.println("Welcome to tic-tac-toe game");
        System.out.print("Player1 name: ");
        name = bufferedReader.readLine();
        Player player1 = new Player(name);
        System.out.print("Player2 name: ");
        name = bufferedReader.readLine();
        Player player2 = new Player(name);
        System.out.print("Enter board size: ");
        size = Integer.parseInt(bufferedReader.readLine());
        Game game = new Game(player1, player2, size);
        Symbol currentSymbol = Symbol.CROSS;
        while (game.getStatus() == Status.UNFINISHED) {
            System.out.println("Player " + (currentSymbol == Symbol.CROSS ? "1" : "2") + " please enter row and column respectively: ");
            int row = Integer.parseInt(bufferedReader.readLine());
            int column = Integer.parseInt(bufferedReader.readLine());
            try {
                game.move(row, column, currentSymbol);
                currentSymbol = currentSymbol == Symbol.CROSS ? Symbol.CIRCLE : Symbol.CROSS;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        if (game.getStatus() == Status.TIE) {
            System.out.println("Game tied!");
        } else {
            game.setWinner(currentSymbol == Symbol.CROSS ? player1 : player2);
            System.out.println(player1.getName() + " has won the game!");
        }
    }
}
