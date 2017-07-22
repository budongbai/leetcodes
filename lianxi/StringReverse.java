/**
 * @author budongbai
 * @version 2017年10月11日上午9:47:40
 */
public class StringReverse {

    public static String reverseString(String str) {
        char[] res = new char[str.length()];

        for (int i = 0; i < str.length() / 2; i++) {
            res[str.length() - 1 - i] = str.charAt(i);
            res[i] = str.charAt(str.length() - 1 - i);
        }
        return new String(res);
    }

    public static void main(String[] args) {

        String s = "abcdefghij";
        System.out.println(reverseString(s));
    }

}
