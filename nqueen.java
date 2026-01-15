import java.util.*;

public class NQueens {
    
    // Function to check if queen can be placed at board[row][col]
    public static boolean isSafe(char[][] board, int row, int col, int n) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Check left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    // Backtracking function to place queens
    public static void solveNQueens(char[][] board, int row, List<List<String>> solutions, int n) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(new String(board[i]));
            }
            solutions.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                solveNQueens(board, row + 1, solutions, n);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    public static List<List<String>> nQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        solveNQueens(board, 0, solutions, n);
        return solutions;
    }

    public static void main(String[] args) {
        int n = 8; // 8-Queens problem
        List<List<String>> solutions = nQueens(n);
        System.out.println("Total Solutions: " + solutions.size());
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
