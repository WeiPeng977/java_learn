package org.example.algorithm.myimpl;

public class MyBinarySearch {

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            // 找出数组中值，并比较目标，判断目标值在左右哪部分
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 9, 15, 19, 20, 23, 25, 30};
        int target = 25;

        int index = binarySearch(arr, target);
        if (index != -1) {
            System.out.println("目标元素 " + target + " 找到，位于索引位置 " + index);
        } else {
            System.out.println("目标元素 " + target + " 未找到");
        }
    }
}

