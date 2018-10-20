package com.zsx.algorithm;

/**
 * 交换排序：快速排序
 *
 * 时间复杂度：最优O(nlogn)   最差O(n^2)   平均O(nlogn)
 * 空间复杂度：O(nlogn)
 * 稳定性：不稳定
 *
 * 思想：快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，
 *      其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 * 步骤：
 *      1.从数列中挑出一个元素，称为 “基准”（pivot）
 *      2.重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 *        在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作
 *      3.递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 */
public class QuickSort {

    public static int[] sort(int[] array){
        doSort(array, 0, array.length - 1);
        return array;
    }

    //根据索引的位置对不同段进行排序
    private static void doSort(int[] array, int left, int right){
        if (left < right){
            //当前排序确定出基准元素的位置，后面继续排序基准元素左边或右边或两边
            int s = sorted(array, left, right);
            if (s == left)
                doSort(array, s + 1, right);
            else if (s == right)
                doSort(array,  left, s - 1);
            else {
                doSort(array, left, s - 1);
                doSort(array, s + 1, right);
            }
        }
    }

    //对一段长度内进行排序，找出基准值的索引
    private static int sorted(int[] array, int left, int right){
        int pivot = left;
        while (left < right){
            //将第一个元素作为基准，比它小的在左边，大的在右边
            if (array[left] > array[right]){
                GeneralUtils.swapArrayItems(array, left, right);
                if (pivot == left)
                    pivot = right;
                else
                    pivot = left;
            }
            if (pivot == left)
                right--;
            else
                left++;
        }
        //返回最后基准元素的位置
        return pivot;
    }

}
