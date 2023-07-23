package org.example.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {

    public static void bucketSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        // 1. 确定桶的数量
        int bucketNum = 5; // 可根据数据分布情况调整

        // 2. 找到最大值和最小值，确定每个桶的范围
        int max = arr[0];
        int min = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int range = (max - min) / bucketNum + 1;

        // 3. 创建桶并将元素放入对应的桶中
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int num : arr) {
            int bucketIndex = (num - min) / range;
            buckets.get(bucketIndex).add(num);
        }

        // 4. 对每个桶中的元素进行排序（这里可以使用其他排序算法，这里使用Collections.sort()内置排序）
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 14, 5, 2, 19, 25, 30, 3, 17, 23, 15, 4, 9, 20};
        System.out.println("原始数组：" + Arrays.toString(arr));
        bucketSort(arr);
        System.out.println("桶排序后：" + Arrays.toString(arr));
    }
}

