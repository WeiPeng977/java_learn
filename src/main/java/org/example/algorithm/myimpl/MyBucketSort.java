package org.example.algorithm.myimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MyBucketSort {

    public static void bucketSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        // 1、确定桶的数量
        int bucketNum = 5;
        // 2、找出数组中的最大最小值，确定每个桶的范围
        int max = arr[0];
        int min = arr[0];
        for (int num : arr) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        int range = (max - min) / bucketNum + 1;
        // 3、初始化桶，并将元素放入对应的桶中
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int num: arr) {
            int bucketIndex = (num - min) / range;
            buckets.get(bucketIndex).add(num);
        }
        // 4、对每个桶中的元素进行排序，并转移到数组中
        int arrIndex = 0;
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int num : bucket) {
                arr[arrIndex] = num;
                arrIndex += 1;
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

