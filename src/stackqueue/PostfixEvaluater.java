package stackqueue;

public class PostfixEvaluater {
    private String expression;
    private StackArray<Integer> stack;

    public PostfixEvaluater(String expression) {
        this.expression = expression;
        stack = new StackArray<Integer>(expression.length());
    }

    public int evaluate() throws Exception {
        int left, right;
        char ch;

        for (int i = 0; i < expression.length(); i++) {
            ch = expression.charAt(i);

            if (ch >= '0' && ch <= '9') {
                stack.push(ch - '0');
            } else {
                left = stack.pop();
                right = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(left + right);
                        break;
                    case '-':
                        stack.push(right - left);
                        break;
                    case '*':
                        stack.push(left * right);
                        break;
                    case '/':
                        stack.push(right / left);
                        break;
                    default:
                        throw new Exception("Unknown operator " + ch);
                }
            }
        }

        return stack.pop();
    }
}
