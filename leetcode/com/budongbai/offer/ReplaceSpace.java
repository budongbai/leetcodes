

package com.budongbai.offer;

public class ReplaceSpace {

    public static String replace(String s) {
        return s.replace(" ", "%20");
    }

    public static String replace2(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

    }
}
