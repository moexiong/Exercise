package com.zsx.nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 对于一个整数N（512 <= N <= 1024），计算2的N次方并在屏幕显示十进制结果。
 */
public class Xunlei001 {

    //2的n次方
    private static int ns;
    //已经执行了多少次
    private static int count = 1;
    //进位值
    private static int next = 0;
    //存放运算结果
    private static List<Integer> number = new ArrayList<>();

    private static void muiltiplusTwo(){
        if (count < ns){
            for (int i = 0; i < number.size(); i++){
                int value = number.get(i) * 2;
                //大于9就进位
                if (value > 9){
                    number.set(i, value % 10 + next);
                    next = 1;
                }else {
                    number.set(i, value + next);
                    next = 0;
                }
            }
            //位数增加
            if (next == 1)
                number.add(next);
            count++;
            next = 0;
            muiltiplusTwo();
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("请输入n值：");
            String sn = input.nextLine().trim();
            int n = 0;
            try {
                n = Integer.parseInt(sn);
            }catch (Exception e){
                System.out.println("输入有误!");
            }
            if (n != 0){
                ns = n;
                number.add(2);
                muiltiplusTwo();
                while (!number.isEmpty()){
                    System.out.print(number.get(number.size() - 1));
                    number.remove(number.size() - 1);
                }
                input.close();
                return;
            }
        }
    }
}
