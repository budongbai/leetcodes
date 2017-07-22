package pingan;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月21日下午9:27:54
 */
public class Main1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] ss = s.split(",");
        int[] money = {1, 5, 10, 20, 50, 100};
        int n = Integer.parseInt(ss[0].substring(2));
        int[] count = new int[n];
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            count[i] = Integer.parseInt(ss[i + 1].substring(3));
            sum += count[i] * money[i];
        }
        System.out.println(sum);
        if (sum < n) {
            System.out.println(0);
        } else if (sum == n) {
            System.out.println(1);
        } else {
            int num = 0;

            for (int i = 0; i < 6; i++) {

            }
        }

        //n=100,a1=0,s2=0,a3=5,a4=6,a5=3,a6=2
    }

}
