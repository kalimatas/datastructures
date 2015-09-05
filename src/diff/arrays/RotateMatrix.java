package diff.arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {10, 10, 10, 10},
                {20, 20, 20, 20},
                {30, 30, 30, 30},
                {40, 40, 40, 40},
        };
        int n = 4;

        print(matrix);
        rotate(matrix, n);
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

    static void rotate(int[][] matrix, int n) {
        for (int layer = 0; layer < n / 2; ++layer) {
            int end = n - 1 - layer;
            for (int i = layer; i < end ; ++i) {
                int offset = i - layer;

                // save top
                int top = matrix[layer][i];

                // left -> top
                matrix[layer][i] = matrix[end-offset][layer];

                // bottom -> left
                matrix[end-offset][layer] = matrix[end][end-offset];

                // right -> bottom
                matrix[end][end-offset] = matrix[i][end];

                // top -> right
                matrix[i][end] = top;
            }
        }
    }
}
