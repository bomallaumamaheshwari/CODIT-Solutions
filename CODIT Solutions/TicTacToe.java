//Task 1 >> Tic-Tac-Toe Game

import java.util.Scanner;

public class TicTacToe {

    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static final char EMPTY = '-';

    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
        currentPlayer = PLAYER_X;
    }

    public void printBoard() {
        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("---|---|---");
        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("---|---|---");
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }

    public boolean makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            return false;
        }

        if (board[row][col] != EMPTY) {
            return false;
        }

        board[row][col] = currentPlayer;
        return true;
    }

    public char checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != EMPTY) {
                return board[i][0];
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != EMPTY) {
                return board[0][i];
            }
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != EMPTY) {
            return board[0][0];
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != EMPTY) {
            return board[0][2];
        }

        return EMPTY;
    }

    public boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }

        return true;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printBoard();

            System.out.println("Player " + currentPlayer + ", enter your move (row, col): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (!makeMove(row, col)) {
                System.out.println("Invalid move. Please try again.");
                continue;
            }

            char winner = checkWinner();
            if (winner != EMPTY) {
                System.out.println("Player " + winner + " wins!");
                break;
            }

            if (isDraw()) {
                System.out.println("Draw!");
                break;
            }

            currentPlayer = currentPlayer == PLAYER_X ? PLAYER_O : PLAYER_X;
        }

        scanner.close();
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}