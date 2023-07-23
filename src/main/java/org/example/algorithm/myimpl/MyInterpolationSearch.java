package org.example.algorithm.myimpl;

public class MyInterpolationSearch {

    public static int interpolationSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right && target >= arr[left] && target <= arr[right]) {
            int mid = (target - arr[left]) * (right - left) / (arr[right] - arr[left]) + left;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        return -1;
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
