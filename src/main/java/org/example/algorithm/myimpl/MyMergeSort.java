package org.example.algorithm.myimpl;

public class MyMergeSort {

    public static void mergeSort(int[] arr) {
        int len = arr.length;
        int[] temp = new int[len];
        mergeSort(arr, 0, len - 1, temp);
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 归并排序左边子数组
            mergeSort(arr, left, mid, temp);
            // 归并排序右边子数组
            mergeSort(arr, mid + 1, right, temp);
            // 合并左右两部分的结果
            merge(arr, left, right, mid, temp);
        }
    }

    public static void merge(int[] arr, int left, int right, int mid ,int[] temp) {
        int i = left;
        int j = mid + 1;
        int k = left;

        // 将左右数组中的数按顺序放入临时数组中
        while(i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while(i <= mid) {
            temp[k++] = arr[i++];
        }

        while(j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left; i <=right; i++) {
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
