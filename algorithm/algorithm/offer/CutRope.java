package algorithm.offer;

/**
 * 剪绳子
 */
public class CutRope {
    public int cutRope(int target) {
        if (target == 0) {
            return 0;
        }
        if (target < 4) {
            return target - 1;
        }

        int[] products = new int[target + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        for (int i = 4; i <= target; i++) {

            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (product > max) {
                    max = product;
                }
                products[i] = max;
            }


        }
        return products[target];
    }

    public int cutRope2(int target) {
        if (target == 0) {
            return 0;
        }
        if (target < 4) {
            return target - 1;
        }

        int timesOf3 = target / 3;
        if ((target - timesOf3 * 3) == 1) {
            timesOf3 -= 1;
        }
        int timesOf2 = (target - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }

    public static void main(String[] args) {

        System.out.println(new CutRope().cutRope(8));
    }
}
