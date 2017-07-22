package leetcodes51_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

/**
 * @author budongbai
 * @version 2017年7月12日下午7:46:48
 */
public class L56 {
    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> res = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        // java 8中，Lambda表达式的写法
        intervals.sort(Comparator.comparingInt(i -> i.start));
        Interval first = intervals.get(0);
        int lastStart = first.start, lastEnd = first.end;
        for (int i = 1; i < intervals.size(); i++) {

            Interval in = intervals.get(i);
            if (lastEnd >= in.start) {
                lastEnd = Math.max(lastEnd, in.end);
                lastStart = Math.min(lastStart, in.start);
            } else {
                res.add(new Interval(lastStart, lastEnd));
                lastStart = in.start;
                lastEnd = in.end;
            }
        }
        res.add(new Interval(lastStart, lastEnd));
        return res;
    }

    public List<Interval> merge2(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        // Sort by ascending starting point using an anonymous Comparator
        intervals.sort(Comparator.comparingInt(i -> i.start));

        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }

    /**
     * 首先，我们将列表中的区间按照左端点升序排序。然后我们将第一个区间加入 merged 数组中，并按顺序依次考虑之后的每个区间：
     * <p>
     * 如果当前区间的左端点在数组 merged 中最后一个区间的右端点之后，那么它们不会重合，我们可以直接将这个区间加入数组 merged 的末尾；
     * <p>
     * 否则，它们重合，我们需要用当前区间的右端点更新数组 merged 中最后一个区间的右端点，将其置为二者的较大值。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/merge-intervals/solution/he-bing-qu-jian-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param intervals
     * @return
     */
    public int[][] merge3(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }

        Arrays.sort(intervals, Comparator.comparingInt(num -> num[0]));

        List<int[]> res = new ArrayList<>();

        for (int[] interval : intervals) {
            int left = interval[0], right = interval[1];
            if (res.size() == 0 || res.get(res.size() - 1)[1] < left) {
                res.add(new int[]{left, right});
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], right);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {

        L56 test = new L56();
        List<Interval> intervals = new ArrayList<Interval>();
        /*
         * intervals.add(new Interval(1,3)); intervals.add(new Interval(2,6));
         * intervals.add(new Interval(8,10)); intervals.add(new
         * Interval(15,18));
         */
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(0, 0));
        List<Interval> list = test.merge(intervals);
        for (Interval in : list) {
            System.out.println(in.start + "," + in.end);
        }
    }

}
