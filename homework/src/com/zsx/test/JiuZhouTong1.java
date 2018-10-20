package com.zsx.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数组，将所有正数拼接起来输出所能构成的最大数。
 */
public class JiuZhouTong1 {

    //10个桶，区分最大位，用来对最大位数排序
    private static List<Integer> bucket9 = new ArrayList<>();
    private static List<Integer> bucket8 = new ArrayList<>();
    private static List<Integer> bucket7 = new ArrayList<>();
    private static List<Integer> bucket6 = new ArrayList<>();
    private static List<Integer> bucket5 = new ArrayList<>();
    private static List<Integer> bucket4 = new ArrayList<>();
    private static List<Integer> bucket3 = new ArrayList<>();
    private static List<Integer> bucket2 = new ArrayList<>();
    private static List<Integer> bucket1 = new ArrayList<>();
    private static List<Integer> bucket0 = new ArrayList<>();

    public static void concat(int[] array){
        //将所有的正数放入集合
        List<Integer> list = new ArrayList<>();
        for (int item : array) {
            if (item >= 0){
                list.add(item);
            }
        }
        int[] numbers = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            numbers[i] = list.get(i);
        }
        //对数组中的数进行逐位比较
        recursion(numbers, 0, numbers.length, 1);
        System.out.print("最大值：");
        for (int item : numbers){
            System.out.print(item);
        }
    }

    private static void recursion(int[] numbers, int left, int right, int start){
        int[] count = new int[10];
        int[] length = new int[10];
        int sleft = left;
        init(count, length);
        if (left < right){
            for (int i = left; i < right; i++){
                //将对应的数放入对应的桶中，位数满足所求的直接放在最前面，并统计数量
                int n = Integer.parseInt((numbers[i] + "").charAt(start - 1) + "");
                if ((numbers[i] + "").length() == start) {
                    putValue(n, numbers[i], true);
                    count[n]++;
                }else
                    putValue(n, numbers[i], false);
            }
            //按顺序将桶中的值放回数组中
            if (!bucket9.isEmpty()){
                length[9] = bucket9.size();
                for (int item : bucket9){
                    numbers[left] = item;
                    left++;
                }
            }
            if (!bucket8.isEmpty()){
                length[8] = bucket8.size();
                for (int item : bucket8){
                    numbers[left] = item;
                    left++;
                }
            }
            if (!bucket7.isEmpty()){
                length[7] = bucket7.size();
                for (int item : bucket7){
                    numbers[left] = item;
                    left++;
                }
            }
            if (!bucket6.isEmpty()){
                length[6] = bucket6.size();
                for (int item : bucket6){
                    numbers[left] = item;
                    left++;
                }
            }
            if (!bucket5.isEmpty()){
                length[5] = bucket5.size();
                for (int item : bucket5){
                    numbers[left] = item;
                    left++;
                }
            }
            if (!bucket4.isEmpty()){
                length[4] = bucket4.size();
                for (int item : bucket4){
                    numbers[left] = item;
                    left++;
                }
            }
            if (!bucket3.isEmpty()){
                length[3] = bucket3.size();
                for (int item : bucket3){
                    numbers[left] = item;
                    left++;
                }
            }
            if (!bucket2.isEmpty()){
                length[2] = bucket2.size();
                for (int item : bucket2){
                    numbers[left] = item;
                    left++;
                }
            }
            if (!bucket1.isEmpty()){
                length[1] = bucket1.size();
                for (int item : bucket1){
                    numbers[left] = item;
                    left++;
                }
            }
            if (!bucket0.isEmpty()){
                length[0] = bucket0.size();
                for (int item : bucket0){
                    numbers[left] = item;
                    left++;
                }
            }
            //递归按顺序的对每个桶继续排序，位数增加一位
            for (int i = length.length - 1; i >= 0; i--){
                if (length[i] > 0){
                    recursion(numbers, sleft + count[i], sleft + length[i] - 1, ++start);
                    sleft += length[i];
                }
            }
        }
    }

    private static void init(int[] count, int[] length){
        for (int i = 0; i < count.length; i++){
            count[i] = 0;
        }
        for (int i = 0; i < length.length; i++){
            length[i] = 0;
        }
        bucket9.clear();
        bucket8.clear();
        bucket7.clear();
        bucket6.clear();
        bucket5.clear();
        bucket4.clear();
        bucket3.clear();
        bucket2.clear();
        bucket1.clear();
        bucket0.clear();
    }

    private static void putValue(int i, int item, boolean flag){
        switch (i){
            case 9:
                if (flag)
                    bucket9.add(0, item);
                else
                    bucket9.add(item);
                break;
            case 8:
                if (flag)
                    bucket8.add(0, item);
                else
                    bucket8.add(item);
                break;
            case 7:
                if (flag)
                    bucket7.add(0, item);
                else
                    bucket7.add(item);
                break;
            case 6:
                if (flag)
                    bucket6.add(0, item);
                else
                    bucket6.add(item);
                break;
            case 5:
                if (flag)
                    bucket5.add(0, item);
                else
                    bucket5.add(item);
                break;
            case 4:
                if (flag)
                    bucket4.add(0, item);
                else
                    bucket4.add(item);
                break;
            case 3:
                if (flag)
                    bucket3.add(0, item);
                else
                    bucket3.add(item);
                break;
            case 2:
                if (flag)
                    bucket2.add(0, item);
                else
                    bucket2.add(item);
                break;
            case 1:
                if (flag)
                    bucket1.add(0, item);
                else
                    bucket1.add(item);
                break;
            case 0:
                if (flag)
                    bucket0.add(0, item);
                else
                    bucket0.add(item);
                break;
        }
    }

    public static void main(String[] args) {
        int[] array = {17, -6, 9, 91, 56, 621, 612, 903, -76, 233};
        concat(array);
    }
}
