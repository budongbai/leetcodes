package com.budongbai.offer;

public class MinInRotateArray {

    public static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = left;
        while (array[left] >= array[right]) {
            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = (right - left) / 2 + left;


            if (array[left] == array[right] && array[left] == array[mid]) {
                int result = array[left];
                for (int i = left + 1; i <= right; i++) {
                    if (result > array[i]) {
                        result = array[i];
                    }
                }
                return result;
            }
            if (array[mid] >= array[left]) {
                left = mid;
            } else if (array[mid] <= array[right]) {
                right = mid;
            }

        }
        return array[mid];
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 2, 2, 3, 4, 6, 7};

        System.out.println(minNumberInRotateArray(array));
    }
}
