package diff.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class PathToDestinationBFS {
    private static int DESTINATION = 9;

    public static void main(String[] args) {
        //List<List<Integer>> g = Arrays.asList(
        //        Arrays.asList(1, 0, 0),
        //        Arrays.asList(1, 0, 0),
        //        Arrays.asList(1, 9, 1));

        List<List<Integer>> g = Arrays.asList(
                Arrays.asList(1, 1, 1, 1),
                Arrays.asList(0, 1, 1, 1),
                Arrays.asList(0, 1, 0, 1),
                Arrays.asList(1, 1, 9, 1),
                Arrays.asList(0, 0, 1, 1));

        int d = minimumDistance(5, 4, g);
        System.out.println(d);
    }

    static int minimumDistance(int numRows, int numColumns, List<List<Integer>> area) {
        boolean[][] visited = markeVisited(numRows, numColumns, area);

        Cell departure = new Cell(0, 0, 0);
        visited[departure.row][departure.col] = true;

        Queue<Cell> queue = new ArrayDeque<>();
        queue.add(departure);

        while (!queue.isEmpty()) {
            Cell currentCell = queue.poll();
            if (hasReachedDestination(currentCell, area)) {
                return currentCell.dist;
            }

            // up
            Cell upCell = new Cell(currentCell.row - 1, currentCell.col, currentCell.dist + 1);
            if (isValidMove(upCell, visited, numRows, numColumns)) {
                queue.add(upCell);
                visited[upCell.row][upCell.col] = true;
            }

            // down
            Cell downCell = new Cell(currentCell.row + 1, currentCell.col, currentCell.dist + 1);
            if (isValidMove(downCell, visited, numRows, numColumns)) {
                queue.add(downCell);
                visited[downCell.row][downCell.col] = true;
            }

            // left
            Cell leftCell = new Cell(currentCell.row, currentCell.col - 1, currentCell.dist + 1);
            if (isValidMove(leftCell, visited, numRows, numColumns)) {
                queue.add(leftCell);
                visited[currentCell.row][currentCell.col - 1] = true;
            }

            // right
            Cell rightCell = new Cell(currentCell.row, currentCell.col + 1, currentCell.dist + 1);
            if (isValidMove(rightCell, visited, numRows, numColumns)) {
                queue.add(rightCell);
                visited[currentCell.row][currentCell.col + 1] = true;
            }

        }

        return -1;
    }

    private static boolean[][] markeVisited(int numRows, int numColumns, List<List<Integer>> area) {
        boolean[][] visited = new boolean[numRows][numColumns];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numColumns; col++) {
                visited[row][col] = area.get(row).get(col) == 0;
            }
        }
        return visited;
    }

    private static boolean hasReachedDestination(Cell cell, List<List<Integer>> area) {
        return area.get(cell.row).get(cell.col) == DESTINATION;
    }

    private static boolean isValidMove(Cell cell, boolean[][] visited, int numRows, int numColumns) {
        return cell.row >= 0
                       && cell.row < numRows
                       && cell.col >= 0
                       && cell.col < numColumns
                       && !isVisited(cell, visited);
    }

    private static boolean isVisited(Cell cell, boolean[][] visited) {
        return visited[cell.row][cell.col];
    }

    private static void visit(Cell cell, boolean[][] visited) {
        visited[cell.row][cell.col] = true;
    }

    private static class Cell {
        int row;
        int col;
        int dist;

        Cell(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
}


