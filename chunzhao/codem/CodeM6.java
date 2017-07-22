package codem;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年6月18日下午6:50:33
*/
public class CodeM6 {

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
		float sum = 0f;
		float s = u * n;//每个人都要跑这么远的，再加上他跑的这段时间，整个队伍跑了多远。
	
		for(int i= 0; i< n; i++){
			//挨个计算，当前人位于第j轮时，他需要的时间
			for(int j =1; j<=n; j++){
				float vi = c[i]-(j-1)*d[i];
				BigDecimal   b  =   new BigDecimal(s/(vi-v));  
				float   f1   =  b.setScale(3, BigDecimal.ROUND_HALF_UP).floatValue();
				
				sum+= f1;
			}
		}
	
		BigDecimal   b  =   new BigDecimal(sum/n);  
		float   f1   =  b.setScale(3, BigDecimal.ROUND_HALF_UP).floatValue();
		System.out.println(f1);
		//System.out.println(df.format(sum/n));
		scan.close();
	}

}
