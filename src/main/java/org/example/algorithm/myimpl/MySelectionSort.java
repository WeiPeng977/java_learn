package org.example.algorithm.myimpl;

public class MySelectionSort {
    public static void selectionSort(int[] arr) {
        int len = arr.length;
        // 遍历数组
        for (int i = 0; i < len - 1; i++) {
            // 找出数组中最小的数的下标
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 将最小的数与第i个数进行交换
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("原始数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        selectionSort(arr);

        System.out.println("\n排序后的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
