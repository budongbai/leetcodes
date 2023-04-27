package leetcodes1_50;

/**
 * @author budongbai
 * @version 2017年7月5日下午4:47:46
 */
public class L29 {
    /**
     * @param dividend 被除数
     * @param divisor  除数
     * @return
     * @author budongbai
     * @version 2017年7月5日下午4:49:23
     */
    public int divide(int dividend, int divisor) {
        long res = 0;
        boolean flag = true;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            flag = !flag;
        }
        long ldd = Math.abs((long) dividend);
        long ldr = Math.abs((long) divisor);

        if (ldr == 0) return Integer.MAX_VALUE;
        if ((ldd == 0) || (ldd < ldr)) return 0;

        res = div(ldd, ldr);
        if (res > Integer.MAX_VALUE) {
            res = flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            res = flag ? res : -res;
        }
        return (int) res;
    }

    public long div(long dividend, long divisor) {
        if (dividend < divisor) return 0;
        long sum = divisor;
        long multiple = 1;
        while (sum + sum <= dividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + div(dividend - sum, divisor);
    }

    public static void main(String[] args) {
        L29 test = new L29();
        System.out.println(test.divide(Integer.MIN_VALUE, -1));
    }
}
