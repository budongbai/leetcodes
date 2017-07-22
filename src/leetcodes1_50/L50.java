package leetcodes1_50;

/**
 * @author budongbai
 * @version 2017年7月12日下午12:21:06
 */
public class L50 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        int i = 1;
        boolean flag = true;
        if (n < 0) {
            flag = false;
            n = -n;
        }
        double res = x;
        while (i < n) {
            res *= x;
            i++;
        }
        return flag ? res : 1 / res;
    }

    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        //这种做法会导致n为Integer.Min_Value时，出现错误。
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return n % 2 == 0 ? myPow2(x * x, n / 2) : x * myPow2(x * x, n / 2);
    }

    public double myPow3(double x, int n) {
        double temp = x;
        if (n == 0) {
            return 1;
        }
        temp = myPow3(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            if (n > 0) {
                return temp * temp * x;
            } else {
                return temp * temp / x;
            }
        }
    }

    public static void main(String[] args) {
        L50 test = new L50();
        System.out.println(test.myPow3(5, 2));
    }
}
