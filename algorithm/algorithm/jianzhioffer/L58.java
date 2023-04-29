package algorithm.jianzhioffer;

public class L58 {
    public String reverseLeftWords(String s, int n) {
        char[] array = s.toCharArray();
        char[] res = new char[array.length];
        int j = array.length - n;
        for (int i = 0; i < array.length; i++) {
            if (i >= n) {
                res[i - n] = array[i];
            } else {
                res[j++] = array[i];
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(new L58().reverseLeftWords(s, 2));
    }
}
