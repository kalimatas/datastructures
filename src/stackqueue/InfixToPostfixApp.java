package stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InfixToPostfixApp {
    public static void main(String[] args) throws IOException {
        System.out.print("Enter expression: ");
        String input = getString();

        InfixToPostfix inToPos = new InfixToPostfix(input);
        String postfix = inToPos.translate();

        System.out.println();
        System.out.println("Postfix: " + postfix);
    }

    public static String getString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}
