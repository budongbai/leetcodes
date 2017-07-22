package toutiao;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年4月18日下午7:12:32
 */
public class Toutiao201702T {
    public static final int SHIFT = 5;
    public static final int MASK = 1;

    public static void setVal(long n, int[] arr) {
        int indexLoc, bitLoc;
        indexLoc = (int) (n >> SHIFT);

        bitLoc = (int) (n % 32);
        arr[indexLoc] |= 1 << bitLoc;//设置滴bitLoc位为1
    }

    public static int getFlag(int n, int[] arr) {
        int flag;
        int indexLoc = n >> SHIFT;
        int bitLoc = n % 32;
        flag = arr[indexLoc] >> bitLoc & MASK;
        return flag;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {

            long num = scan.nextLong();
            HashSet<Long> set = new HashSet<Long>();
            while (num != 0) {
                set.add(num);
                num = scan.nextLong();
            }
            System.out.println(set.size());

        }
        scan.close();
    }
}
