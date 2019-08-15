package auxp.ch08;

import lib.Misc.IO;

public class TicTacToe {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.startGame();
    }

    void startGame() {
        Board game = new Board();
        Player p1 = new Player(1);
        Player p2 = new Player(2);

        int count = 0;
        while (!game.gameOver()) {
            game.printBoard();
            playerTurn((count++ % 2 == 1) ? p1 : p2, game);
        }
        game.printBoard();
        System.out.println("Game Over");
    }

    int[] enterCoords(Player player) {
        int x = 0, y = 0;
        do {
            System.out.println("Player " + player.id + " enter coords x , y: ");
            x = IO.scanInt();
            y = IO.scanInt();
        } while (x < 1 || x > 3 || y < 1 || y > 3);
        return new int[]{x, y};
    }

    void playerTurn(Player player, Board board) {
        int[] coords = {0, 0};
        do {
            coords = enterCoords(player);
        } while (!board.validCoords(coords));
        board.markCoord(coords, player);
    }

    public class Board {
        char[][] table = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        void printBoard() {
            String line = "-------------";
            System.out.println(line);
            for (int i = 0; i < table.length; i++) {
                System.out.printf("| %c | %c | %c |%n", table[i][0], table[i][1], table[i][2]);
                System.out.println(line);
            }
        }

        boolean gameOver() {
            for (int i = 0; i < table.length; i++) {
                if (table[i][0] != ' ' && (table[i][0] == table[i][1] && table[i][1] == table[i][2])) {
                    return true;
                }
            }
            for (int i = 0; i < table.length; i++) {
                if (table[0][i] != ' ' && (table[0][i] == table[1][i] && table[1][i] == table[2][i])) {
                    return true;
                }
            }
            if (table[0][0] != ' ' && (table[0][0] == table[1][1] && table[1][1] == table[2][2])) {
                return true;
            } else if (table[0][2] != ' ' && (table[0][2] == table[1][1] && table[1][1] == table[2][0])) {
                return true;
            } else
                return (table[0][0] != ' '
                        && table[0][1] != ' '
                        && table[0][2] != ' '
                        && table[1][0] != ' '
                        && table[1][1] != ' '
                        && table[1][2] != ' '
                        && table[2][0] != ' '
                        && table[2][1] != ' '
                        && table[2][2] != ' ');
        }

        boolean validCoords(int[] coords) {
            return (table[coords[0] - 1][coords[1] - 1] == ' ');
        }

        void markCoord(int[] coords, Player player) {
            table[coords[0] - 1][coords[1] - 1] = player.id;
        }
    }

    public class Player {
        char id;

        public Player(int num) {
            id = (num == 1) ? 'X' : 'O';
        }
    }
}
