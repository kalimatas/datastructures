package diff;

import linkedlist.LinkedList;
import stackqueue.StackArray;

import java.io.IOException;
import java.io.InputStreamReader;

public class KnightApp {

    public static void main(String[] args) throws IOException {
        new Board().fill(new Board.BoardPosition(0, 0));
    }

    private static class Board {
        private static int SIDE_SIZE = 5;
        private static int BOARD_SIZE = SIDE_SIZE * SIDE_SIZE;

        private static int VISITED = 1;
        private static int UNVISITED = 0;

        private int[][] board = new int[SIDE_SIZE][SIDE_SIZE];
        private int size = 0;
        StackArray<BoardPosition> stack = new StackArray<BoardPosition>(500);

        private InputStreamReader reader = new InputStreamReader(System.in);

        private static class BoardPosition {
            private int x;
            private int y;

            BoardPosition(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public boolean fill(BoardPosition current) throws IOException {
            System.out.printf("current: %d:%d, stack size: %d\n", current.x, current.y, stack.size());

            stack.push(current);
            setVisited(current, VISITED);

            if (size == BOARD_SIZE) {
                return true;
            } else {
                displayBoard();
                //waitPress();

                LinkedList<BoardPosition> validMoves = getValidMoves(current);
                if (validMoves.isEmpty()) {
                    setVisited(stack.peek(), UNVISITED);
                    stack.pop();
                } else {
                    while (!validMoves.isEmpty()) {
                        return fill(validMoves.deleteFirst());
                    }
                }

                return false;
            }
        }

        private void waitPress() throws IOException {
            reader.read();
        }

        private void displayBoard() {
            for (int i = 0; i < SIDE_SIZE; i++) {
                for (int j = 0; j < SIDE_SIZE; j++)
                    System.out.printf("%d ", board[i][j]);

                System.out.println();
            }
            System.out.println();
        }

        private void setVisited(BoardPosition position, int value) {
            board[position.x][position.y] = value;
            if (value > 0)  ++size;
            else            --size;
        }

        private LinkedList<BoardPosition> getValidMoves(BoardPosition current) {
            LinkedList<BoardPosition> moves = new LinkedList<BoardPosition>();

            int x, y;

            // left upper
            x = current.x - 1;
            y = current.y - 2;
            if (x >= 0 && y >= 0 && board[x][y] == 0) {
                moves.insertFirst(new BoardPosition(x, y));
            }

            x = current.x - 2;
            y = current.y - 1;
            if (x >= 0 && y >= 0 && board[x][y] == 0) {
                moves.insertFirst(new BoardPosition(x, y));
            }

            // left bottom
            x = current.x + 1;
            y = current.y - 2;
            if (x < SIDE_SIZE && y >= 0 && board[x][y] == 0) {
                moves.insertFirst(new BoardPosition(x, y));
            }

            x = current.x + 2;
            y = current.y - 1;
            if (x < SIDE_SIZE && y >= 0 && board[x][y] == 0) {
                moves.insertFirst(new BoardPosition(x, y));
            }

            // right upper
            x = current.x - 1;
            y = current.y + 2;
            if (x >= 0 && y < SIDE_SIZE && board[x][y] == 0) {
                moves.insertFirst(new BoardPosition(x, y));
            }

            x = current.x - 2;
            y = current.y + 1;
            if (x >= 0 && y < SIDE_SIZE && board[x][y] == 0) {
                moves.insertFirst(new BoardPosition(x, y));
            }

            // right bottom
            x = current.x + 1;
            y = current.y + 2;
            if (x < SIDE_SIZE && y < SIDE_SIZE && board[x][y] == 0) {
                moves.insertFirst(new BoardPosition(x, y));
            }

            x = current.x + 2;
            y = current.y + 1;
            if (x < SIDE_SIZE && y < SIDE_SIZE && board[x][y] == 0) {
                moves.insertFirst(new BoardPosition(x, y));
            }

            return moves;
        }
    }
}
