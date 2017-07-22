package lianjia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年8月19日下午6:30:52
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        List<Integer> set = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            }
        }
        System.out.println(set.size());
        set.sort(null);
        for (int i = 0; i < set.size(); i++) {
            if (i == set.size() - 1) {
                System.out.println(set.get(i));
            } else {
                System.out.print(set.get(i) + " ");
            }
        }
    }
}
