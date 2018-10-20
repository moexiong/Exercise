package com.zsx.test;

import java.util.Scanner;

/**
 * 有红黑两种颜色的方块积木，红色代表正数A，黑色代表负数B。选出17块积木排成一排，
 * 使得任意相邻7块积木之和都小于0。如何挑选才能使17块积木之和最大，最大值是多少？
 */
public class Xunlei2 {

    private static int find(int a, int b){
        int min = 0;
        for (int i = 1; i < 7; i++){
            int x = (a * i + b * (7 - i));
            if (x < 0){
                min = i;
            }
        }
        int sum = a * min + b * (7 - min) + a * 3;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(find(10, -61));
    }

}
