package org.example.algorithm.myimpl;

public class MyShellSort {
    public static void shellSort(int[] arr) {
        int len = arr.length;
        // 确定间隔
        int gap = len / 2;

        while (gap > 0) {
            // 对间隔的元素进行排序
            for (int i = gap; i < len; i++) {
                int j = i;
                // 排序
                int temp = arr[j];
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
            // 逐步缩小间隔
            gap /= 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: ");
        printArray(arr);

        shellSort(arr);

        System.out.println("Sorted array: ");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
