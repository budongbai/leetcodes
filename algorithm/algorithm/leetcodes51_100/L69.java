package algorithm.leetcodes51_100;

/**
 * @author budongbai
 * @version 2017年7月16日下午3:36:08
 */
public class L69 {
    public int mySqrt(int x) {
        long r = x;
        while (r * r > x)
            r = (r + x / r) / 2;
        return (int) r;
    }

    public int mySqrt2(int x) {
        long begin = 0;
        long end = ((long) x + 1) / 2;
        long mid = 0;
        long tmp = 0;
        //二分搜索
        while (begin < end) {
            mid = begin + (end - begin) / 2;
            tmp = mid * mid;
            if (tmp == x)
                return (int) mid;
            else if (tmp < x)
                begin = mid + 1;
            else
                end = mid - 1;
        }
        tmp = end * end;
        if (tmp > x)
            return (int) end - 1;
        else
            return (int) end;
    }

    public static void main(String[] args) {
        L69 test = new L69();
        int res = test.mySqrt2(2147483647);
        System.out.println(res);
    }
}
