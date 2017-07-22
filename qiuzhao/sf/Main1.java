package sf;
/**
 * @author budongbai
 * @version 2017年9月20日下午3:00:42
 */

import java.util.Scanner;

public class Main1 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int[] solve(int[] a) {
        int[] b = new int[a.length];
        b[a.length - 1] = a[a.length - 1];
        boolean flag = true;
        for (int i = a.length - 2; i >= 0; i--) {
            b[i] = a[i];
            int j = i + 1;
            flag = true;
            while (j < a.length) {
                if (flag) {
                    b[i] += b[j];
                    flag = false;
                } else {
                    b[i] -= b[j];
                    flag = true;
                }
                j++;
            }
        }
        return b;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] res;

        int _a_size = 0;
        _a_size = Integer.parseInt(in.nextLine().trim());
        int[] _a = new int[_a_size];
        int _a_item;
        for (int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(in.nextLine().trim());
            _a[_a_i] = _a_item;
        }

        res = solve(_a);
        for (int res_i = 0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}
