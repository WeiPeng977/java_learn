package org.example.algorithm.myimpl;

public class MyHeapSort {

    public static void heapSort(int[] arr) {
        int len = arr.length;
        // 构建大顶堆
        for(int i = len/2 - 1; i >= 0; i--) {
            heapify(arr, i, len - 1);
        }

        // 将堆顶元素依次拿出来放在最后并重新构建大顶堆
        for (int i = len - 1; i >= 0; i--) {
            // 将堆顶元素（最大值）于末尾元素交换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // 重新构建大顶堆
            heapify(arr, 0, i - 1);
        }
    }

    public static void heapify(int[] arr, int startIndex,  int endIndex) {
        int largest = startIndex;
        int leftChildIndex = startIndex * 2 + 1;
        int rightChildIndex = startIndex * 2 + 2;

        // 判断当前父节点是不是最大值
        if (leftChildIndex <= endIndex && arr[largest] < arr[leftChildIndex]) {
            largest = leftChildIndex;
        }

        if (rightChildIndex <= endIndex && arr[largest] < arr[rightChildIndex]) {
            largest = rightChildIndex;
        }

        // 最大值节点不是当前根节点
        if (largest != startIndex) {
            // 交换最大值节点与当前根节点的值
            int temp = arr[startIndex];
            arr[startIndex] = arr[largest];
            arr[largest] = temp;
            // 重新构建被交换子节点为根节点的堆
            heapify(arr, largest, endIndex);
        }

    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("原始数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        heapSort(arr);

        System.out.println("\n排序后的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
