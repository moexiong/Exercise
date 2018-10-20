package com.zsx.nowcoder;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 对于任意两个正整数x和k,我们定义repeat(x, k)为将x重复写k次形成的数,例如repeat(1234, 3) = 123412341234,repeat(20,2) = 2020.
 * 牛牛现在给出4个整数x1, k1, x2, k2, 其中v1 = (x1, k1), v2 = (x2, k2),请你来比较v1和v2的大小。
 *
 * 输入描述：输入包括一行,一行中有4个正整数x1, k1, x2, k2(1 ≤ x1,x2 ≤ 10^9, 1 ≤ k1,k2 ≤ 50),以空格分割
 * 输出描述：如果v1小于v2输出"Less",v1等于v2输出"Equal",v1大于v2输出"Greater".
 */
public class Aiqiyi001 {

    //将给定的数拼接
    private static String repeat(int x, int k){
        String number = x + "";
        while (k > 1){
            number += x;
            k--;
        }
        return number;
    }

    //0：一样大，1：n1大，2：n2大
    private static int compare(String n1, String n2){
        String reg = "[1-9][0-9]*$";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(n1);
        //截取出符合要求的数字
        if (matcher.find())
            n1 = matcher.group();
        else
            n1 = "0";
        matcher = pattern.matcher(n2);
        if (matcher.find())
            n2 = matcher.group();
        else
            n2 = "0";
        //比较谁更大
        if (n1.length() > n2.length())
            return 1;
        else if (n1.length() < n2.length()){
            return 2;
        }else {
            int i = 0;
            while (i < n1.length()){
                int m1 = Integer.parseInt(n1.charAt(i) + "");
                int m2 = Integer.parseInt(n2.charAt(i) + "");
                i++;
                if (m1 > m2)
                    return 1;
                else if (m1 < m2)
                    return 2;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x1 = input.nextInt();
        int k1 = input.nextInt();
        int x2 = input.nextInt();
        int k2 = input.nextInt();
        String number1 = repeat(x1, k1);
        String number2 = repeat(x2, k2);
        int i = compare(number1, number2);
        switch (i){
            case 0:
                System.out.println("Equal");
                break;
            case 1:
                System.out.println("Greater");
                break;
            case 2:
                System.out.println("Less");
                break;
                default:break;
        }
        input.close();
    }
}
