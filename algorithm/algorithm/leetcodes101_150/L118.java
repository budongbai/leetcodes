package algorithm.leetcodes101_150;

import java.util.ArrayList;
import java.util.List;

public class L118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> rows = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    rows.add(1);
                } else {
                    rows.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(rows);
        }
        return ret;
    }

    public static void main(String[] args) {
        List<List<Integer>> ret = new L118().generate(5);

        System.out.println(ret);

    }
}
