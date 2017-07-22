package xiaomi;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月18日下午7:24:42 > 在开头和结尾都添加下划线； > 将“.”转化为下划线； >
 * 根据下面的规则识别出组件中的单词，并使用下划线将单词进行分隔（具体参照输入输出样例）： >
 * 第一个大写字母与后面连续的小写字母一起识别为一个单词，如果不以大写字母开头，则直接将连续的小写字母识别为一个单词； >
 * 连续的大写字母一起识别为一个单词，但是如果最后一个大写字母后面跟着小写字母，则最后一个大写字母不包含在内； >
 * 连续的数字一起识别为一个单词；
 * <p>
 * a my.ABC simple.HelloService MY.ASTParser12 样例输出 _A_ _MY_ABC_
 * _SIMPLE_HELLO_SERVICE_ _MY_AST_PARSER_12_
 */
public class Main1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            String s = scan.next();
            StringBuilder sb = new StringBuilder();
            //在开头和结尾都添加下划线；
            sb.append("_");
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isUpperCase(c)) {
                    sb.append(c);
                    int j = i + 1;
                    if (Character.isUpperCase(s.charAt(j))) {
                        //连续的大写字母一起识别为一个单词，但是如果最后一个大写字母后面跟着小写字母，则最后一个大写字母不包含在内；
                        while (Character.isUpperCase(s.charAt(j)) && j + 1 < s.length() && Character.isUpperCase(s.charAt(j + 1))) {
                            sb.append((char) s.charAt(j));
                            j++;
                        }
                        //最后一个字母是大写
                        if (j + 1 == s.length() && Character.isUpperCase(s.charAt(j))) {
                            sb.append(s.charAt(j));
                        } else if (Character.isUpperCase(s.charAt(j)) && j + 1 < s.length() && Character.isLowerCase(s.charAt(j + 1))) {
                            j--;
                        } else if (Character.isUpperCase(s.charAt(j)) && j + 1 < s.length() && s.charAt(j + 1) == '.') {
                            sb.append(s.charAt(j));
                            j++;
                        }

                    } else {
                        //第一个大写字母与后面连续的小写字母一起识别为一个单词，
                        while (j < s.length() && Character.isLowerCase(s.charAt(j))) {
                            sb.append((char) (s.charAt(j) + 'A' - 'a'));
                            j++;
                        }
                        j--;
                    }
                    i = j;
                    sb.append("_");

                } else if (Character.isLowerCase(c)) {
                    //如果不以大写字母开头，则直接将连续的小写字母识别为一个单词；
                    int j = i;
                    while (j < s.length() && Character.isLowerCase(s.charAt(j))) {
                        sb.append((char) (s.charAt(j) + 'A' - 'a'));
                        j++;
                    }
                    i = j;
                    sb.append("_");

                } else if (c == '.') {
                    //将“.”转化为下划线；
                    sb.append("_");
                } else if (Character.isDigit(c)) {
                    //连续的数字一起识别为一个单词；
                    int j = i + 1;
                    sb.append(c);
                    while (j < s.length() && Character.isDigit(s.charAt(j))) {
                        sb.append(s.charAt(j));
                        j++;
                    }
                    i = j;
                    sb.append("_");
                }
            }
            System.out.println(sb.toString());
        }

        scan.close();
    }

}
