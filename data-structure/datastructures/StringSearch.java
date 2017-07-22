package datastructures;

import java.util.Arrays;

/**
 * @author budongbai
 * @version 2017年4月15日下午7:50:52
 */
public class StringSearch {

    public static int forceSearch(String string, String pattern) {
        char[] chs = string.toCharArray();
        char[] p = pattern.toCharArray();

        for (int i = 0; i < chs.length; i++) {
            int k = i;
            int j = 0;
            while (j < p.length && k < chs.length && chs[k] == p[j]) {
                k++;
                j++;
            }
            if (j == p.length) {
                return i;
            }
        }
        return -1;
    }

    /**
     * KMP算法，模式匹配
     *
     * @param string
     * @param pattern
     * @return
     * @author budongbai
     * @version 2017年4月15日下午8:02:00
     */
    public static int kmp(String string, String pattern) {
        int[] next = getNext(pattern);
        char[] s = string.toCharArray();
        char[] p = pattern.toCharArray();
        int i = 0, j = 0;
        while (i != s.length && j != p.length) {
            if (j == -1 || s[i] == p[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        return j == p.length ? i - j : -1;
    }

    public static int[] next(String pattern) {
        int i, j;
        int m = pattern.length();
        int[] next = new int[m];
        char[] x = pattern.toCharArray();
        i = 0;
        j = next[0] = -1;
        while (i < m - 1) {
            while (j > -1 && x[i] != x[j])
                j = next[j];
            i++;
            j++;
            if (x[i] == x[j])
                next[i] = next[j];
            else
                next[i] = j;
        }
        return next;
    }

    public static int[] getNext(String pattern) {
        char[] p = pattern.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int i = 0, j = -1;

        while (i != p.length - 1) {
            // 这里注意，i==0的时候实际上求的是next[1]的值，以此类推
            //这里其实每次都是比对p的开头字母与i位置的字母，
            //要么是从头开始比，要么有公共子串，j记录的就是公共子串长度，每相等一个，就++
            if (j == -1 || p[i] == p[j]) {
                ++i;
                ++j;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public static void preBmBc(char[] x, int m, int bmBc[]) {
        int i;

        for (i = 0; i < x.length; ++i)

            bmBc[i] = m;

        for (i = 0; i < m - 1; ++i)

            bmBc[x[i]] = m - i - 1;

    }

    /**
     * 以i为边界，与模式串后缀匹配的最大长度
     *
     * @param x
     * @param m
     * @param suff
     * @author budongbai
     * @version 2017年4月16日下午3:32:14
     */
    public static void suffixes(char[] x, int m, int[] suff) {
        suff[m - 1] = m;
        for (int i = m - 2; i >= 0; --i) {
            int q = i;
            while (q >= 0 && x[q] == x[m - 1 - i + q])
                --q;
            suff[i] = i - q;
        }
    }

    /**
     * 计算遇到好后缀时，模式串应该移动的距离，其中i表示好后缀前面的一个字符的位置，也就是坏字符的位置
     *
     * @param x
     * @param m
     * @param bmGs
     * @author budongbai
     * @version 2017年4月16日下午3:04:54
     */
    public static void preBmGs(char[] x, int m, int[] bmGs) {
        int[] suff = new int[x.length];
        int i, j;
        suffixes(x, m, suff);
        for (i = 0; i < m; ++i)
            bmGs[i] = m;
        j = 0;
        for (i = m - 1; i >= 0; --i)
            if (suff[i] == i + 1)
                for (; j < m - 1 - i; ++j)
                    if (bmGs[j] == m)
                        bmGs[j] = m - 1 - i;
        for (i = 0; i <= m - 2; ++i)
            bmGs[m - 1 - suff[i]] = m - 1 - i;
    }

    public static final int ASIZE = 256;

    //ASIZE是指字符种类个数，为了方便起见，就直接把ASCII表中的256个字符全表示了，这样就不会漏掉哪个字符了。
    public static void bm(char[] x, int m, char[] y, int n) {
        int i, j;
        int[] bmGs = new int[x.length], bmBc = new int[ASIZE];

        /* Preprocessing */
        preBmGs(x, m, bmGs);
        preBmBc(x, m, bmBc);
        System.out.println(Arrays.toString(bmGs) + Arrays.toString(bmBc));
        /* Searching */
        j = 0;
        while (j <= n - m) {
            for (i = m - 1; i >= 0 && x[i] == y[i + j]; --i) ;
            if (i < 0) {
                System.out.println(j);
                j += bmGs[0];
            } else
                j += Math.max(bmGs[i], bmBc[y[i + j]] - m + 1 + i);
        }
    }

    public static void main(String[] args) {

        String str = "GCATCGCAGAGAGTATACAGTACG";
        String p = "GCAGAGAG";
        System.out.println(forceSearch(str, p));
        System.out.println(kmp(str, p));
        bm(p.toCharArray(), p.length(), str.toCharArray(), str.length());

        String p2 = "xyxyyxxyx";
        int[] a = next(p2);
        System.out.println(Arrays.toString(a));
        int[] a2 = getNext(p2);
        System.out.println(Arrays.toString(a2));
    }

}
