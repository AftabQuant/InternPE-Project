package ConnectFourGameProject;

import java.util.Scanner;

class ConnectFourGame {
    private final String[][] board;
    private int playerTurn;
    private boolean gameWon;
    private boolean gameDraw;
    public ConnectFourGame() {
        board = new String[6][7];
        playerTurn = 1;
        gameWon = false;
        gameDraw = false;
        initializeBoard();
    }
    private void initializeBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = " - ";
            }
        }
    }

    private void displayBoard() {
        for (String[] row : board) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    private boolean isValidInput(String input) {
        try {
            int column = Integer.parseInt(input);
            return column >= 1 && column <= 7 && !isColumnFull(column - 1);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isColumnFull(int column) {
        return !board[0][column].equals(" - ");
    }

    private int getNextAvailableRow(int column) {
        for (int i = 5; i >= 0; i--) {
            if (board[i][column].equals(" - ")) {
                return i;
            }
        }
        return -1; // Should never reach here as input is validated
    }

    private void switchPlayerTurn() {
        playerTurn = (playerTurn == 1) ? 2 : 1;
    }

    private void placePiece(int column) {
        int row = getNextAvailableRow(column);
        board[row][column] = (playerTurn == 1) ? " x " : " o ";
        displayBoard();
    }

    private boolean checkForDraw() {
        for (int i = 0; i < 7; i++) {
            if (!isColumnFull(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkForWinner() {
        return checkVerticalWin() || checkHorizontalWin() || checkDiagonalWin();
    }

    private boolean checkVerticalWin() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if (board[i][j].equals(board[i + 1][j]) &&
                        board[i][j].equals(board[i + 2][j]) &&
                        board[i][j].equals(board[i + 3][j]) &&
                        !board[i][j].equals(" - ")) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkHorizontalWin() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j].equals(board[i][j + 1]) &&
                        board[i][j].equals(board[i][j + 2]) &&
                        board[i][j].equals(board[i][j + 3]) &&
                        !board[i][j].equals(" - ")) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonalWin() {
        return checkLeftDiagonalWin() || checkRightDiagonalWin();
    }

    private boolean checkLeftDiagonalWin() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j].equals(board[i + 1][j + 1]) &&
                        board[i][j].equals(board[i + 2][j + 2]) &&
                        board[i][j].equals(board[i + 3][j + 3]) &&
                        !board[i][j].equals(" - ")) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkRightDiagonalWin() {
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 7; j++) {
                if (board[i][j].equals(board[i + 1][j - 1]) &&
                        board[i][j].equals(board[i + 2][j - 2]) &&
                        board[i][j].equals(board[i + 3][j - 3]) &&
                        !board[i][j].equals(" - ")) {
                    return true;
                }
            }
        }
        return false;
    }

    private void announceResult() {
        if (gameWon) {
            System.out.println("Player " + playerTurn + " wins!");
        } else if (gameDraw) {
            System.out.println("It's a draw!");
        }
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Connect Four!");
        displayBoard();

        while (!gameWon && !gameDraw) {
            System.out.println("Player " + playerTurn + ", choose a column (1-7): ");
            String input = scanner.nextLine();

            while (!isValidInput(input)) {
                System.out.println("Invalid input. Try again.");
                input = scanner.nextLine();
            }

            int column = Integer.parseInt(input) - 1;
            placePiece(column);

            if (checkForWinner()) {
                gameWon = true;
            } else if (checkForDraw()) {
                gameDraw = true;
            } else {
                switchPlayerTurn();
            }
        }

        announceResult();
    }

    public static void main(String[] args) {
        ConnectFourGame game = new ConnectFourGame();
        game.playGame();
    }
}
