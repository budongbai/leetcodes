package toutiao;

import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年3月30日下午7:12:02
*/
public class Toutiao {
	/*
	 * 按数组的形式给出函数f(x)的取值，即数组A的A[0]元素为f(0)的取值，
	 * 数组的取值都为整数，函数在每个点都是严格单调递增或者严格递减（即A[i-1] != A[i] != A[i+1]）
	 * ，要求找出最宽的先上升后下降的区间
	 * （这个区间内函数的值必须先上升到一个点然后下降，区间的上升段和下降段长度必须都大于0）。
	 * 1. 如果找到符合条件的最大区间输出数组对应的左右下标（有多个最大区间时，输出最左边的那个”）
	 * 2. 找不到那么输出-1 -1*/
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int num = scan.nextInt();
	int[] a = new int[num];
	for(int i = 0; i< num; i++){
		a[i] = scan.nextInt();
	}

	int left = 0;
	int right = 0;
	int max = 0;
	int[] sign = {0,0};
	boolean up =true;
	for(int i = 0; i< num-2; i++){
		//123
		if(a[i]< a[i+1] && a[i+1]< a[i+2]){
			up =true;
			left = left < i? left:i;
			max = i+2;
			right = i+3>num-1?num-1:i+3;
			//132
		}else if(a[i]< a[i+1] && a[i+1]> a[i+2]){
			left =up ? left :i;
			max = i+1;
			right = i+2;
			if(sign[1]-sign[0]< right -left){
				sign[0]= left;
				sign[1] = right;
			}
			
			//321
		}else if(a[i]> a[i+1] && a[i+1]> a[i+2]){
			up =false;
			max = max > i? max :i;
			right = i+2;
		}
		
		
	}
	if(sign[0]== sign[1]){
        System.out.println(-1+ " "+ 1);
    }else
        System.out.println(sign[0]+ " "+ sign[1]);
	scan.close();
}
}
