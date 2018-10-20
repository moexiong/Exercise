package com.zsx.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 勾股数，是由三个正整数组成的数组；能符合勾股定理 a*a + b*b = c*c ， (a, b, c) 的正整数解。
 * 如果 (a, b, c) 是勾股数，它们的正整数倍数，也是勾股数。如果 (a, b, c) 互质，它们就称为素勾股数。
 * 给定正整数N，计算出小于或等于N的素勾股数个数。(0 < a <= b <= c <= N)
 */
public class Xunlei1 {

    private static List<Integer[]> numbers = new ArrayList<>();

    private static void find(int n){
        int max = (int) Math.ceil(Math.sqrt((n * n) / 2));
        for (int i = 1; i < max; i++){
            for (int j = i; j < n; j++){
                double dk = i * i + j * j;
                int k = (int) Math.sqrt(dk);
                if ((Math.sqrt(dk) * 100000) % 100000 == 0){
                    if (judge(i, j, k)){
                        Integer[] integers = new Integer[]{i, j, k};
                        numbers.add(integers);
                    }
                }
            }
        }
    }

    private static boolean judge(int i, int j, int k){
        int start = 2;
        int end = (i > j ? j : i) < k ? (i > j ? j : i) : k;
        while (start < end){
            if (i % start == 0 && j % start == 0 && k % start == 0){
                return false;
            }
            start++;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        find(in);
        System.out.println(numbers.size());
    }
}
