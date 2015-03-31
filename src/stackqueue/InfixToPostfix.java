package stackqueue;

public class InfixToPostfix {
    private String input;
    private String output;
    private StackArray<Character> stack;

    public InfixToPostfix(String in) {
        input = in;
        output = "";
        stack = new StackArray<Character>(in.length());
    }

    public String translate() {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            switch (ch) {
                case '+':
                case '-':
                    parseOperator(ch, 1);
                    break;
                case '*':
                case '/':
                    // higher precedence
                    parseOperator(ch, 2);
                    break;
                case '(':
                    parseLeftParetheses();
                    break;
                case ')':
                    parseRightParetheses();
                    break;
                default:
                    output += ch;
                    break;
            }
        }

        while (!stack.isEmpty()) {
            output += stack.pop();
        }

        return output;
    }

    private void parseOperator(char currentOperator, int currentPreced) {
        if (stack.isEmpty()) {
            stack.push(currentOperator);
        } else {
            while (!stack.isEmpty()) {
                char topOperator = stack.pop();

                if (topOperator == '(') {
                    stack.push(topOperator);
                    break;
                } else {
                    // Find topOperator precedence
                    int topPreced;
                    if (topOperator == '*' || topOperator == '/')
                        topPreced = 2;
                    else
                        topPreced = 1;

                    if (topPreced < currentPreced) {
                        stack.push(topOperator);
                        break;
                    } else {
                        output += topOperator;
                    }
                }
            }

            stack.push(currentOperator);
        }
    }

    private void parseLeftParetheses() {
        stack.push('(');
    }

    private void parseRightParetheses() {
        while (!stack.isEmpty()) {
            char ch = stack.pop();
            if (ch == '(')
                break;
            else
                output += ch;
        }
    }
}
