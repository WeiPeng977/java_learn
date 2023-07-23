package org.example.algorithm;

public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 构建最大堆（从最后一个非叶子节点开始调整堆）
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 依次取出堆顶元素，并重新调整堆
        for (int i = n - 1; i >= 0; i--) {
            // 将堆顶元素（最大值）与末尾元素交换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 调整剩余元素的堆结构
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // 假设当前父节点是最大值
        int left = 2 * i + 1; // 左子节点的索引
        int right = 2 * i + 2; // 右子节点的索引

        // 找到左右子节点中的最大值
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // 如果最大值不是当前父节点，则进行交换并递归调整子树
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
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
