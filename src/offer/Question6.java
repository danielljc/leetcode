package offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Daniel
 * @title: 面试题6：从头到尾打印链表
 * @description: 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * @date 2019-03-11 22:09
 */
public class Question6 {

    /**
     * 链表的数据结构
     */
    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 思路一：栈
     */
    private static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        // 先进后出的数据结构
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> array = new ArrayList<>();
        // 栈的pop操作
        while (!stack.empty())
            array.add(stack.pop());

        return array;
    }

    /**
     * 思路二：递归（递归在本质上就是一个栈）recursive
     * 每访问到⼀个节点的时候，先递归输出它后⾯的结点，再输出该结点⾃身，这样链表的输出结果就反过来了。
     */
    private static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode pNode = listNode;
        if (pNode != null) {
            if (pNode.next != null) {
                list = printListFromTailToHead2(pNode.next);
            }
            list.add(pNode.val);
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = head.next = new ListNode(2);
        ListNode third = second.next = new ListNode(3);
        ListNode forth = third.next = new ListNode(4);
        System.out.println(printListFromTailToHead(head));
    }

}
