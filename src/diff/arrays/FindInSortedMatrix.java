package diff.arrays;

public class FindInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {2, 3, 4, 13},
                {3, 7, 8, 18},
                {6, 10, 16, 22},
                {9, 15, 18, 31},
        };

        int[] r = find(matrix, 8);
        System.out.printf("[%d, %d]\n", r[0], r[1]);
    }

    /**
     * O(m+n) where m is number of rows and n is number of columns.
     * O(1) memory
     */
    static int[] find(int[][] matrix, int value) {
        int[] pair = new int[]{-1, -1};
        if (matrix.length == 0) {
            return pair;
        }

        int rowsCount = matrix.length;
        int colsCount = matrix[0].length;

        // right upper corner
        int row = 0;
        int col = colsCount - 1;

        while (row < rowsCount && col >= 0) {
            int matrixValue = matrix[row][col];
            if (matrixValue == value) {
                return new int[]{row, col};
            }

            if (value < matrixValue) {
                col--;
            } else {
                row++;
            }
        }

        return pair;
    }
}
