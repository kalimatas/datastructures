package stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseStringApp {
    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.print("Enter string: ");
            String in = getString();

            if (in.equals("")) break;

            Reverser r = new Reverser(in);
            System.out.println();
            System.out.println("Reversed: " + r.reverse());
        }
    }

    public static String getString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}

class Reverser {
    private String input;
    private String output;

    Reverser(String in) {
        input = in;
    }

    String reverse() {
        StackArray<Character> stack = new StackArray<Character>(input.length());

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        output = "";
        while (!stack.isEmpty()) {
            output += stack.pop();
        }

        return output;
    }
}
