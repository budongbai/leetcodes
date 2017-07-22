package datastructures.dp;

import java.util.ArrayList;

/**
 * @author budongbai
 * @version 2017年5月13日下午8:49:25
 */
public class TriangleMinSum {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int len = triangle.size();
        int[] min = new int[len];
        for (int i = 0; i < len; i++) {
            min[i] = triangle.get(len - 1).get(i);
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                min[j] = min[j] < min[j + 1] ? triangle.get(i).get(j) + min[j] : triangle.get(i).get(j) + min[j + 1];
            }
        }
        return min[0];
    }
}
