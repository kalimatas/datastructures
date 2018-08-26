package diff.arrays;

public class MaxSingleSellProfit {
    private static class Tuple {
        int x; // buy price
        int y; // sell price

        Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        var t = find_buy_sell_stock_prices(new int[]{8, 5, 12, 9, 19, 11});
        System.out.printf("%d - %d\n", t.x, t.y);
    }

    static Tuple find_buy_sell_stock_prices(int[] array) {
        if (array == null || array.length < 2) {
            return null;
        }

        int currentBuy = array[0];
        int globalSell = array[1];
        int globalProfit = globalSell - currentBuy;

        int currentProfit = Integer.MIN_VALUE;
        for (int i = 1; i < array.length; i++) {
            currentProfit = array[i] - currentBuy;

            if (currentProfit > globalProfit) {
                globalProfit = currentProfit;
                globalSell = array[i];
            }

            if (currentBuy > array[i]) {
                currentBuy = array[i];
            }
        }

        return new Tuple(globalSell - globalProfit, globalSell);
    }
}
