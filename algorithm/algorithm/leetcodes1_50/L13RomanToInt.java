package algorithm.leetcodes1_50;

/**
 * @author budongbai
 * @version 2017年6月29日下午1:37:40
 */
public class L13RomanToInt {
    public int romanToInt(String s) {
        int res = 0;
        int[] arri = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < arri.length; i++) {
            while (s.startsWith(strs[i])) {
                res += arri[i];
                s = s.substring(strs[i].length());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new L13RomanToInt().romanToInt("CDXII"));
    }

}
