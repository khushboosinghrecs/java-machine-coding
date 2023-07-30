import java.util.Scanner;

public class Tictactoe {
    private static char[][] board;
    private static char currentPlayer;
    private static String player1Name;
    private static String player2Name;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        board = new char[3][3];
        currentPlayer = 'X';

        System.out.println("Enter Player 1's name (X):");
        player1Name = scanner.nextLine();
        System.out.println("Enter Player 2's name (O):");
        player2Name = scanner.nextLine();

        initializeBoard();
        printBoard();

        while (true) {
            System.out.println("Player " + getCurrentPlayerName() + ", enter your move (row [1-3] and column [1-3]):");
            String move = scanner.nextLine();

            if (move.equalsIgnoreCase("exit")) {
                System.out.println("Game Over");
                break;
            }

            if (!makeMove(move)) {
                System.out.println("Invalid Move");
            } else {
                printBoard();

                if (checkWin()) {
                    System.out.println("Player " + getCurrentPlayerName() + " won the game");
                    break;
                }

                if (checkDraw()) {
                    System.out.println("Game Over");
                    break;
                }

                switchPlayer();
            }
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static String getCurrentPlayerName() {
        return (currentPlayer == 'X') ? player1Name : player2Name;
    }

    private static boolean makeMove(String move) {
        try {
            String[] parts = move.split(" ");
            int row = Integer.parseInt(parts[0]) - 1;
            int col = Integer.parseInt(parts[1]) - 1;

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                return true;
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
            // Invalid input format
        }

        return false;
    }

    private static boolean isValidMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            return false;
        }

        return board[row][col] == '-';
    }

    private static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true; // Check rows
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true; // Check columns
            }
        }

        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true; // Check main diagonal
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true; // Check anti-diagonal
        }

        return false;
    }

    private static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false; // If any cell is empty, the game is not a draw yet
                }
            }
        }
        return true; // All cells are filled, it's a draw
    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}
