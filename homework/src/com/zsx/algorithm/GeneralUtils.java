package com.zsx.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * 通用工具类
 */
public class GeneralUtils {

    //随机生成长度为20，范围在1-100之间的整数数组
    protected static int[] generateArray(){
        Random random = new Random();
        int[] array = new int[20];
        for (int i = 0; i < 20; i++){
            array[i] = random.nextInt(100);
        }
        return array;
    }

    //随机生成指定长度与区间的数组
    //length:指定长度 minNumber:最小值 maxNumber:最大值
    protected static int[] generateArray(int length, int minNumber, int maxNumber){
        Random random = new Random();
        int[] array = new int[length];
        if (length <= 0)
            length = 10;
        if (maxNumber <= 0)
            maxNumber = 10;
        for (int i = 0; i < length; i++){
            array[i] = random.nextInt(maxNumber - minNumber) + minNumber;
        }
        return array;
    }

    //打印数组中的元素
    protected static void printArray(int[] array){
        String string = Arrays.toString(array);
        System.out.println(string);
    }

    //交换数组中的指定元素
    protected static void swapArrayItems(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

}
