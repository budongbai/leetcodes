package leetcodes51_100;

/**
 * @author budongbai
 * @version 2017年7月13日下午12:09:09
 */
public class L58 {
    public int lengthOfLastWord(String s) {
        //可能字符串末尾有空格，因此用trim函数去除多余的空格
        s = s.trim();
        //如果字符串为空，或长度为0，则结果为0
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        //找到第一个为空字符的index，n-i-1即最后单词的长度
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return n - i - 1;
            }
        }
        //如果没找到空字符，则长度为n
        return n;
    }

    public static void main(String[] args) {
        L58 test = new L58();
        int res = test.lengthOfLastWord("Hello world");
        System.out.println(res);
    }
}
