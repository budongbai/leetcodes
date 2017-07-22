package wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年6月14日下午2:14:51
*/
public class WangYi20170601 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] ls = new int[n];
		for(int i=0; i< n; i++){
			ls[i] = scan.nextInt()/1024;
		}
		Arrays.sort(ls);
		System.out.println(Arrays.toString(ls));
		int times1 =0;
		int times2 =0;
		for(int i= n-1;i >=0; i--){
			if(times1<=times2){
				times1+=ls[i];
			}else if(times1> times2){
				times2 += ls[i];
			}
		}
		System.out.println(times1>times2?times1:times2);
		scan.close();
	}

}
