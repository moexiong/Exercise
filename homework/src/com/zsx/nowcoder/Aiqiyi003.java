package com.zsx.nowcoder;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 考虑定义在两正整数上的函数SSR(平方根之和的平方):SSR(A, B) = (sqrt(A) + sqrt(B))^2。
 * 牛牛对函数值为整数的情况很感兴趣。现在给定整数n和m,请帮助牛牛计算有序对(A, B)的数量,
 * 满足1 ≤ A ≤ n, 1 ≤ B ≤ m而且SSR(A, B)是一个整数。
 *
 * 输入描述：输入包括两个整数n和m(1 ≤ n ≤ 10^5, 1 ≤ m ≤ 10^5)
 * 输出描述：输出一个整数,表示满足条件的有序对对数。
 */
public class Aiqiyi003 {

    //n<m
    private static int find(int n, int m){
        int count = 0;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (!judge(i, j))
                    count++;
            }
        }
        return count;
    }

    //如果两个数的平方差的和的平方为整数，就返回false
    private static strictfp boolean judge(int i, int j){
        double answer = Math.sqrt(i * j);
        String reg = ".[0-9]*[1-9]+[0-9]*$";
        String s = answer + "";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(s);
        boolean flag = false;
        if (matcher.find())
            flag = true;
        return flag;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        if (input.hasNextInt()){
            int n = input.nextInt();
            int m = input.nextInt();
            int count = 0;
            if (n > m)
                count = find(m, n);
            else
                count = find(n, m);
            System.out.println(count);
        }
    }

}
