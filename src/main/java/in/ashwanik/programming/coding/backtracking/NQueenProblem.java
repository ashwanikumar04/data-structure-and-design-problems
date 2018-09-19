package in.ashwanik.programming.coding.backtracking;

public class NQueenProblem {
    public boolean solve(int[][] board, int numberOfQueens) {
        return solveUtil(board, 0, numberOfQueens);
    }

    private boolean solveUtil(int[][] board, int col, int numberOfQueens) {
        if (numberOfQueens > board.length) {
            return false;
        }
        if (col >= numberOfQueens) {
            return true;
        }
        for (int i = 0; i < numberOfQueens; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (solveUtil(board, col + 1, numberOfQueens)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    private boolean isSafe(int[][] board, int row, int col) {
        int length = board.length;
        for (int index = 0; index < col; index++) {
            if (board[row][index] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; j >= 0 && i >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = col; j >= 0 && i < length; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
}
