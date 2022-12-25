import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
    int rows;
    int columns;
    int mines;
    String[][] board;
    String[][] minesBoard;

    Minesweeper(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.board = new String[rows][columns];
        this.minesBoard = new String[rows][columns];
        this.mines = (rows * columns) / 4;
    }

    public void fillBoard() {
        Random rand = new Random();
        int randRow;
        int randColumn;

        for (int i = 0; i < mines; i++) {
            randRow = rand.nextInt(rows);
            randColumn = rand.nextInt(columns);
            if (minesBoard[randRow][randColumn] != "*") {
                minesBoard[randRow][randColumn] = "*";
            } else {
                i--;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = "-";
                if (minesBoard[i][j] != "*") {
                    minesBoard[i][j] = "-";
                }
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("*********************************");
    }

    public void printMinesBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(minesBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("*********************************");
    }

    public void play() {
        Scanner input = new Scanner(System.in);
        int row, col;
        int moveCount = ((rows * columns) - mines);
        fillBoard();
        System.out.println("Minesweeper");
        printBoard();

        while (moveCount > 0) {
            System.out.print("Enter Row : ");
            row = input.nextInt();
            System.out.print("Enter Column : ");
            col = input.nextInt();

            if ((row < 0 || row >= rows) || (col < 0 || col >= columns)) {
                System.out.println("Wrong Move..!");
                continue;
            }
            if (minesBoard[row][col] == "*") {
                System.out.println("Game Over");
                printMinesBoard();
                break;
            } else {
                if (board[row][col] != "-") {
                    System.out.println("This Move Already Done..!");
                } else {
                    int mineCounter = 0;
                    if (minesBoard[row][col] != "*") {
                        if (row != 0) {
                            if (minesBoard[row - 1][col] == "*") {
                                mineCounter++;
                            }
                            if (col != 0) {
                                if (minesBoard[row - 1][col - 1] == "*") {
                                    mineCounter++;
                                }
                            }
                        }
                        if (row != rows - 1) {
                            if (minesBoard[row + 1][col] == "*")
                                mineCounter++;
                            if (col != columns - 1) {
                                if (minesBoard[row + 1][col + 1] == "*") {
                                    mineCounter++;
                                }
                            }
                        }
                        if (col != 0) {
                            if (minesBoard[row][col - 1] == "*")
                                mineCounter++;
                            if (row != rows - 1) {
                                if (minesBoard[row + 1][col - 1] == "*") {
                                    mineCounter++;
                                }
                            }
                        }
                        if (col != columns - 1) {
                            if (minesBoard[row][col + 1] == "*")
                                mineCounter++;
                            if (row != 0) {
                                if (minesBoard[row - 1][col + 1] == "*") {
                                    mineCounter++;
                                }
                            }
                        }
                        board[row][col] = Integer.toString(mineCounter);
                    }
                }
            }
            moveCount--;
            printBoard();
        }
        if (moveCount == 0) {
            System.out.println("You Won The Game");
        }
        input.close();
    }
}
