package leetcodes101_150;

public class L650 {
    public int minSteps(int n) {
        int ans = 0;
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                n = n / i;
                ans += i;
            }
        }

        if (n != 0) {
            return ans + n;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new L650().minSteps(6));
    }
}
