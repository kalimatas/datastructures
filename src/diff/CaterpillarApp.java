package diff;

public class CaterpillarApp {
    public static void main(String[] args) {
        if (hasSequence(new int[]{6, 2, 7, 4, 1, 3, 6}, 12)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        System.out.println("triangles: " + triangles(new int[]{4, 6, 3, 7}));
        System.out.println("triangles brute: " + trianglesBrute(new int[]{4, 6, 3, 7}));
    }

    private static boolean hasSequence(int[] A, int sum) {
        int n = A.length;
        int front = 0, total = 0;

        for (int back = 0; back < n; back++) {
            while (front < n && total + A[front] <= sum) {
                total += A[front];
                front++;
            }

            if (total == sum) return true;
            total -= A[back];
        }

        return false;
    }

    private static int triangles(int[] A) {
        int n = A.length;
        int result = 0;
        int z;

        for (int x = 0; x < n; x++) {
            z = 0;
            for (int y = x + 1; y < n; y++) {
                while (z < n && A[x] + A[y] > A[z]) z++;

                result += z - y - 1;
            }
        }

        return result;
    }

    private static int trianglesBrute(int[] A) {
        int result = 0;

        for (int x = 0; x < A.length; x++)
            for (int y = x + 1; y < A.length; y++)
                for (int z  = y + 1; z < A.length; z++)
                    if (A[x] + A[y] > A[z]) result++;

        return result;
    }
}
