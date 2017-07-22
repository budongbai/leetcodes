package datastructures.dp;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年5月13日下午4:35:04
 */
public class MaxSum {
    public static void main(String[] args) {
        //	int [][] triangle ={{7},{3, 8 },{8, 1, 0 },{2, 7, 4, 4},{ 4, 5, 2, 6, 5}};

        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int len = scan.nextInt();
            int[][] triangle = new int[len][len];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j <= i; j++) {
                    triangle[i][j] = scan.nextInt();
                }
            }

            int[] max = new int[len];
            for (int i = 0; i < len; i++) {
                max[i] = triangle[len - 1][i];
            }

            for (int i = triangle.length - 2; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    max[j] = max[j] > max[j + 1] ? triangle[i][j] + max[j] : triangle[i][j] + max[j + 1];
                }
            }
            System.out.println(max[0]);
        }

    }

}
