package algorithm.leetcodes101_150;

public class L371 {
    public int getSum(int a, int b) {
        int x = a & b;
        // 没有进位数,合并
        if (x == 0) {
            return a | b;
        } else {
            // 进位
            x <<= 1;
            // 非进位合并
            int y = a ^ b;
            return getSum(x, y);
        }
    }

    public int getSum2(int a, int b) {
        int sum = 0;
        for (int i = 0, t = 0; i < 32; i++) {
            // 取第i位值
            int b1 = (a >> i) & 1, b2 = (b >> i) & 1;

            if (b1 == 1 && b2 == 1) {
                sum |= (t << i);
                t = 1;
            } else if (b1 == 1 || b2 == 1) {
                // 如果当前位有一个为1，且进位为1，则当前位为0，进位为1
                // 如果当前位有一个为1，且进位为0，则当前位位1，进位为0
                sum |= ((t ^ 1) << i);
            } else {
                // 两个数的当前位都为0，进位为0
                sum |= (t << i);
                t = 0;
            }
        }
        return sum;
    }

}
