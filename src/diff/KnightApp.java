package diff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class KnightApp {

    public static void main(String[] args) {
        Board board = new Board();

        if (board.fill(new Board.BoardPosition(2, 2)))
            board.displayBoard();
        else
            System.out.println("no solution");
    }

    private static class Board {
        private static int SIDE_SIZE = 6;
        private static int OUTER_SIDE_SIZE = 10;
        private static int BOARD_SIZE = SIDE_SIZE * SIDE_SIZE;

        private final static int[][] possibleMoves = {{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2}};

        private int[][] board = new int[OUTER_SIDE_SIZE][OUTER_SIDE_SIZE];

        private static class BoardPosition {
            private int x;
            private int y;
            private int m; // possible moves count

            BoardPosition(int x, int y, int m) {
                this.x = x;
                this.y = y;
                this.m = m;
            }

            BoardPosition(int x, int y) {
                this.x = x;
                this.y = y;
                this.m = 0;
            }
        }

        Board() {
            // fill outer positions with -1
            for (int r = 0; r < OUTER_SIDE_SIZE; r++)
                for (int c = 0; c < OUTER_SIDE_SIZE; c++)
                    if (r < 2 || r > OUTER_SIDE_SIZE - 3 || c < 2 || c > OUTER_SIDE_SIZE - 3)
                        board[r][c] = -1;
        }

        public boolean fill(BoardPosition initialPosition) {
            int step = 1;
            setPositionStep(initialPosition, step);

            return solve(initialPosition, step + 1);
        }

        private boolean solve(BoardPosition position, int step) {
            if (step > BOARD_SIZE)
                return true;

            ArrayList<BoardPosition> moves = getValidMoves(position);

            if (moves.isEmpty() && step != BOARD_SIZE)
                return false;

            // Warnsdorf's rule: proceed to the square from which the knight will have the fewest onward moves
            Collections.sort(moves, new Comparator<BoardPosition>() {
                @Override
                public int compare(BoardPosition o1, BoardPosition o2) {
                    return o1.m - o2.m;
                }
            });

            for (BoardPosition pos : moves) {
                setPositionStep(pos, step); // make move

                // find solutions from the position
                if (!orphanDetected(step, pos) && solve(pos, step + 1)) return true;

                setPositionStep(pos, 0); // reset move
            }

            return false;
        }

        private void displayBoard() {
            for (int[] row : board) {
                for (int i : row) {
                    if (i == -1) continue;
                    System.out.printf("%2d ", i);
                }
                System.out.println();
            }
        }

        private void setPositionStep(BoardPosition position, int value) {
            board[position.x][position.y] = value;
        }

        private ArrayList<BoardPosition> getValidMoves(BoardPosition position) {
            ArrayList<BoardPosition> moves = new ArrayList<BoardPosition>();

            int x, y;
            BoardPosition tmp;

            for (int[] m : possibleMoves) {
                x = position.x + m[0];
                y = position.y + m[1];
                if (board[x][y] == 0) {
                    tmp = new BoardPosition(x, y);
                    moves.add(new BoardPosition(tmp.x, tmp.y, countNeighbors(tmp)));
                }

            }

            return moves;
        }

        private int countNeighbors(BoardPosition position) {
            int num = 0;
            for (int[] m : possibleMoves)
                if (board[position.x + m[0]][position.y + m[1]] == 0)
                    num++;

            return num;
        }

        private boolean orphanDetected(int step, BoardPosition position) {
            if (step < BOARD_SIZE - 1) {
                for (BoardPosition p : getValidMoves(position))
                    if (countNeighbors(p) == 0)
                        return true;
            }

            return false;
        }
    }
}
