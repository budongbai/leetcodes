package tests;

import java.util.Arrays;

/**
 * @author budongbai
 * @version 2017年9月21日上午9:14:15
 */
public class XiPaiGame {

    public static void main(String[] args) {

        int length = 54;
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = i + 1;
        }
        int index;
        int value;
        int median;

        if (null == array || 0 == length)
            return;
        for (index = 0; index < length; index++) {
            value = (int) (Math.random() * length);

            median = array[index];
            array[index] = array[value];
            array[value] = median;
        }
        System.out.println(Arrays.toString(array));
        /* 发牌的时候对于已经分配的数据不再修改 */
        for (index = 0; index < length; index++) {
            value = (int) (index + Math.random() * (length - index));
            median = array[index];
            array[index] = array[value];
            array[value] = median;
        }
        System.out.println(Arrays.toString(array));
    }

}
