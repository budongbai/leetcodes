package qiyi;

import java.util.Scanner;

/**
 * 一堆管子，至少截出来k段，使所有截出来的管子的长度最长。
 * @author budongbai
 * @version 2017年5月14日下午8:03:33
*/
public class QiYi02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String kStr = scan.nextLine();
		String nStr = scan.nextLine();
		int k = Integer.parseInt(kStr);
		String[] nStrs = nStr.split("\\s+");
		int[] n = new int[nStrs.length];
		for(int i =0; i< n.length;i++){
			n[i]= Integer.parseInt(nStrs[i]);
		}
		int max = n[0];
		for(int i=1; i< n.length; i++){
			if(max < n[i]){
				max = n[i];
			}
		}
		
		int count = 0;//用来记录多少段
		int num = 1;//每段管子多长
		//j表示截的管子长度为多少，从1开始，直到max
		for(int j = 1; j <= max; j++){
			//开始遍历管子们，如果管子长度大于,当前每段长度
			for(int i = n.length-1; i>=0 && n[i]>=num; i--){
				count+=n[i]/j;
			}
			if(count >=k){
				num = j;//更新管子的长度
			}
			count =0;
		}
		System.out.println(num);
		scan.close();
	}

}
