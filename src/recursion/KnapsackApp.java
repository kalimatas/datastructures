package recursion;

public class KnapsackApp {
    public static void main(String[] args) {
        int[] items = {11, 8, 7, 6, 5};
        int target = 20;

        Knapsack knapsack = new Knapsack(items);
        int[] result = knapsack.fit(target, 0, 0);
        for (int i : result)
            System.out.print(i + " ");

        System.out.println();
    }
}

class Knapsack {
    int[] items;
    int size;

    Knapsack(int[] items) {
        this.items = items;
        size = items.length;
    }

    int[] fit(int target, int offset, int solutionSize) {
        if (target > 0) {

            // for each i, try placing the ith item in the knapsack
            for (int i = offset; i < size; i++) {
                int[] answer = fit(target - items[i], i + 1, solutionSize + 1);
                if (answer != null) {
                    answer[solutionSize] = items[i];
                    return answer;
                }
            }

            return null;

        } else if (target == 0) {
            // found solution. send back an array for filling
            return new int[solutionSize];
        } else {
            // negative - no sulution
            return null;
        }
    }
}
