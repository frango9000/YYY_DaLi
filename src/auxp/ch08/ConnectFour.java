package auxp.ch08;

import lib.Misc.IO;

import java.util.Arrays;

public class ConnectFour {
    Board board;

    public static void main(String[] args) {
        ConnectFour c4 = new ConnectFour();
        c4.startGame();
    }

    void startGame() {
        board = new Board();
        Player p1 = Player.PLAYER1;
        Player p2 = Player.PLAYER2;

        int count = 0;
        while (board.gameOver() == null) {
            board.printBoard();
            enterColumn((count++ % 2 == 1) ? p1 : p2);
        }
        board.printBoard();
        System.out.println(
                "Game " + (board.gameOver() == ' ' ? "Tied" : "Over\n Winner is " + board.gameOver()));
    }

    void enterColumn(Player player) {
        int column = 0;
        do {
            System.out.println("Player " + player.id + " enter column to play ");
            column = IO.scanInt();
        } while (!board.isValidColumn(column));
        board.insertIntoColumn(column, player);
    }

    public enum Player {
        PLAYER1('X'),
        PLAYER2('O');
        char id;

        Player(char id) {
            this.id = id;
        }
    }

    public class Board {
        int rows;
        int cols;
        char[][] table;

        public Board() {
            this(6, 7);
        }

        public Board(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            table = new char[rows][cols];
            newBoard();
        }

        void newBoard() {
            for (int i = 0; i < table.length; i++) {
                Arrays.fill(table[i], ' ');
            }
        }

        boolean isFull() {
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[i].length; j++) {
                    if (table[i][j] == ' ') return false;
                }
            }
            return true;
        }

        void printBoard() {
            for (int i = 0; i < table.length; i++) {
                String row = "";
                for (int j = 0, k = 0; k < (table[i].length * 2) + 1; k++) {
                    if (k % 2 == 0) row += "|";
                    else row += table[i][j++];
                }
                System.out.println(row);
            }
            char[] end = new char[(table[0].length * 2) + 1];
            Arrays.fill(end, '-');
            System.out.println(end);
        }

        Character gameOver() {
            // pre-check
            if (table.length < 4 || table[0].length < 4) return null;
            if (isFull()) return ' ';
            // Rows
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[i].length - 3; j++) {
                    if (table[i][j] != ' ' & table[i][j] == table[i][j + 1]
                            && table[i][j] == table[i][j + 2]
                            && table[i][j] == table[i][j + 3]) {
                        return table[i][j];
                    }
                }
            }
            // Cols
            for (int i = 0; i < table.length - 3; i++) {
                for (int j = 0; j < table[i].length; j++) {
                    if (table[i][j] != ' ' & table[i][j] == table[i + 1][j]
                            && table[i][j] == table[i + 2][j]
                            && table[i][j] == table[i + 3][j]) {
                        return table[i][j];
                    }
                }
            }
            // Diag
            for (int i = 0; i < table.length - 3; i++) {
                for (int j = 0; j < table[i].length - 3; j++) {
                    if (table[i][j] != ' ' & table[i][j] == table[i + 1][j + 1]
                            && table[i][j] == table[i + 2][j + 2]
                            && table[i][j] == table[i + 3][j + 3]) {
                        return table[i][j];
                    }
                }
            }
            // Diag
            for (int i = 0; i < table.length - 3; i++) {
                for (int j = 3; j < table[i].length; j++) {
                    if (table[i][j] != ' ' & table[i][j] == table[i + 1][j - 1]
                            && table[i][j] == table[i + 2][j - 2]
                            && table[i][j] == table[i + 3][j - 3]) {
                        return table[i][j];
                    }
                }
            }

            return null;
        }

        boolean isValidColumn(int column) {
            if (table[0].length < column || column < 1) return false;
            return lowestRowInColumn(column) >= 0;
        }

        void insertIntoColumn(int column, Player player) {
            table[lowestRowInColumn(column)][column - 1] = player.id;
        }

        int lowestRowInColumn(int column) {
            int columnIndex = column - 1;
            int lastRow = table.length - 1;
            if (table[lastRow][columnIndex] == ' ') return lastRow;
            else
                for (int row = 0; row < table.length; row++) {
                    if (table[row][columnIndex] != ' ') return row - 1;
                }
            return -1;
        }
    }
}
