package diff;

public class CaterpillarApp {
    public static void main(String[] args) {
        if (hasSequence(new int[]{6, 2, 7, 4, 1, 3, 6}, 12)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
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
}
