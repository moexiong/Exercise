package com.zsx.algorithm;

/**
 * 插入排序：插入排序
 *
 * 时间复杂度：最优O(n)   最差O(n^2)   平均O(n^2)
 * 空间复杂度：O(1)
 * 稳定性：稳定
 *
 * 思想：插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。
 *      它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 * 步骤：
 *      1.从第一个元素开始，该元素可以认为已经被排序
 *      2.取出下一个元素，在已经排序的元素序列中从后向前扫描
 *      3.如果该元素（已排序）大于新元素，将该元素移到下一位置
 *      4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 *      5.将新元素插入到该位置后
 *      6.重复步骤2~5。
 */
public class InsertionSort {

    public static int[] sort(int[] array){
        sorted(array, array.length - 1);
        return array;
    }

    //将长度为n的数组进行排序
    private static void sorted(int[] array, int n){
        //只对大于1的数组进行排序
        if (n > 0){
            //将数组的n-1位已经排好序
            sorted(array, n - 1);
            //将第n位插入到已经排好序的数组n-1中
            doSort(array, n);
        }
    }

    private static void doSort(int[] array, int n){
        int index = n;
        for (int i = 0; i < n; i++){
            //找出比n大的位置
            if (array[i] > array[n]){
                index = i;
                break;
            }
        }
        //将n插入到比它大的值的位置，后方数组后移一位
        if (index != n){
            for (int i = n; i > index; i--){
                GeneralUtils.swapArrayItems(array, i, i - 1);
            }
        }
    }
}
