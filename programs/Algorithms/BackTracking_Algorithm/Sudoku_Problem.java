public class Sudoku_Problem {

    public static boolean isSafe(char[][] board, int row, int col, int number) {
        for (int i = 0; i < board.length; i++) {
            // Row
            if (board[i][col] == (char) (number + '0')) {
                return false;
            }

            // Column
            if (board[row][i] == (char) (number + '0')) {
                return false;
            }
        }

        // Grid
        int startingRow = (row / 3) * 3;
        int startingCol = (col / 3) * 3;

        for (int i = startingRow; i < startingRow + 3; i++) {
            for (int j = startingCol; j < startingCol + 3; j++) {
                if (board[i][j] == (char) (number + '0')) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean helper(char[][] board, int row, int col) {
        if (row == board.length) {
            return true;
        }

        int newRow = row;
        int newCol = col + 1;
        if (col == board.length - 1) {
            newRow = row + 1;
            newCol = 0;
        }

        if (board[row][col] != '.') {
            return helper(board, newRow, newCol);
        }

        for (int i = 1; i <= 9; i++) {
            if (isSafe(board, row, col, i)) {

                board[row][col] = (char) (i + '0');

                if (helper(board, newRow, newCol)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                { '.', '.', '8', '.', '.', '.', '.', '.', '.' },
                { '4', '9', '.', '1', '5', '7', '.', '.', '2' },
                { '.', '.', '3', '.', '.', '4', '1', '9', '.' },
                { '1', '8', '5', '.', '6', '.', '.', '2', '.' },
                { '.', '.', '.', '.', '2', '.', '.', '6', '.' },
                { '9', '6', '.', '4', '.', '5', '3', '.', '.' },
                { '.', '3', '.', '.', '7', '2', '.', '.', '4' },
                { '5', '4', '9', '.', '3', '.', '.', '5', '7' },
                { '8', '2', '7', '.', '.', '9', '.', '1', '3' }
        };

        if (helper(board, 0, 0)) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution exists");
        }
    }
}
