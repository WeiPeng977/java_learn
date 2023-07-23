package org.example.algorithm;

public class MergeSort {
    public static void mergeSort(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n]; // 临时数组用于合并过程
        mergeSort(arr, 0, n - 1, temp);
    }

    private static void mergeSort(int[] arr, int low, int high, int[] temp) {
        if (low < high) {
            int mid = (low + high) / 2;

            // 分别对左右两部分进行归并排序
            mergeSort(arr, low, mid, temp);
            mergeSort(arr, mid + 1, high, temp);

            // 合并两部分
            merge(arr, low, mid, high, temp);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high, int[] temp) {
        int i = low; // 左部分数组的起始索引
        int j = mid + 1; // 右部分数组的起始索引
        int k = low; // 临时数组的起始索引

        // 将左右两部分数组中的元素按顺序合并到临时数组中
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 将左部分或右部分剩余的元素复制到临时数组中
        while (i <= mid) {
            temp[k++] = arr[i++];

        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        // 将临时数组中的元素复制回原数组
        for (i = low; i <= high; i++) {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("原始数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        mergeSort(arr);

        System.out.println("\n排序后的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
