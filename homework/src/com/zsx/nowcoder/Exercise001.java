package com.zsx.nowcoder;

import java.util.Scanner;

/**
 * 给定一个正整数n，求出0到n中有几个数满足其二进制表示不包含连续的1。1<=n<=10^9。
 */
public class Exercise001 {

    private static int findIntegers(int number){
        //输入十进制为0时，只有一种情况0，输入十进制为1时，有两种情况0,1
        if (number < 2)
            return number + 1;
        //将数字转换为二进制并进行数据反转
        StringBuilder str = new StringBuilder(Integer.toBinaryString(number)).reverse();
        //二进制位数的所含种数，下标代表位数，值代表满足的种数
        int[] f = new int[str.length()];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < str.length(); i++){
            f[i] = f[i - 1] + f[i - 2];
        }

        int ans = 0;
        for (int i = str.length() - 1; i >= 0; i--){
            if (str.charAt(i) == '1'){
                ans += f[i];
                if (i < str.length() - 1 && str.charAt(i + 1) == '1'){
                    return ans;
                }
            }
        }
        ans++;
        return ans;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("请输入一个十进制整数：");
            String in = input.nextLine().trim();
            int number = -1;
            try {
                number = Integer.parseInt(in);
            }catch (Exception e){
                System.out.println("请输入正确的整数！");
            }
            if (number != -1){
                int count = findIntegers(number);
                System.out.println("共有：" + count + "种");
                input.close();
                return;
            }
        }
    }
}
