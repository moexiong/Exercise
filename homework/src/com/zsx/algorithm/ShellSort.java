package com.zsx.algorithm;

/**
 * 插入排序：希尔排序
 *
 * 时间复杂度：最优O(n)   最差O(n^2)   平均O(n^1.3)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 *
 * 思想：1959年Shell发明，第一个突破O(n^2)的排序算法，是简单插入排序的改进版。
 *      它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。
 * 步骤：
 *      1.选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1
 *      2.按增量序列个数k，对序列进行k 趟排序
 *      3.每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
 *        仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 */
public class ShellSort {



}
