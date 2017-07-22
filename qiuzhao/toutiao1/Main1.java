package toutiao1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * P为给定的二维平面整数点集。定义 P 中某点x，如果x满足 P 中任意点都不在 x 的右上方区域内（横纵坐标都大于x），则称其为“最大的”。求出所有“最大的”点的集合。（所有点的横坐标和纵坐标都不重复, 坐标轴范围在[0, 1e9) 内）
 * 如下图：实心点为满足条件的点的集合。
 *
 * @author budongbai
 * @version 2017年8月22日下午6:36:29
 */
class Point implements Comparable<Point> {
    int x;
    int y;

    @Override
    public int compareTo(Point o) {

        if (this.x == o.x) {
            return this.y - o.y;
        }
        return this.x - o.x;
    }

}

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Point[] ps = new Point[n];
        for (int i = 0; i < n; i++) {
            ps[i] = new Point();
            ps[i].x = scan.nextInt();
            ps[i].y = scan.nextInt();
        }
        Arrays.sort(ps);
        int maxy = ps[n - 1].y;
        ArrayList<Integer> v1 = new ArrayList<Integer>();
        ArrayList<Integer> v2 = new ArrayList<Integer>();

        for (int i = n - 1; i >= 0; i--) {
            //x轴上x最大的肯定是最大点
            if (i == n - 1) {
                v1.add(ps[i].x);
                v2.add(ps[i].y);
            }
            //如果当前点的y小于最大的y，那么肯定不是最大点
            else if (ps[i].y < maxy) continue;
                //当前点的大于等于最大点，这种也是最大点
            else if (ps[i].y >= maxy) {
                maxy = ps[i].y;
                v1.add(ps[i].x);
                v2.add(ps[i].y);
            }
        }
        for (int i = v1.size() - 1; i >= 0; i--) {
            System.out.println(v1.get(i) + " " + v2.get(i));
        }
        //6 1 2 2 4 4 6 4 3 7 5 9 0
        scan.close();
    }
}



