package org.example.algorithm;

import java.util.Arrays;

public class CountingSort {

    public static void countingSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        // 1. 找到最大值和最小值，确定计数数组的大小
        int max = arr[0];
        int min = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        // 2. 计算每个元素出现的次数，存储在计数数组中
        int[] countArray = new int[max - min + 1];
        for (int num : arr) {
            countArray[num - min]++;
        }

        // 3. 计算每个元素在排序后的数组中的起始位置
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        // 4. 根据计数数组，将元素放入对应的位置，实现排序
        int[] sortedArray = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i];
            sortedArray[countArray[num - min] - 1] = num;
            countArray[num - min]--;
        }

        // 5. 将排序后的数组复制回原数组
        System.arraycopy(sortedArray, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 14, 5, 2, 19, 25, 30, 3, 17, 23, 15, 4, 9, 20};
        System.out.println("原始数组：" + Arrays.toString(arr));
        countingSort(arr);
        System.out.println("计数排序后：" + Arrays.toString(arr));
    }
}

