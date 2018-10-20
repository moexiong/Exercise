package com.zsx.algorithm;

/**
 * 计数排序
 *
 * 时间复杂度：最优O(n+k)   最差O(n+k)   平均O(n+k)
 * 空间复杂度：O(n+k)
 * 稳定性：稳定
 *
 * 思想：计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。
 *      作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
 * 步骤：
 *      1.找出待排序的数组中最大和最小的元素
 *      2.统计数组中每个值为i的元素出现的次数，存入数组C的第i项
 *      3.对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）
 *      4.反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
 */
public class CountingSort {

    public static int[] sort(int[] array){
        int max = array[0];
        int min = array[0];
        //找出数组中最大值和最小值
        for (int anArray : array) {
            if (anArray > max)
                max = anArray;
            if (anArray < min)
                min = anArray;
        }
        int[] count = sorted(array, max, min);
        doSort(array, count, min);
        return array;
    }

    //将数组放入计数数组中对每种元素进行计数
    private static int[] sorted(int[] array, int max, int min){
        int[] count = new int[max - min + 1];
        //初始化计数数组
        for (int i = 0; i < count.length; i++){
            count[i] = 0;
        }
        //对每个数进行计数
        for (int anArray : array) {
            count[anArray - min]++;
        }
        return count;
    }

    //将原数组按照计数数组的值进行重排序
    private static void doSort(int[] array, int[] count, int min){
        int index = 0;
        int i = 0;
        while (index < count.length){
            if (count[index] > 0){
                array[i] = index + min;
                count[index]--;
                i++;
            }else
                index++;
        }
    }

}
