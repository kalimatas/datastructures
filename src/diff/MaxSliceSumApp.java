package diff;

import java.lang.Math;

public class MaxSliceSumApp {
    public static void main(String[] args) {
        System.out.println("max slice sum: " + maxSliceSum(new int[]{5,-7,3,5,-2,4,-1}));
    }

    private static int maxSliceSum(int[] A) {
        int maxEnding = 0, maxSlice = 0;

        for (int i : A) {
            maxEnding = Math.max(0, maxEnding + i);
            maxSlice = Math.max(maxSlice, maxEnding);
        }

        return maxSlice;
    }
}
