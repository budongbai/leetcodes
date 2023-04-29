package algorithm.offer;

import java.util.Arrays;

public class ReorderOddEven {
    // 未保证相对顺序
    public int[] reOrderArray(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            // 奇数
            while (start < array.length && array[start] % 2 == 1) {
                start++;
            }
            // 偶数
            while (end >= 0 && array[end] % 2 == 0) {
                end--;
            }
            if (start < end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;
            }
        }
        return array;
    }

    // 未保证相对顺序
    public int[] reOrderArray2(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int start = 0;
        int end = 1;

        while (start < array.length && end < array.length) {
            // 奇数
            while (array[start] % 2 == 1) {
                start++;
            }
            // 偶数
            while (array[end] % 2 == 0) {
                end++;
            }
            if (start < end && start < array.length && end < array.length) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end++;
            }
        }
        return array;
    }

    // 未保证相对顺序
    public int[] reOrderArray3(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] % 2 == 1) {
                continue;
            }
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] % 2 == 1) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    break;
                }

            }
        }
        return array;
    }

    public int[] reOrderArray4(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int[] result = new int[array.length];
        int start = 0;
        int end = array.length - 1;

        int resultStart = start;
        int resultEnd = end;
        while (start < array.length && end >= 0) {
            // 奇数
            if (array[start] % 2 == 1) {
                result[resultStart] = array[start];
                resultStart++;
            }
            start++;
            // 偶数
            if (array[end] % 2 == 0) {
                result[resultEnd] = array[end];
                resultEnd--;
            }
            end--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5};

        ReorderOddEven demo = new ReorderOddEven();
        System.out.println(Arrays.toString(demo.reOrderArray(array)));
    }
}
