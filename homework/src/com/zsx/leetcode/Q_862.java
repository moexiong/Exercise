package com.zsx.leetcode;

import java.util.*;

/**
 * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
 *
 * 如果没有和至少为 K 的非空子数组，返回 -1 。
 */
public class Q_862 {

    private static int shortestSubArray(int array[], int k){
        int minimumLength = Integer.MAX_VALUE;
        int head = 0;
        int tail = 0;
        int sum = 0;
        while (head <= array.length){
            if (head > tail && sum >= k){
                sum -= array[tail];
                tail++;
            }else {
                sum += array[head];
                head++;
            }
            if (sum >= k && (head - tail) < minimumLength) minimumLength = (head - tail);
        }
        if (minimumLength == Integer.MAX_VALUE)return -1;
        else return minimumLength;
    }

    public static void input(){
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("请输入数组：");
            String in = input.nextLine();
            int[] numbers = inputFilter(in);
            if (numbers != null){
                System.out.print("请输入K值：");
                String sk = input.next();
                int k = Integer.MIN_VALUE;
                try {
                    k = Integer.parseInt(sk);
                }catch (Exception e){
                    System.out.println("请输入整数K");
                }
                if (k != Integer.MIN_VALUE){
                    int minimum = shortestSubArray(numbers, k);
                    System.out.println("最小子数组长度为：" + minimum);
                    input.close();
                    return;
                }
            }
        }
    }

    private static int[] inputFilter(String in){
        String[] strings = in.trim().split("\\s+");
        int[] numbers = new int[strings.length];
        try {
            for (int i = 0; i < strings.length; i++){
                numbers[i] = Integer.parseInt(strings[i]);
            }
        }catch (Exception e){
            System.out.println("请输入正确的数组！请按照数字空格数字的方式输入！");
            return null;
        }
        return numbers;
    }
}
