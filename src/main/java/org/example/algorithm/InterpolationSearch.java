package org.example.algorithm;

public class InterpolationSearch {

    public static int interpolationSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right && target >= arr[left] && target <= arr[right]) {
            // 根据插值公式计算mid，使得元素更接近目标值
            int mid = left + (target - arr[left]) * (right - left) / (arr[right] - arr[left]);

            if (arr[mid] == target) {
                return mid; // 找到目标元素，返回索引位置
            } else if (arr[mid] < target) {
                left = mid + 1; // 目标元素在右半部分，缩小查找范围为[mid+1, right]
            } else {
                right = mid - 1; // 目标元素在左半部分，缩小查找范围为[left, mid-1]
            }
        }

        return -1; // 没有找到目标元素，返回-1表示未找到
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 9, 15, 19, 20, 23, 25, 30};
        int target = 25;

        int index = interpolationSearch(arr, target);
        if (index != -1) {
            System.out.println("目标元素 " + target + " 找到，位于索引位置 " + index);
        } else {
            System.out.println("目标元素 " + target + " 未找到");
        }
    }
}
