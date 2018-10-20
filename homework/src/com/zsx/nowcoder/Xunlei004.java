package com.zsx.nowcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * 给定整数n，取若干个1到n的整数可求和等于整数m，编程求出所有组合的个数。
 * 比如当n=6，m=8时，有四种组合：[2,6], [3,5], [1,2,5], [1,3,4]。限定n和m小于120
 */
public class Xunlei004 {

    private static Set<Stack> result = new HashSet<>();

    private static void dfs(Stack<Integer> stack,int n, int m, int index){
        if (m == 0){
            stack.stream().forEach(System.out::print);
            System.out.println();
            result.add(stack);
        }
        else if (m > 0){
            for (int i = index; i <= n; i++){
                stack.push(i);
                dfs(stack, n, m - i, i + 1);
                stack.pop();
            }
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("请输入n和m：");
            String in = input.nextLine();
            String reg = "^[0-9]{1,3}\\s+[0-9]{1,3}$";
            if (Pattern.matches(reg, in)){
                String[] nm = in.split("\\s+");
                int n = Integer.parseInt(nm[0]);
                int m = Integer.parseInt(nm[1]);
                if (n <= 120 && m <= 120){
                    Stack<Integer> stack = new Stack<>();
                    if (n < m)
                        dfs(stack, n, m, 1);
                    else
                        dfs(stack, m, m, 1);
                    System.out.println(result.size());
                    input.close();
                    return;
                }
            }
        }
    }
}
