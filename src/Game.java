
public class Game {
    /*
     * In this game, player one will be represented by the number 1
     * and player two will be represented by the number 2 in the grid.
     * 0 means it is empty and has not been played yet.
     */
    // global variables
    private int[][] grid = new int[3][3];

    // constructor
    public Game() {
    }

    // function to check if the game is over
    public int isEnd() {
        /*
         * this function will return -1 if the game is not over
         * it will return 0 if the game is a tie
         * it will return 1 if player one wins
         * it will return 2 if player two wins
         */
        for (int i = 1; i <= 2; i++) {
            if (isWin(i)) {
                return i;
            }
        }
        if (isFull()) {
            return 0;
        }
        return -1;
    }

    // helper function to help check if the specific player wins
    public boolean isWin(int player) {
        // return true if player wins
        // return false if player does not win

        // check horizontal
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == player && grid[i][1] == player && grid[i][2] == player) {
                return true;
            }
        }

        // check vertical
        for (int i = 0; i < 3; i++) {
            if (grid[0][i] == player && grid[1][i] == player && grid[2][i] == player) {
                return true;
            }
        }

        // check diagonal
        if (grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) {
            return true;
        }
        if (grid[0][2] == player && grid[1][1] == player && grid[2][0] == player) {
            return true;
        }

        return false;
    }

    // function to check if the grid is full
    public boolean isFull() {
        // return true if the grid is full
        // return false if the grid is not full
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; i++) {
                if (grid[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // function to draw the grid
    public void drawGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    System.out.print(" ");
                } else if (grid[i][j] == 1) {
                    System.out.print("X");
                } else if (grid[i][j] == 2) {
                    System.out.print("O");
                }
                if (j != grid[i].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i != grid.length - 1) {
                System.out.println("-----");
            }
        }
    }

    /*
     * function to translate number 1 to 9 into row and column
     */
    public int[] cellToRnC(int num) {
        int[] result = new int[2];
        // result[0] is the row, result[1] is the column
        result[0] = (num - 1) / 3;
        result[1] = (num - 1) % 3;
        return result;
    }

    // function to take input from players
    // player choose by cell number and the grid will be updated
    public void takeInput(int player, int cell) {
        int[] rnc = cellToRnC(cell);
        grid[rnc[0]][rnc[1]] = player;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.drawGrid();
    }
}