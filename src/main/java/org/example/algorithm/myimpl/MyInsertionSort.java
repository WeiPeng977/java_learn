package org.example.algorithm.myimpl;

public class MyInsertionSort {

    public static void insertionSort(int[] arr) {
        int len = arr.length;
        // 遍历数组
        for (int i = 1; i < len; i++) {
            int key = arr[i];
            int j = i - 1;
            // 将元素向前插入到合适的位置
            while (j >= 0 && key < arr[j]){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("原始数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        insertionSort(arr);

        System.out.println("\n排序后的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
