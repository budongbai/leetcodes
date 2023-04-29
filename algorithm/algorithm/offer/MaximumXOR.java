package algorithm.offer;

public class MaximumXOR {
    /**
     * 暴力解法超时
     *
     * @param nums
     * @return
     */
    public static int findMaximumXOR(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                res = Math.max(res, nums[i] ^ nums[j]);
            }
        }

        return res;
    }

    Trie root = new Trie();
    static final int BIT_LENGTH = 30;

    public int findMaximumXOR3(int[] nums) {
        int n = nums.length;

        int x = 0;
        for (int i = 1; i < nums.length; i++) {
            add(nums[i - 1]);
            x = Math.max(x, check(nums[i]));
        }
        return x;
    }

    private void add(int num) {
        Trie cur = root;

        for (int i = BIT_LENGTH; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if (bit == 0) {
                if (cur.left == null) {
                    cur.left = new Trie();
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = new Trie();
                }
                cur = cur.right;
            }
        }
    }

    private int check(int num) {
        Trie cur = root;
        int x = 0;
        for (int i = BIT_LENGTH; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if (bit == 0) {
                if (cur.right != null) {
                    cur = cur.right;
                    x = x * 2 + 1;
                } else {
                    cur = cur.left;
                    x = x * 2;
                }

            } else {
                if (cur.left != null) {
                    cur = cur.left;
                    x = x * 2 + 1;
                } else {
                    cur = cur.right;
                    x = x * 2;
                }
            }
        }
        return x;
    }

    static class Trie {
        Trie left = null;
        Trie right = null;
    }

    public static void main(String[] args) {
        int[] nums = {14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70};
        System.out.println(new MaximumXOR().findMaximumXOR3(nums));
    }
}
