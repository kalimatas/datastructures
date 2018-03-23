package diff.numbers;

public class Rounding {
    public static void main(String[] args) {
        System.out.printf("%.1f -> %d, %.1f -> %d, %.1f -> %d, %.1f -> %d\n",
            13.5, Math.round(13.5), 14.5, Math.round(14.5), -14.5, Math.round(-14.5), -13.5, Math.round(-13.5));
    }
}
