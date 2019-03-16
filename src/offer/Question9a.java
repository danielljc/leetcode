package offer;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author Daniel
 * @title: 面试题9：用两个栈实现队列
 * @description: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @date 2019-03-12 17:35
 */
class MyQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        int result;
        if (!stack2.empty()) {
            result = stack2.pop();
        } else if (stack2.empty() && !stack1.empty()){
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            result = stack2.pop();
        } else {
            // 当栈为空时抛出栈空异常，牢记！
            throw new EmptyStackException();
        }
        return result;
    }
}

public class Question9a {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pop());
        queue.push(5);
        System.out.println(queue.pop());
    }

}
