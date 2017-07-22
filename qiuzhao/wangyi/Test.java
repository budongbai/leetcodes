package wangyi;

import java.util.Arrays;

/**
 * @author budongbai
 * @version 2017年8月12日下午10:16:51
 */
public class Test {
    public static void main(String[] args) {
        String s = "11111111111|www";
        String[] ss = s.split("\\|");

        System.out.println(Arrays.toString(ss));
    }
}
