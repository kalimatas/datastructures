package diff.arrays;

public class SmallestCommonNumber {
    public static void main(String[] args) {
        System.out.println(smallestCommonNumber(new int[]{6, 10, 17, 28},
                                                new int[]{-1, 0, 6, 10, 19},
                                                new int[]{1, 6, 22}));
    }

    private static int smallestCommonNumber(int[] arr1,
                                            int[] arr2,
                                            int[] arr3) {
        int i = 0, j = 0, k = 0;
        while (i != arr1.length && j != arr2.length && k != arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                return arr1[i];
            }

            if (arr1[i] < arr2[j] && arr1[i] < arr3[k]) {
                i++;
                continue;
            }
            if (arr2[j] < arr1[i] && arr2[j] < arr3[k]) {
                j++;
                continue;
            }
            if (arr3[k] < arr1[i] && arr3[k] < arr2[j]) {
                k++;
            }
        }

        return -1;
    }
}
