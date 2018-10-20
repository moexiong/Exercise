package com.zsx.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Bilibili1 {

    private static List<Node> queue = new ArrayList<>();

    private static int last = 0;

    //left 22 33    4x+4
    //right 33 22   4x+5
    private static class Node{
        int value;
        Node pre;
        int flag;

        public Node(int value){
            this.value = value;
        }
    }

    private static Node findMin(int N){
        int x = 0;
        if (N == 1)
            return new Node(2);
        if (N == 2)
            return new Node(3);
        addQueue(new Node(0), N);
        for (Node node : queue){
            if (node.value == N){
                return node;
            }else if ((node.value * 2 + 1) == N){
                last = 2;
                return node;
            }else if ((node.value * 2 + 2) == N){
                last = 3;
                return node;
            }
        }
        return null;
    }

    private static void addQueue(Node node, int N){
        int left = 4 * node.value + 4;
        int right = 4 * node.value + 5;
        if (left < N && right < N) {
            Node ln = new Node(left);
            ln.pre = node;
            ln.flag = 23;
            Node rn = new Node(right);
            rn.pre = node;
            rn.flag = 32;
            queue.add(ln);
            queue.add(rn);
            addQueue(ln, N);
            addQueue(rn, N);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Node> stack = new Stack<>();
        int N = input.nextInt();
        Node node = findMin(N);
        if (node != null && node.value == 2)
            System.out.println(2);
        else if (node.value == 3)
            System.out.println(3);
        else {
            while (node.pre != null){
                stack.push(node);
                node = node.pre;
            }
            while (!stack.isEmpty()){
                if (stack.peek().flag == 23){
                    System.out.print(23);
                }else
                    System.out.print(32);
                stack.pop();
            }
            if (last != 0);
            System.out.print(last);
        }
    }

}
