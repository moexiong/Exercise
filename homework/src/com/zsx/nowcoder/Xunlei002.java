package com.zsx.nowcoder;

import java.util.Scanner;
import java.util.Stack;

/**
 * 用x,y表示一个整数范围区间，现在输入一组这样的范围区间(用空格隔开)，请输出这些区间的合并。
 */
public class Xunlei002 {
    //确定当前退出栈索引
    private static int index = 0;
    //栈
    private static Stack<Integer> stack = new Stack<>();

    private static boolean flag = false;

    private static void inStack(int[] array){
        stack.push(array[0]);
        for (int i = 1; i < array.length; i++){
            if (array[i] > array[index]){
                stack.push(array[i]);
                index = i;
                flag = true;
            }else {
                if (flag)
                    stack.pop();
                flag = false;
            }
        }
    }

    private static int[] inputFilter(String string){
        String[] strings = string.trim().split(",");
        int[] array = new int[strings.length];
        try {
            for (int i = 0; i < strings.length; i++){
                array[i] = Integer.parseInt(strings[i].trim());
            }
        }catch (Exception e){
            System.out.println("输入有误！请按照 数字逗号数字 的格式输入！");
            return null;
        }
        return array;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("请输入一串数字区间：");
            String s = input.nextLine();
            int[] array = inputFilter(s);
            if (array != null){
                inStack(array);
                while (!stack.empty()){
                    if (stack.size() == 1)
                        System.out.print(stack.get(0));
                    else
                        System.out.print(stack.get(0) + ",");
                    stack.remove(0);
                }
                input.close();
                return;
            }
        }
    }
}
