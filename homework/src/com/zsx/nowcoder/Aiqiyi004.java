package com.zsx.nowcoder;

import java.util.*;
import java.util.regex.Pattern;

/**
 * 有一种有趣的字符串价值计算方式:统计字符串中每种字符出现的次数,然后求所有字符次数的平方和作为字符串的价值
 * 例如: 字符串"abacaba",里面包括4个'a',2个'b',1个'c',于是这个字符串的价值为4 * 4 + 2 * 2 + 1 * 1 = 21
 * 牛牛有一个字符串s,并且允许你从s中移除最多k个字符,你的目标是让得到的字符串的价值最小。
 *
 * 输入描述：输入包括两行,第一行一个字符串s,字符串s的长度length(1 ≤ length ≤ 50),其中只包含小写字母('a'-'z')。
 *          第二行包含一个整数k(0 ≤ k ≤ length),即允许移除的字符个数。
 * 输出描述：输出一个整数,表示得到的最小价值
 */
public class Aiqiyi004 {

    private static int count(String s, int k){
        Map<Character, Integer> map = new HashMap<>();
        //初始化字符串的数量集合，统计每种字符的数量
        for (int i = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }else
                map.put(s.charAt(i), 1);
        }
        //将值转化为数字数组
        int[] array = new int[map.size()];
        int i = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            array[i] = entry.getValue();
            i++;
        }
        array = remove(array, k);
        int sum = 0;
        for (int x : array){
            sum += x * x;
        }
        return sum;
    }

    //移除可以移除的字符后剩余的个数
    private static int[] remove(int[] array, int k){
        int maxIndex = 0;
        for (int i = 0; i < k; i++){
            //找出数组的当前最大值索引
            for (int j = 0; j < array.length; j++){
                if (array[j] > array[maxIndex])
                    maxIndex = j;
            }
            array[maxIndex]--;
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            String str = input.next();
            int k = input.nextInt();
            String reg = "^[a-z]*$";
            if (k <= str.length() && Pattern.matches(reg, str))
                System.out.println(count(str, k));
        }
        input.close();
    }

}
