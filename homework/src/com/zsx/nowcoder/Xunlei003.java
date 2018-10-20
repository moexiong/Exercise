package com.zsx.nowcoder;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * 输入一个有符号整数，输出该整数的反转值。
 */
public class Xunlei003 {

    private static String reverseNumber(String number){
        char[] chars = number.toCharArray();
        Stack<Character> stack = new Stack<>();
        String string = "";
        for (char c : chars) {
            stack.push(c);
        }
        //判断是不是第一位
        boolean flag = true;
        while (!stack.isEmpty()){
            if (flag && stack.peek() == '0')
                stack.pop();
            else {
                string += stack.peek();
                stack.pop();
                flag = false;
            }
        }
        return string;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("请输入一个带符号整数：");
            String number = input.nextLine();
            String reg = "^-?[0-9]+$";
            if (Pattern.matches(reg, number)){
                String reg1 = "^-?0+$";
                if (Pattern.matches(reg1, number)){
                    System.out.println(0);
                }else {
                    String symbol = "";
                    if (number.contains("-")){
                        number = number.substring(1);
                        symbol += "-";
                    }
                    int n = Integer.parseInt(number);
                    String string = reverseNumber(n + "");
                    System.out.println(symbol + string);
                }
                input.close();
                return;
            }
            System.out.println("输入有误！");
        }
    }
}
