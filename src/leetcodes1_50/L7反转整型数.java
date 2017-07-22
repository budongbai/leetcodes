package leetcodes1_50;

/**
 * @author budongbai
 * @version 2017年6月15日下午2:39:00
 */
public class L7反转整型数 {

    public int reverse(int x) {
        StringBuffer sb = new StringBuffer();
        if (x < 0) {
            x = -x;
            sb.append("-");
        }

        while (x != 0) {
            int tmp = x % 10;
            sb.append(tmp);
            x /= 10;
        }
        int res = 0;
        try {
            res = Integer.parseInt(sb.toString());
        } catch (Exception e) {
            return 0;
        }
        return res;
    }

    public int reverseByJiZhi(int x) {
        int result = 0;
        while (x != 0) {
            int tmp = x % 10;
            int newResult = result * 10 + tmp;
            //通过比较（新结果-tmp）/10得到结果是不是等于result，来判断是否溢出
            if ((newResult - tmp) / 10 != result) {
                return 0;
            }
            result = newResult;
            x /= 10;
        }
        return result;
    }

    public static void main(String[] args) {

        L7反转整型数 test = new L7反转整型数();
        test.reverse(-2147483412);
        test.reverse(1534236469);
    }

}
