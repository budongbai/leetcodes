package saima;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年8月22日下午3:45:51
 */
public class GuShen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, money, i;
        while (scan.hasNext()) {
            n = scan.nextInt();
            money = 1;
            i = 1;
            /*
             * 定义day为天数，price为当天股票价格，up为day中涨的天数，down为day中下降的天数，则有：
             * day=1+up+down,price=1+up-down,推出price=day-2*down.所以求出down,
             * 即可求得price。
             * 经验证，day=(down+1)*(down+2)/2+f(down),其中f(down)为[0,down+1]中的一个整数。
             * 编程通过遍历找到down, 继而得到price.
             */
            while (n >= 0)
                n -= i++;
            i--;

            for (int j = 1; j <= i - 2; j++) {
                money += j;
                System.out.println(money + "....");
            }
            System.out.println(n + 2 + ",");
            money += (n + 2);
            System.out.println(money);
        }
        scan.close();
    }
}
