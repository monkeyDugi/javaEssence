package collectionFramework.stackQueue;

import java.util.EmptyStackException;
import java.util.Stack;

// Stack의 활용예
// 수식의 괄호가 맞는지
public class StackAppExample {

    public static void main(String[] args) {
        Stack stack = new Stack();
        String expression = "((3+5)*8-2))))";

        System.out.println("expression : " + expression);

        // 여는 괄호만큼 스택에 넣고, 닫은 괄호만큼 스택에서 꺼내어 비어있으면 수식이 올바르고, 안비어 있으면 수식이 올바르지 않은 것
        try {
            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);

                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    stack.pop();
                }

            }

            if (stack.isEmpty()) {
                System.out.println("괄호가 일치합니다");
                // 여는 괄호가 남아있을 때
            } else {
                System.out.println("괄호가 일치하지 않습니다111.");
            }
            // 닫는 괄호가 여는 괄호보다 많아서 스택이 비었는데 꺼내려고 할 때
        } catch (EmptyStackException e) {
            System.out.println("괄호가 일치하지 않습니다222.");
        }
    }
}
