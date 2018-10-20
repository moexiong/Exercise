package com.zsx.test;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 小C有一张票，这张票的ID是长度为6的字符串，每个字符都是数字，他想让这个ID变成他的辛运ID，
 * 所以他就开始更改ID，每一次操作，他可以选择任意一个数字并且替换它。
 * 如果这个ID的前三位数字之和等于后三位数字之和，那么这个ID就是辛运的。你帮小C求一下，最少需要操作几次，能使ID变成辛运ID
 *
 * 输入描述：输入只有一行，是一个长度为6的字符串。
 * 输出描述：输出这个最小操作次数
 */
public class Aiqiyi3 {

    private static int replace(String number){
        int[] array = new int[number.length()];
        for (int i = 0; i < array.length; i++){
            array[i] = Integer.parseInt(number.charAt(i) + "");
        }
        int left = array[0] + array[1] + array[2];
        int right = array[3] + array[4] + array[5];
        int sum = left - right;
        int count = 0;
        if (sum > 0)
            count = findMin(array, sum);
        else if (sum < 0){
            //大的必须在前面
            for (int i = 0; i < 3; i++){
                swap(array, i, i + 3);
            }
            count = findMin(array, sum);
        }
        return count;
    }

    private static int findMin(int[] array,int sum){
        int count = 0;
        //将前三位按照升序排序
        for (int i = 2; i > 0; i--){
            if (array[i] > array[i - 1])
                swap(array, i, i - 1);
        }
        if (array[0] < array[1])
            swap(array, 0 , 1);
        //将后三位按照降序排序
        for (int i = 3; i < array.length; i++){
            if (array[i] > array[i + 1])
                swap(array, i, i + 1);
        }
        if (array[4] > array[5])
            swap(array, 4, 5);
        //每次减去最大可变化值
        int i = 0;
        while (sum > 0){
            if (array[i] > (9 - array[i + 3]))
                sum -= array[i];
            else
                sum -= (9 - array[i + 3]);
            i++;
            count++;
        }
        return count;
    }

    private static void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String number = input.nextLine();
        String reg = "^[0-9]{6}$";
        int r = 0;
        if (Pattern.matches(reg, number))
            r = replace(number);
        System.out.println(r);
    }

}
