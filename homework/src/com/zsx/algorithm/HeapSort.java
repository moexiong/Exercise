package com.zsx.algorithm;

/**
 * 选择排序：堆排序
 *
 * 时间复杂度：最优O(nlogn)   最差O(nlogn)   平均O(nlogn)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 *
 * 思想：堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。
 *      堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
 * 步骤：
 *      1.将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区
 *      2.将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]
 *      3.由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，
 *        得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
 */
public class HeapSort {

    public static int[] sort(int[] array){
        //第一次先建立最大堆
        buildMaxHeap(array);
        //每次将最大值放置堆顶，并置于有序区中
        for (int i = array.length - 1; i >= 0; i--){
            GeneralUtils.swapArrayItems(array, 0, i);
            adjustHeap(array, 0 , i);
        }
        return array;
    }

    //建立最大堆
    private static void buildMaxHeap(int[] array){
        for (int i = (array.length / 2); i >= 0; i--){
            adjustHeap(array, i , array.length);
        }
    }

    //调整当前堆
    private static void adjustHeap(int[] array, int index, int currentLength){
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int large = index;

        if (left < currentLength && array[left] > array[large])
            large = left;
        if (right < currentLength && array[right] > array[large])
            large = right;

        if (large != index){
            GeneralUtils.swapArrayItems(array, index, large);
            adjustHeap(array, large ,currentLength);
        }
    }
}
