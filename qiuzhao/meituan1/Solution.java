package meituan1;

import java.util.Scanner;

public class Solution {
    int n;

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int sumOfQuantities(int numItem, int[] ratioItems, int[] quantities) {
        for (int i = 0; i < ratioItems.length; i++) {
            if (ratioItems[i] > quantities[i]) {
                return 0;
            }
        }

        int max = max(ratioItems);

        int piece = quantities[max] / ratioItems[max];
        int count = ratioItems[max] * piece % 1000000007;
        for (int i = 0; i < numItem; i++) {
            if (i != max) {
                if (quantities[i] / ratioItems[i] < piece) {
                    return 0;
                } else {
                    count = (count + ratioItems[i] * piece) % 1000000007;
                }

            }
        }


        return count;
    }

    // METHOD SIGNATURE ENDS
    public static int max(int[] arr) {
        int max = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] rarr = new int[n];
        int[] qarr = new int[n];
        for (int i = 0; i < n; i++) {
            rarr[i] = scan.nextInt();
        }

        for (int i = 0; i < n; i++) {
            qarr[i] = scan.nextInt();
        }
        Solution test = new Solution();
        int count = test.sumOfQuantities(n, rarr, qarr);
        System.out.println(count);
        scan.close();
    }
}

