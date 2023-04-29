package algorithm.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    List<String> rec;
    boolean[] vis;

    public String[] permutation(String s) {
        int n = s.length();
        rec = new ArrayList<>();
        vis = new boolean[n];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuffer perm = new StringBuffer();
        backtrack(arr, 0, n, perm);
        int size = rec.size();
        String[] recArr = new String[size];
        for (int i = 0; i < size; i++) {
            recArr[i] = rec.get(i);
        }
        return recArr;
    }

    public void backtrack(char[] arr, int i, int n, StringBuffer perm) {
        // 够长度了，就可以返回了
        if (i == n) {
            rec.add(perm.toString());
            return;
        }
        for (int j = 0; j < n; j++) {
            // 剪枝条件，第j个字符被访问过了，跳过
            // 或者是第j个字符和第j-1个字符相等，并且前一个字符没有被访问，剪掉，因为在另一个全排列中肯定被访问过了
            if (vis[j] || (j > 0 && !vis[j - 1] && arr[j - 1] == arr[j])) {
                continue;
            }
            vis[j] = true;
            perm.append(arr[j]);
            // 递归下一个字符
            backtrack(arr, i + 1, n, perm);
            // 回溯
            perm.deleteCharAt(perm.length() - 1);
            vis[j] = false;
        }
    }
}
