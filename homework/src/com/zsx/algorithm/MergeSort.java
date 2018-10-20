package com.zsx.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 归并排序：归并排序
 *
 * 时间复杂度：最优O(nlogn)   最差O(nlogn)   平均O(nlogn)
 * 空间复杂度：O(n)
 * 稳定性：稳定
 *
 * 思想：归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 *      将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
 * 步骤：
 *      1.把长度为n的输入序列分成两个长度为n/2的子序列
 *      2.对这两个子序列分别采用归并排序
 *      3.将两个排序好的子序列合并成一个最终的排序序列。
 */
public class MergeSort {

    public static int[] sort(int[] array){
        sorted(array, 0, array.length - 1);
        return array;
    }

    //将数组拆分为两部分，分别排好序后合并
    private static void sorted(int[] array, int left, int right){
        if (left < right){
            //将数组分成左右两部分
            int mid = (left + right) / 2;
            //将左边排好序
            sorted(array, left, mid);
            //将右边排好序
            sorted(array, mid + 1, right);
            //将已经排好序的两个部分合并
            doSort(array, left, mid, right);
        }
    }

    //合并两个已经排好序的部分
    private static void doSort(int[] array, int left, int mid, int right){
        //记录数组从什么地方开始
        int start = left;
        int r = mid + 1;
        List<Integer> list = new ArrayList<>();
        //比较两部分的值放入临时集合中，直至一部分结束
        while (left <= mid && r <= right){
            if (array[left] > array[r]){
                list.add(array[r]);
                r++;
            }else {
                list.add(array[left]);
                left++;
            }
        }
        //将左边剩余的值放入集合
        while (left <= mid){
            list.add(array[left]);
            left++;
        }
        //将右边剩余的值放入集合
        while (r <= right){
            list.add(array[r]);
            r++;
        }
        //将集合中的值放回数组
        for (int c : list){
            array[start] = c;
            start++;
        }
    }

}
