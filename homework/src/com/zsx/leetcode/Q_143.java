package com.zsx.leetcode;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Q_143 {
    //节点
    private static class Node{
        //节点的值
        int value;
        //指向下一个节点
        Node next;

        private Node(int value){
            this.value = value;
        }
    }

    private static Node getNode(int value){
        return new Node(value);
    }

    //重新排序链表
    private static void reOrderList(Node head){
        //只有长度大于等于3才能重新排序
        if (head.next != null && head.next.next != null){
            Node tail = head;
            Node last = tail;
            //得到尾节点
            while (true){
                if (tail.next != null){
                    last = tail;
                    tail = tail.next;
                }
                else
                    break;
            }
            //将尾节点加入第一个节点后
            tail.next = head.next;
            head.next = tail;
            last.next = null;
            //递归调用排序，继续排序后面部分
            reOrderList(tail.next);
        }
    }

    //过滤输入，生成链表
    private static Node inputFilter(String input){
        String[] nodes = input.trim().split("->");
        String reg = "^[0-9]+$";
        Node head = null;
        Node cursorNode = null;
        for (String node : nodes){
            if (Pattern.matches(reg, node.trim())){
                if (head == null){
                    //设置头节点
                    head = getNode(Integer.parseInt(node));
                    cursorNode = head;
                }
                else {
                    //生成链表
                    cursorNode.next = getNode(Integer.parseInt(node));
                    cursorNode = cursorNode.next;
                }
            }else {
                System.out.println("输入有误！请按照数字->数字的格式输入链表！");
                return null;
            }
        }
        return head;
    }

    protected static void input(){
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("给定链表：");
            String nodes = input.nextLine();
            Node head = inputFilter(nodes);
            if (head != null){
                reOrderList(head);
                System.out.println("重新排序：");
                while (head.next != null){
                    System.out.print(head.value + "->");
                    head = head.next;
                }
                System.out.print(head.value);
                input.close();
                return;
            }
        }
    }

}
