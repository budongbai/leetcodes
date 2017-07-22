package souhu17;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年8月28日下午2:37:27
 */
public class Main11 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            StringBuilder yy = new StringBuilder();
            yy.append(sc.next());
            int cnt = sc.nextInt();
            int count = 0;
            int j = 0;
            while (count < cnt) {
                int len = yy.length() - 1;

                for (; j < len - 1; j++) {
                    if (yy.charAt(j) < yy.charAt(j + 1)) {
                        yy.deleteCharAt(j);
                        break;
                    }
                }
                if (j == len - 1)
                    yy.deleteCharAt(len - 1);
                count++; // 记录删除个数 
                j--;
            }
            System.out.println(yy);
        }

    }

}
