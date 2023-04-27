package leetcodes101_150;

import java.util.ArrayList;
import java.util.List;

public class L119 {

    public List<Integer> generate(int numRows) {
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
        return ret.get(numRows - 1);
    }


    public List<Integer> generate2(int numRows) {
        List<Integer> pre = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> rows = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    rows.add(1);
                } else {
                    rows.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = rows;
        }
        return pre;
    }

    public List<Integer> generate3(int numRows) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= numRows; i++) {
            row.add((int) ((long) row.get(i - 1) * (numRows - i + 1) / i));
        }
        return row;
    }


    public static void main(String[] args) {
        List<Integer> ret = new L119().generate3(4);

        System.out.println(ret);

    }
}
