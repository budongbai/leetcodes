package codem;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 美团外卖的配送员用变速跑的方式进行身体训练。
他们训练的方式是：n个人排成一列跑步，前后两人之间相隔 u 米，每个人正常速度均为 v 米/秒。
当某个配送员排在最后的时候，他需要以当时自己的最高速度往前跑，直到超过排头的人 u 米，然后降回到原始速度 v 米/秒。每个人最初的最高速度为c[i] 米/秒，每轮衰减d[i] 米/秒，也就是说，如果i是第j个跑的，那么他的速度就是c[i]-(j-1)*d[i] 米/秒。
n个人初始以随机的顺序排列，每种顺序的概率完全相等，跑完一轮（每个人都追到排头一次，序列恢复原样）的期望需要的时间是多少？

输入描述:
第一行整数n（<=1000）, 实数v(<=100) , 实数u(<=10)
第二行n个实数每个人的速度c[i](<=50000)
第三行n个实数值每个人衰减量d[i](<=10)
输入数据保证每个人的速度不会衰减到<=v


输出描述:
答案保留3位小数。

输入例子:
10 37.618 0.422
72.865 126.767 202.680 106.102 99.516 134.418 167.952 173.646 120.210 136.571
2.941 3.664 7.363 4.161 0.246 8.046 5.521 7.473 7.178 5.649

输出例子:
0.815
 * @author budongbai
 * @version 2017年6月18日下午6:50:33
*/
public class CodeM1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		float v = scan.nextFloat();
		float u = scan.nextFloat();
		float[] c = new float[n];
		float[] d = new float[n];
		//距离
		for(int i=0; i< n; i++){
			c[i] = scan.nextFloat();
		}
		//衰减量
		for(int i=0; i< n; i++){
			d[i] = scan.nextFloat();
		}
		int count = 1;
		float sum = 0f;
		float s = u * n;//每个人都要跑这么远的，再加上他跑的这段时间，整个队伍跑了多远。
	
		for(int i= 0; i< n; i++){
			for(int j = n-i-1; j >= 0; j--){
				float vj = c[j]-(count-1)*d[j];
				sum+= s/(vj-v);
				count++;
			}
			for(int j = n-1; j >n-i-1; j--){
				float vj = c[j]-(count-1)*d[j];
				sum+= s/(vj-v);
				count++;
			}
			count =1;
			
		}
	
		BigDecimal   b  =   new BigDecimal(sum/n);  
		float   f1   =  b.setScale(3, BigDecimal.ROUND_HALF_UP).floatValue();
		System.out.println(f1);
		//System.out.println(df.format(sum/n));
		scan.close();
	}

}
