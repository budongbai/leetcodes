package ink;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年9月29日下午7:28:51
 */
public class Main4 {
    public static int[] cal(int[] a, int[] b) {
        int curIndexLength = 0;
        int endIndexLength = 0;
        int[] res = new int[2];
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j + i <= a.length; j++) {
                int start = j;
                int end = start + i;
                for (int n = 0; n < b.length; n++) {
                    if (a[start] == b[n]) {
                        if ((end - start) <= (b.length - n)) {
                            int tmpM = start;
                            int tmpN = n;
                            while (tmpM < end) {
                                if (a[tmpM] != b[tmpN]) {
                                    break;
                                }
                                tmpM++;
                                tmpN++;
                            }
                            if (tmpM == end) {
                                curIndexLength = end - start;
                                if (curIndexLength > endIndexLength) {
                                    endIndexLength = curIndexLength;
                                    res[0] = start;
                                    res[1] = end;
                                }

                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String s1 = scan.nextLine();
        String s2 = scan.nextLine();

        String ss1 = s1.substring(s1.indexOf(',') + 3, s1.length() - 2);
        String ss2 = s2.substring(s2.indexOf(',') + 3, s2.length() - 2);

        String[] sss1 = ss1.split(",\\s+");
        String[] sss2 = ss2.split(",\\s+");

        int[] nums1 = new int[sss1.length];
        int[] nums2 = new int[sss2.length];
        for (int i = 0; i < sss1.length; i++) {
            nums1[i] = Integer.parseInt(sss1[i]);
        }
        for (int i = 0; i < sss2.length; i++) {
            nums2[i] = Integer.parseInt(sss2[i]);
        }
        int[] res = cal(nums1, nums2);
        for (int i = res[0]; i < res[1]; i++) {
            if (i == res[1] - 1) {
                System.out.println(nums1[i]);
            } else {
                System.out.print(nums1[i] + ", ");
            }

        }
        scan.close();
    }

}
