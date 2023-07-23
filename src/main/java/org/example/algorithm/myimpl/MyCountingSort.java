package org.example.algorithm.myimpl;

import java.util.Arrays;

public class MyCountingSort {

    public static void countingSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        // 1. 找到最大值和最小值，确定计数数组的大小 O(n)
        int max = arr[0];
        int min = arr[0];
        for (int i : arr) {
            max = Math.max(i, max);
            min = Math.min(i, min);
        }

        // 2.计算出每个元素出现的次数，并存储在计数数组中 O(n)
        int[] countArray = new int[max - min + 1];
        for (int num : arr) {
            countArray[num - min]++;
        }

        // 3、计算每个元素在排序后数组中的结束位置
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }
        // 4、根据计数数组，将元素放在对应位置，实现排序
        int[] sortedArray = new int[arr.length];
        for (int num : arr) {
            sortedArray[countArray[num - min] - 1] = num;
            countArray[num - min]--;
        }

        System.arraycopy(sortedArray, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 14, 5, 2, 19, 25, 30, 3, 17, 23, 15, 4, 9, 20};
        System.out.println("原始数组：" + Arrays.toString(arr));
        countingSort(arr);
        System.out.println("计数排序后：" + Arrays.toString(arr));
    }
}

