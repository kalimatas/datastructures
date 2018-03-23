package diff.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MatrixPaths {
    public static void main(String[] args) {
        int[][] matrix = {
            {0, 1, 0, 0, 0},
            {0, 0, 1, 1, 1},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1},
            {0, 0, 1, 1, 0},
        };

//        int[][] easyMatrix = {
//            {0, 1, 1, 0},
//            {0, 0, 1, 1},
//            {0, 0, 0, 1},
//        };

        findRoutes(matrix, new Pos(0, 1), new Pos(3, 4));
    }

    private static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            var pos = (Pos) o;

            return x == pos.x && y == pos.y;
        }

        public static void print(Pos p) {
            System.out.printf("[%d, %d] ", p.x, p.y);
        }
    }

    private static void findRoutes(int[][] matrix, Pos start, Pos target) {
        if (matrix.length <= 0) {
            return;
        }

        if (matrix.length <= start.x || matrix.length <= target.x || matrix[0].length <= start.y || matrix[0].length <= target.y) {
            throw new RuntimeException("no fit");
        }

        var currentPath = new LinkedList<Pos>();
        currentPath.add(start);

        doFindRoute(matrix, start, target, currentPath);
    }

    private static void doFindRoute(int[][]matrix, Pos current, Pos target, LinkedList<Pos> curPath) {
        if (current.equals(target)) {
            curPath.forEach(Pos::print);
            System.out.println();

            return;
        }

        for (Pos validMove : getValidMoves(matrix, current, curPath)) {
            var currentMovePath = (LinkedList<Pos>) curPath.clone();

            currentMovePath.add(validMove);
            doFindRoute(matrix, validMove, target, currentMovePath);
        }
    }

    private static List<Pos> getValidMoves(int[][] matrix, Pos current, Queue<Pos> curPath)
    {
        ArrayList<Pos> validMoves = new ArrayList<>();
        int[][] moves = {{-1, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}};

        for (var m : moves) {
            var nextPos = new Pos(current.x + m[0], current.y + m[1]);

            if (isValidMove(matrix, nextPos, curPath)) {
                validMoves.add(nextPos);
            }
        }

        return validMoves;
    }

    private static boolean isValidMove(int[][] matrix, Pos nextPos, Queue<Pos> curPath) {
        if (curPath.contains(nextPos)) return false;
        if (nextPos.x < 0 || nextPos.x >= matrix.length) return false;
        if (nextPos.y < 0 || nextPos.y >= matrix[0].length) return false;

        return matrix[nextPos.x][nextPos.y] != 0;
    }
}
