

package algorithm.offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 数组中重复的数字
 * <p>
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。
 * 请找出数组中任一一个重复的数字。
 * 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，那么对应的输出是2或者3。
 * 存在不合法的输入的话输出-1
 */
public class ArrayRepeatNumber {
    private static int getRepeatNumber(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (set.contains(number)) {
                return number;
            }
            set.add(number);
        }
        return -1;
    }


    private static int getRepeatNumber2(int[] numbers) {
        Arrays.sort(numbers);
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] == numbers[i]) {
                return numbers[i];
            }
        }
        return -1;
    }

    /**
     * 因为数组的数值都在0~n-1之间，所以，如果这个数组没有重复数字的话，就会得到一个数组下标与当前下标对应元素的值一样的数组。即
     * 下标：      0 1 2 3 4 5
     * 数组元素：   0 1 2 3 4 5
     * 遍历数组，如果当前下标对应元素的值与下标不同，则将当前下标对应元素的值替换到对应的下标。
     * 如： 2 3 1 0 2 3
     * 替换 1 3 2 0 2 3
     * 替换 3 1 2 0 2 3
     * 替换 0 1 2 3 2 3
     * 遍历，发现下标为4时，对应元素为2，而下标为2的元素已经是2了，则说明2重复了
     *
     * @param numbers
     * @return
     */
    private static int getRepeatNumber3(int[] numbers) {
        int i = 0;
        while (i < numbers.length) {
            if (numbers[i] == i) {
                i++;
                continue;
            }
            // 当前下标对应的元素的值
            int temp = numbers[i];
            if (numbers[temp] == temp) {
                return temp;
            }
            numbers[i] = numbers[temp];
            numbers[temp] = temp;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] numbers = {2, 3, 4, 0, 2, 3};
        System.out.println(getRepeatNumber3(numbers));
    }
}
