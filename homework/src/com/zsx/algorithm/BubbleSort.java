package com.zsx.algorithm;

/**
 * 交换排序：冒泡排序
 *
 * 时间复杂度：最优O(n)   最差O(n^2)   平均O(n^2)
 * 空间复杂度：O(1)
 * 稳定性：稳定
 *
 * 思想：冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。
 *      走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
 * 步骤：
 *      1.比较相邻的元素。如果第一个比第二个大，就交换它们两个
 *      2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数
 *      3.针对所有的元素重复以上的步骤，除了最后一个
 *      4.重复步骤1~3，直到排序完成。
 */
public class BubbleSort {

    public static int[] sort(int[] array){
        //排序的次数
        for (int i = 0; i < array.length; i++){
            //每次排序将最大值放在最后
            for (int j = 0; j < array.length - i - 1; j++){
                if (array[j] > array[j + 1]){
                    GeneralUtils.swapArrayItems(array, j, j + 1);
                }
            }
        }
        return array;
    }

}
