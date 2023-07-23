package org.example.algorithm.myimpl;

public class MyBubbleSort {

    private static void bubbleSort(int[] arr) {
        int len = arr.length;
        boolean swap = false;
        for (int i=0; i<len-1; i++) {
            for (int j=0; j<len-i-1; j++) {
                // 每次将最大的数逐渐冒泡到数组末尾
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("原始数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        bubbleSort(arr);

        System.out.println("\n排序后的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
