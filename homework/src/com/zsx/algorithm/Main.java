package com.zsx.algorithm;

/**
 * 算法的主程序入口
 */
public class Main {

    public static void main(String[] args){
        int[] array = GeneralUtils.generateArray();
        GeneralUtils.printArray(array);

        //交换排序：冒泡排序
        //BubbleSort.sort(array);

        //交换排序：快速排序
        //QuickSort.sort(array);

        //选择排序：直接选择
        //SelectionSort.sort(array);

        //选择排序：堆排序
        //HeapSort.sort(array);

        //插入排序：插入排序
        //InsertionSort.sort(array);

        //插入排序：希尔排序


        //归并排序：归并排序
        //MergeSort.sort(array);

        //计数排序
        //CountingSort.sort(array);

        //桶排序


        //基数排序


        GeneralUtils.printArray(array);
    }
}
