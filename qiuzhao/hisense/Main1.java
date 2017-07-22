package hisense;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月19日下午4:26:54
 */
public class Main1 {
    public static int count2(int n) {
        int count = 0;// 统计变量
        int factor = 1;// 分解因子
        int lower = 0;// 当前处理位的所有低位
        int higher = 0;// 当前处理位的所有高位
        int curr = 0;// 当前处理位

        while (n / factor != 0) {
            lower = n - n / factor * factor;// 求得低位
            curr = (n / factor) % 10;// 求当前位
            higher = n / (factor * 10);// 求高位

            switch (curr) {
                case 0:
                    count += higher * factor;
                    break;
                case 1:
                    count += higher * factor + lower + 1;
                    break;
                default:
                    count += (higher + 1) * factor;
            }
            System.out.println(count + "," + higher + "," + lower + "," + factor + ", " + curr);
            factor *= 10;
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(count2(n));
        HashMap map = new HashMap();
        ArrayList list = new ArrayList();
    }

}
