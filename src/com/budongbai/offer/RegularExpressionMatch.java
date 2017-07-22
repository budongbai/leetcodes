package com.budongbai.offer;

/**
 * 正则表达式匹配
 */
public class RegularExpressionMatch {
    public boolean match(String str, String pattern) {

        if (str == null || pattern == null) {
            return false;
        }

        return matchCore(str, pattern, 0, 0);

    }

    private boolean matchCore(String str, String pattern, int strCur, int patternCur) {
        // 都到尾了
        if (strCur == str.length() && patternCur == pattern.length()) {
            return true;
        }
        // 字符串没到尾，但模式串已经到了尾
        if (strCur != str.length() && patternCur == pattern.length()) {
            return false;
        }
        // 如果模式串下一个字符是*
        boolean flag = strCur != str.length() && (str.charAt(strCur) == pattern.charAt(patternCur)
            || pattern.charAt(patternCur) == '.');
        if (patternCur + 1 < pattern.length() && pattern.charAt(patternCur + 1) == '*') {
            // 如果当前字符匹配
            if (flag) {
                // 匹配了0个字符
                return matchCore(str, pattern, strCur, patternCur + 2) ||
                    // 匹配了1个字符，忽略*
                    matchCore(str, pattern, strCur + 1, patternCur + 2) ||
                    // 匹配了1个字符，继续匹配*
                    matchCore(str, pattern, strCur + 1, patternCur);
            } else {
                // 没匹配上，直接忽略*
                return matchCore(str, pattern, strCur, patternCur + 2);
            }
        }

        // 当前字符匹配
        if (flag) {
            return matchCore(str, pattern, strCur + 1, patternCur + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        RegularExpressionMatch demo = new RegularExpressionMatch();
        System.out.println(demo.match("bcbbabab", ".*a*a"));
    }
}
