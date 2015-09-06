package diff.arrays;

public class SetZeros {
    public static void main(String[] args) {
        int[][] matrix = {
                {10, 10, 10, 10},
                {20, 0, 20, 20},
                {30, 30, 30, 30},
                {40, 40, 0, 40},
        };
        print(matrix);
        setZeros(matrix);
        print(matrix);
    }

    static void print(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i : row) {
                System.out.printf("%2d ", i);
            }
            System.out.println();
        }
        System.out.println();
    }

    static void setZeros(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (rows[i] || columns[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
