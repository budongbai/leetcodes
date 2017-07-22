package lianjia;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        System.out.println("What's the range you want to get the prime number?");
        System.out.println("你想获得多少以内的素数?");

        Scanner in = new Scanner(System.in);
        int range = in.nextInt();

        int[] a = new int[range];

        //Assign an array to an array
        //数组赋值
        for (int i = 0; i < a.length - 1; i++) {
            a[i] = i + 2;
        }


        //prime number is 0 , composite number is 0
        //素数为本身，合数为0
        for (int i = 2; i <= a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] != 0) {
                    if (a[j] % i == 0 && a[j] / i != 1) {
                        a[j] = 0;
                    }
                }
            }
        }

        System.out.println("Prime number within " + range);
        System.out.println("输出" + range + "之间所有素数");

        int count = 0;

        for (int num : a) {
            if (num != 0) {
                System.out.print(num + " ");
                count++;
                if (count % 10 == 0) {     //A line of ten numbers 每输出10个素数换行
                    System.out.println();
                }
            }
        }

        System.out.println();
        System.out.println("The number of prime numbers is: " + count);
        System.out.println("共" + count + "个素数");
        in.close();
    }
}