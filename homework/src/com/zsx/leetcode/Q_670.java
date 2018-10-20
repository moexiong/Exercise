package com.zsx.leetcode;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 */
public class Q_670 {

    private static int pointer = 0;
    private static int[] re = new int[3];
    //将接收的值进行查找，并返回交换后最大值
    private static int[] maximumSwap(int num){
        re[0] = num;
        char[] chars = (num + "").toCharArray();
        int[] bits = new int[chars.length];
        //初始化每一位的数字数组
        for (int i = 0; i < chars.length; i++){
            bits[i] = Integer.parseInt(chars[i] + "");
        }
        int maxIndex = pointer;
        //查找最大数字
        for (int i = pointer; i < bits.length; i++){
            if (bits[i] >= bits[maxIndex])
                maxIndex = i;
        }
        //最大数字比当前最高位大，则进行交换
        if (maxIndex != pointer && bits[pointer] != bits[maxIndex]){
            int temp = bits[maxIndex];
            bits[maxIndex] = bits[pointer];
            bits[pointer] = temp;
            String str = "";
            for (int n : bits){
                str += n;
            }
            num = Integer.parseInt(str);
            re[0] = num;
            re[1] = bits[maxIndex];
            re[2] = bits[pointer];
        }else {
            if (bits.length > pointer + 1){
                pointer++;
                //递归查找去掉首位后的最大值
                re = maximumSwap(num);
            }
        }
        return re;
    }

    //过滤输入，提供正确的输入
    private static int numFilter(String num){
        String reg = "^[0-9]+$";
        if (Pattern.matches(reg, num))
            return Integer.parseInt(num);
        else {
            System.out.println("输入有误！请输入正确的整数");
            return -1;
        }
    }

    protected static void input(){
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.print("请输入一个数字:");
            String in = input.nextLine();
            //执行过滤
            int num = numFilter(in);
            if (num != -1){
                //查找最大值
                int[] newNum = maximumSwap(num);
                if (newNum[0] == num){
                    System.out.println("最大值：" + newNum[0]);
                    System.out.println("不需要交换");
                }else {
                    System.out.println("最大值：" + newNum[0]);
                    System.out.println("交换了数字" + newNum[1] + "和数字" + newNum[2]);
                }
                input.close();
                return;
            }
        }
    }

}
