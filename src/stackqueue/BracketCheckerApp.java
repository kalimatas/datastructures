package stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BracketCheckerApp {
    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.print("Enter string: ");
            String in = getString();

            if (in.equals("")) break;

            BracketChecker bc = new BracketChecker(in);
            bc.check();
        }
    }

    public static String getString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}

class BracketChecker {
    private String input;

    BracketChecker(String in) {
        input = in;
    }

    void check() {
        StackArray<Character> stack = new StackArray<Character>(input.length());

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                case '}':
                case ']':
                    if (stack.isEmpty()) {
                        System.out.println("Error: " + ch + " at " + i);
                    } else {
                        char chx = stack.pop();
                        if (ch == ')' && chx != '(' ||
                            ch == '}' && chx != '{' ||
                            ch == ']' && chx != '[') {
                            System.out.println("Error: " + ch + " at " + i);
                        }
                    }
                    break;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        }
    }
}

