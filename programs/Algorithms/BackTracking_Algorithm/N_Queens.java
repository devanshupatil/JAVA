import java.util.ArrayList;
import java.util.List;

public class N_Queens {
    public static boolean isSafe(int row, int col, char[][] Board) {

        // Horizontal
        for (int i = 0; i < Board.length; i++) {
            if (Board[row][i] == 'Q') {
                return false;
            }
        }

        // Vertical
        for (int i = 0; i < Board[0].length; i++) {

            if (Board[i][col] == 'Q') {
                return false;
            }
        }

        // Upper Left
        int r = row;

        for (int c = col; c >= 0 && r >= 0; c--, r--) {

            if (Board[r][c] == 'Q') {
                return false;
            }
        }

        // Upper Right
        r = row;

        for (int c = col; c < Board.length && r >= 0; r--, c++) {
            if (Board[r][c] == 'Q') {
                return false;
            }
        }

        // Lower Left
        r = row;

        for (int c = col; c >= 0 && r >= Board.length; r++, c--) {
            if (Board[r][c] == 'Q') {
                return false;
            }
        }

        for (int c = col; c < Board.length && r >= Board.length; c++, r++) {

            if (Board[r][c] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void SaveBoard(char[][] Board, List<List<String>> allBoards) {

        String row = "";
        List<String> newBoard = new ArrayList<>();

        for (int i = 0; i < Board.length; i++) {

            row = "";

            for (int j = 0; j < Board[0].length; j++) {

                if (Board[i][j] == 'Q') {

                    row += 'Q';

                } else {

                    row += '.';
                }
            }
            newBoard.add(row);
        }
        allBoards.add(newBoard);
    }

    public static void helper(char[][] Board, List<List<String>> allBoards, int col) {

        if (col == Board.length) {

            SaveBoard(Board, allBoards);
            return;
        }

        for (int row = 0; row < Board.length; row++) {

            if (isSafe(row, col, Board) == true) {

                Board[row][col] = 'Q';
                helper(Board, allBoards, col + 1);
                Board[row][col] = '.';
            }
        }
    }

    public static void main(String[] args) {

        int n = 5;
        List<List<String>> allBoards = new ArrayList<>();
        char[][] Board = new char[n][n];
        helper(Board, allBoards, 0);

        System.out.println("Queens are safe ");
        System.out.println(allBoards.get(Board.length - 1));

    }

}