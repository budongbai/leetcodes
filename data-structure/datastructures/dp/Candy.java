package datastructures.dp;

import java.util.Arrays;

/**
 * There are N children standing in a line. Each child is assigned a rating
 * value. You are giving candies to these children subjected to the following
 * requirements: Each child must have at least one candy. Children with a higher
 * rating get more candies than their neighbors. What is the minimum candies you
 * must give?
 * 两次遍历，从左到右的遍历保证，满足比左边大一
 * 右到左的遍历保证，满足比右边大一
 *
 * @author budongbai
 * @version 2017年5月13日下午8:16:27
 */
public class Candy {
    public int candy(int[] ratings) {
        int[] count = new int[ratings.length];

        for (int i = 0; i < count.length; i++) {
            count[i] = 1;
        }
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                if (count[i] <= count[i - 1])
                    count[i] = count[i - 1] + 1;
            } else if (ratings[i] < ratings[i - 1]) {
                if (count[i] >= count[i - 1]) {
                    count[i - 1] = count[i] + 1;
                }

            }
        }
        System.out.println(Arrays.toString(count));
        System.out.println(Arrays.toString(ratings));
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i] > ratings[i - 1]) {
                if (count[i] <= count[i - 1])
                    count[i] = count[i - 1] + 1;
            } else if (ratings[i] < ratings[i - 1]) {
                if (count[i] >= count[i - 1]) {
                    count[i - 1] = count[i] + 1;
                }

            }
        }
        System.out.println(Arrays.toString(count));
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum += count[i];
        }
        return sum;
    }

    public static void main(String[] args) {

        int[] r = {7, 3, 8, 1, 0, 2, 7, 4, 5, 2, 6, 5};
        Candy test = new Candy();
        test.candy(r);
    }

}
