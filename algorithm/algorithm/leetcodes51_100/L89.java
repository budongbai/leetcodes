package algorithm.leetcodes51_100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author budongbai
 * @version 2017年8月6日下午10:41:52
 */
public class L89 {
    // 每次从最低位开始，如果最低位取反得到的结果没有被访问过，则加入结果链表中，否则取下一位的反
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        if (n == 0) {
            return res;
        }
        boolean[] vis = new boolean[(int) Math.pow(2, n)];
        vis[0] = true;
        for (int i = 1; i < 1 << n; i++) {
            int num = res.get(res.size() - 1);
            int num2 = num ^ 1;
            int j = 1;
            while (vis[num2]) {
                num2 = num ^ (1 << j);
                j++;
            }
            num = num2;
            vis[num] = true;
            res.add(num);
        }
        return res;
    }

    public List<Integer> grayCode2(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1 << n; i++) {
            //System.out.println( Integer.toBinaryString(i)+ ", "+Integer.toBinaryString(i>>1));
            result.add(i ^ i >> 1);
        }
        return result;
    }

    public static void main(String[] args) {
        L89 test = new L89();
        List<Integer> res = test.grayCode2(6);
        for (int i : res) {
            System.out.println(i + "," + Integer.toBinaryString(i));
        }

    }
}
