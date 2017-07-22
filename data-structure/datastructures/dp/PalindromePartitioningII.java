package datastructures.dp;

/**
 * @author budongbai
 * @version 2017年5月13日下午9:03:06
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        int len = s.length();
        int[] cuts = new int[len + 1];
        boolean[][] matrix = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            cuts[i] = len - i;
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && j - i < 2 || matrix[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    matrix[i][j] = true;
                    cuts[i] = Math.min(cuts[i], cuts[j + 1] + 1);

                }
            }
        }
        return cuts[0] - 1;
    }

    public static void main(String[] args) {

    }
}
