package algorithm.offer;

public class NumberOf1 {
    public int NumberOf1(int n) {
        int count = 0;

        int flag = 1;
        while (flag > 0) {
            if ((n & flag) == 1) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }

    public int hammingWeight2(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        new NumberOf1().hammingWeight(4);
    }
}
