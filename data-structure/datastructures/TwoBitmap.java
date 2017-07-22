package datastructures;

import java.util.Arrays;

/**
 * 在2.5亿个整数中找到不重复的数字的个数，内存不足以容纳这2.5个整数
 * 使用2bitmap实现，00表示不存在，01表示一次，11表示两次或两次以上,10无意义
 *
 * @author budongbai
 * @version 2017年4月15日下午7:10:33
 */
public class TwoBitmap {
    public static final int SHIFT = 4;
    public static final int MASK = 1;

    public static void setVal(int n, int[] arr) {
        int indexLoc, bitLoc;
        indexLoc = n >> SHIFT;
        bitLoc = (n % 16) << 1;
        int flag = getFlag(n, arr);
        if (flag == 0) {
            arr[indexLoc] |= 1 << (bitLoc + 1);//设置第bitLoc+1为1
        } else if (flag == 1) {
            arr[indexLoc] |= 1 << bitLoc;//设置第bitLoc为1
        }
    }

    public static void init(int n, int[] arr) {
        int indexLoc;
        indexLoc = n >> SHIFT;
        arr[indexLoc] &= 0;
    }

    public static int getFlag(int n, int[] arr) {
        int flag;
        int indexLoc = n >> SHIFT;
        int bitLoc = n % 16 << 1;
        flag = (arr[indexLoc] >> bitLoc & MASK) << 1 | arr[indexLoc] >> (bitLoc + 1) & MASK;
        return flag;
    }

    public static void main(String[] args) {

        int[] arr = new int[1];

        int[] a = {3, 5, 2, 4, 7, 5, 6, 7, 8, 10};
        for (int i = 0; i < a.length; i++) {
            setVal(a[i], arr);
        }
        int count = 0;
        for (int i = 0; i < 11; i++) {
            int flag = getFlag(i, arr);
            System.out.println("i=" + i + " " + flag);
            if (flag == 1) {
                count++;
            }
        }
        System.out.println(count);
        System.out.println(Arrays.toString(arr));
        System.out.println(Integer.toBinaryString(arr[0]));
    }

}
