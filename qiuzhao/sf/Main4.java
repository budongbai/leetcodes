package sf;

/**
 * @author budongbai
 * @version 2017年9月20日下午4:50:22
 */
public class Main4 {
    public static void main(String[] args) {
        String a = "ab";
        String b = "abc";
        String c = "ab" + "c";
        String d = "a" + "bc";
        System.out.println(b == c);
        System.out.println(b == d);
        System.out.println(d == c);
    }
}
