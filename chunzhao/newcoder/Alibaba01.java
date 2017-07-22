package newcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年7月18日下午3:34:16
 */
public class Alibaba01 {
    public static Long guessMyPath(List<Long[]> dimList) {
        if (dimList == null || dimList.size() == 0) {
            return 0L;
        }
        //有部分是不满足最近距离的
        dimList.sort(new Comparator<Long[]>() {
            @Override
            public int compare(Long[] o1, Long[] o2) {
        
                int c4 = o1[4].compareTo(o2[4]);
                if (c4 != 0) {
                    return c4;
                }
                int c3 = o1[3].compareTo(o2[3]);
                if (c3 != 0) {
                    return c3;
                }
                int c2 = o1[2].compareTo(o2[2]);
                if (c2 != 0) {
                    return c2;
                }
                int c1 = o1[1].compareTo(o2[1]);
                if (c1 != 0) {
                    return c1;
                }
                int c0 = o1[0].compareTo(o2[0]);
                return c0;
            }

        });
        for (int i = 0; i < dimList.size(); i++) {
            Long[] ss = dimList.get(i);
            System.out.println(Arrays.toString(ss));
        }
        Long[] nums = dimList.get(0);
        Long last1 = nums[0];
        Long last2 = nums[1];
        Long last3 = nums[2];
        Long last4 = nums[3];
        Long last5 = nums[4];
        Long min = last1 + last2 + last3 + last4 * 10 + last5 * 100;
        for (int i = 1; i < dimList.size(); i++) {
            nums = dimList.get(i);
            Long sum = Math.abs(nums[0] - last1) + Math.abs(nums[1] - last2) + Math.abs(nums[2] - last3) + Math.abs(nums[3] - last4) * 10 + Math.abs(nums[4] - last5) * 100;
            min += sum;
            last1 = nums[0];
            last2 = nums[1];
            last3 = nums[2];
            last4 = nums[3];
            last5 = nums[4];
        }
        min += last1 + last2 + last3 + last4 * 10 + last5 * 100;
        return min;
    }

    /*
     * 浩瀚的宇宙，是否存在与我们世界相似的平行世界呢？自古以来，探索宇宙一直是人类的一个愿望。我们已知的是，我们的一生生活在四维空间里，这四维分别是横轴
     * 、纵轴、高度、时间。而我们不能确认也不能否认有五维空间的存在，第五维我们暂且称之为曲率。 假设宇宙是五维的，而你在{ 0L, 0L, 0L,
     * 0L, 0L } 这一空间，拥有时空穿梭的技能。但是如果进行时空移动需要耗费一定的燃料。 在横轴、纵轴、高度
     * 三维间移动是根据移动单位燃料单位为1. 在时间穿梭方面，移动单位燃料单位为10； 在曲率维度移动单位燃料为100；
     * 每次移动距离不限，但是维度唯一，即要么是横轴、要么纵轴，不能斜向移动。
     * 在宇宙中，有n个你的同伴在等待你解救，他们的坐标系统会提供给你，你需要移动到这些坐标解救他们，并回到你的位置。请你计算输出最小燃料是多少？
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Long res;
        int dimension_size = Integer.parseInt(in.nextLine().trim());
        List<Long[]> dimList = new ArrayList<Long[]>();

        for (int _dimension_i = 0; _dimension_i < dimension_size; _dimension_i++) {
            Long[] dimension_item = new Long[5];
            String dimItemStr = in.nextLine().trim();
            String[] dimItemStrs = dimItemStr.split(" ");
            for (int j = 0; j < 5; j++) {
                dimension_item[j] = Long.parseLong(dimItemStrs[j]);
            }
            dimList.add(dimension_item);
        }
        res = guessMyPath(dimList);
        System.out.println(res);
    }
}
