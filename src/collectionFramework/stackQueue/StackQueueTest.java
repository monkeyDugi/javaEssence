package collectionFramework.stackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTest {

    public static void main(String[] args) {
        Stack stack = new Stack();
        Queue queue = new LinkedList(); // Queue 인터페이스의 구현체인 LinkedList 사용

        stack.push("0");
        stack.push("1");
        stack.push("2");

        queue.offer("0");
        queue.offer("1");
        queue.offer("2");

        System.out.println("= Stack =");
        // 스택이 비어있지 않으면 하나를꺼낸다.
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }

        System.out.println("= Queue =");
        // 큐가 비어있지 않으면 하나를 꺼낸다.
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
