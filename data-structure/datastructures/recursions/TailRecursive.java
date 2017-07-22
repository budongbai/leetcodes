package datastructures.recursions;

import java.util.Scanner;

/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年3月7日 下午8:46:52
 * 类说明：尾递归示例
 * 尾部递归是一种编程技巧。
 * 递归函数是指一些会在函数内调用自己的函数，如果在递归函数中，递归调用返回的结果总被直接返回，则称为尾部递归。
 * 尾部递归的函数有助将算法转化成函数编程语言，而且从编译器角度来说，亦容易优化成为普通循环。
 * 这是因为从电脑的基本面来说，所有的循环都是利用重复移跳到代码的开头来实现的。
 * 如果有尾部归递，就只需要叠套一个堆栈，因为电脑只需要将函数的参数改变再重新调用一次。
 * 利用尾部递归最主要的目的是要优化，例如在Scheme语言中，明确规定必须针对尾部递归作优化。
 * 可见尾部递归的作用，是非常依赖于具体实现的。
 */
public class TailRecursive {

    public int factorial(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return factorial(n - 1) + factorial(n - 2);
        }
    }

    public int factorial(int n, int acc1, int acc2) {
        if (n < 2) {
            return acc1;
        } else {
            return factorial(n - 1, acc2, acc2 + acc1);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入数字");
        int n = scan.nextInt();
        long start = System.currentTimeMillis();
        int rs = new TailRecursive().factorial(n);
        long end = System.currentTimeMillis();
        System.out.println("结果=" + rs + ",时间=" + (end - start));

        long start1 = System.currentTimeMillis();
        int rs1 = new TailRecursive().factorial(n, 1, 1);
        long end1 = System.currentTimeMillis();
        System.out.println("结果=" + rs1 + ",时间=" + (end1 - start1));
    }

}
