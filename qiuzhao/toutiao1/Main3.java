package toutiao1;

import java.util.Scanner;

/**
 * 产品经理(PM)有很多好的idea，而这些idea需要程序员实现。现在有N个PM，在某个时间会想出一个 idea，每个 idea 有提出时间、所需时间和优先等级。对于一个PM来说，最想实现的idea首先考虑优先等级高的，相同的情况下优先所需时间最小的，还相同的情况下选择最早想出的，没有 PM 会在同一时刻提出两个 idea。
 * 同时有M个程序员，每个程序员空闲的时候就会查看每个PM尚未执行并且最想完成的一个idea,然后从中挑选出所需时间最小的一个idea独立实现，如果所需时间相同则选择PM序号最小的。直到完成了idea才会重复上述操作。如果有多个同时处于空闲状态的程序员，那么他们会依次进行查看idea的操作。
 * 求每个idea实现的时间。
 * 输入
 * 输入第一行三个数N、M、P，分别表示有N个PM，M个程序员，P个idea。随后有P行，每行有4个数字，分别是PM序号、提出时间、优先等级和所需时间。
 * 所有输入数据范围为 [1, 3000]
 * 输出
 * 输出P行，分别表示每个idea实现的时间点。
 * <p>
 * 样例输入
 * 2 2 5
 * 1 1 1 2
 * 1 2 1 1
 * 1 3 2 2
 * 2 1 1 2
 * 2 3 5 5
 * 样例输出
 * 3
 * 4
 * 5
 * 3
 * 9
 *
 * @author budongbai
 * @version 2017年8月22日下午6:36:29
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {


        }
        scan.close();
    }
}
