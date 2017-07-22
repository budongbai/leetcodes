package newcoder;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年3月23日下午8:14:57
 */
public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        String[] strs = new String[number];
        for (int i = 0; i < number; i++) {
            strs[i] = scan.next();
        }
        int[][] result = new int[number][26];
        // System.out.println((int)'a' + " "+ (int)'A');
        for (int i = 0; i < number; i++) {
            char[] array = strs[i].toCharArray();
            for (int j = 0; j < array.length; j++) {
                result[i][array[j] - 97]++;
            }
        }
        int size = 0;

        for (int i = 0; i < number - 1; i++) {
            for (int j = 0; j < 26; j++) {
                if (result[i][j] != result[i + 1][j]) {
                    size++;
                    break;
                }

            }
        }
        System.out.println(size);
        scan.close();
    }

}
