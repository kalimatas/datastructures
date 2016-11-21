package diff.numbers;

public class Convert {
    private static final String CHARS = "0123456789ABCDEF";
    private static final short BASE = (byte) CHARS.length();

    private static String encode(int number) {
        StringBuilder sb = new StringBuilder();

        while (number > 0) {
            int digit = number % BASE;
            sb.append(CHARS.charAt(digit));
            number = number / BASE;
        }

        return sb.reverse().toString();
    }

    private static int decode(String number) {
        int result = 0;

        for (int i = 0, power = number.length() - 1; i < number.length(); i++, power--) {
            result += CHARS.indexOf(number.charAt(i)) * Math.pow(BASE, power);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(encode(2484));
        System.out.println(decode("9B4"));
    }
}
