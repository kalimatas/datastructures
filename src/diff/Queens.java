package diff;

public class Queens {
    public static void main(String[] args) {
        Board board = new Board(4);
        if (!board.solve()) {
            System.out.println("No solution");
            return;
        }

        System.out.println("Solution: ");
        board.print();
    }

    private static class Board {
        private int n;
        private int[][] board;

        Board(int n) {
            this.n = n;
            board = new int[n][n];
        }

        void print() {
            for (int[] row : board) {
                for (int col : row) {
                    System.out.printf("%d ", col);
                }

                System.out.println();
            }
        }

        boolean solve() {
            return solveUtil(0);
        }

        private boolean solveUtil(int col) {
            if (col >= n) return true;

            for (int row = 0; row < n; row++) {
                if (!isSafe(row, col)) continue;

                // place
                board[row][col] = 1;

                if (solveUtil(col+1)) return true;

                // backtrack
                board[row][col] = 0;
            }

            return false;
        }

        private boolean isSafe(int row, int col) {
            // row on left side
            for (int i = 0; i < col; i++)
                if (board[row][i] == 1) return false;

            // check upper diagonal on left side
            for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
                if (board[i][j] == 1) return false;

            // check lower diagonal on left side
            for (int i = row, j = col; i < n && j >= 0; i++, j--)
                if (board[i][j] == 1) return false;

            return true;
        }
    }
}
