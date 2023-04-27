package leetcodes1_50;

/**
 * @author budongbai
 * @version 2017年6月16日上午10:56:37
 */
public class L9回文数 {

    /**
     * 没有额外空间，判断一个整数是否为回文整数
     *
     * @param x
     * @return
     * @author budongbai
     * @version 2017年6月16日上午10:57:13
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        return x == reverse(x);
    }

    public long reverse(int x) {
        long res = 0;
        while (x != 0) {
            int tmp = x % 10;
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
    }

    //机智解法，不除到个位上，防溢出
    public boolean isPalindrome2(int x) {

        if (x < 0) {
            return false;
        }

        int p = x;
        int q = 0;

        while (p >= 10) {
            q *= 10;
            q += p % 10;
            p /= 10;
        }

        return q == x / 10 && p == x % 10;
    }


    public boolean isPalindrome3(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public static void main(String[] args) {

        L9回文数 test = new L9回文数();

        System.out.println(test.isPalindrome(121));
        System.out.println(test.isPalindrome(122));
        System.out.println(test.isPalindrome(12121));
        System.out.println(test.isPalindrome(12221));
    }

}
