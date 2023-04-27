

package com.budongbai.offer;

/**
 * 不修改数组找到重复的数字
 * <p>
 * 在一个长度为n+1的数组里的所有数字都在1~n的范围里，所以数组中至少有一个数字是重复的。
 * 请找出数组中任意一个重复的数字，但不能修改输入的数组。
 * 例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的输出是重复的数字2或3
 */
public class ArrayRepeatNumber2 {

    /**
     * 利用二分查找法，计算左半段数组在左半段下标的数量，如果数量超过左半段区间长度，
     * 则说明，左边有重复的数字，进行二分查找，直到找到左右游标相等时，如果此时count> 1，说明当前下标数字重复
     *
     * @param numbers
     * @return
     */
    public static int getRepeatNumber(int[] numbers) {

        int left = 1, right = numbers.length - 1;

        while (right >= left) {

            int middle = ((right - left) >> 1) + left;
            int count = countRange(numbers, left, middle);

            if (left == right) {
                if (count > 1) {
                    return left;
                } else {
                    break;
                }
            }


            if (count > middle - left + 1) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    private static int countRange(int[] numbers, int start, int end) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] <= end && numbers[i] >= start) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 5, 4, 3, 2, 6, 7};

        System.out.println(getRepeatNumber(numbers));
    }
}
