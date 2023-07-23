package org.example.algorithm.myimpl;

public class MyQuickSort {

    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            // 对pivot左边子数组进行快排
            quickSort(arr, left, pivotIndex - 1);
            // 对pivot右边子数组进行快排
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int j = left;
        for (int i = left; i < right; i++) {
            // 如果arr[i]小于等于pivot，就依次排在数组的左边
            if (arr[i] <= pivot) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
        // 将pivot放置在正确的位置
        arr[right] = arr[j];
        arr[j] = pivot;
        return j;
    }


    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("原始数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        quickSort(arr);

        System.out.println("\n排序后的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
