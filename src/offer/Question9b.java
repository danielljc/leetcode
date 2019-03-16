package offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Daniel
 * @title: 面试题9（思考题）：用两个队列实现栈
 * @description: 两个队列来实现一个栈，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @date 2019-03-13 17:54
 */
class MyStack {
    // 保证至少一个队列为空
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push(int node) {
        // push入非空队列，若两个队列都为空，则放入哪个队列均可
        if (queue1.peek() == null && queue2.peek() != null)
            queue2.offer(node);
        else
            queue1.offer(node);
    }

    public int pop() {
        int result;
        // 将非空队列的元素，依次poll进另一个空队列
        if (queue1.peek() == null && queue2.peek() != null) {
            // 直到非空队列还剩一个元素，将其pop出
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            result = queue2.poll();
        } else {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            result = queue1.poll();
        }
        return result;
    }
}

public class Question9b {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(5);
        System.out.println(stack.pop());

    }
}
