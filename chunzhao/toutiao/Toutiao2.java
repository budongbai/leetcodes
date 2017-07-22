package toutiao;

import java.util.HashMap;
import java.util.Scanner;

public class Toutiao2{
	public static int max(int[] a){
		int max =0;
		for(int i = 0; i <a.length; i++){
			if(a[max]< a[i])
				max = i;
		}
		return max;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		scan.nextLine();
		String[] stmts = new String[n];
		for(int i =0; i< n; i++){
			stmts[i] = scan.nextLine();
		}
		String[] querys = new String[m];
		for(int i = 0 ; i< m; i++){
			querys[i] = scan.nextLine();
		}
		HashMap<String, int[]> map = new HashMap<>();
		for(int i = 0; i< n; i++){
			String[]  ss = stmts[i].split("\\s+");
		
			for(int j =0; j <ss.length; j++){
				if(map.containsKey(ss[j])){
					int[] c = map.get(ss[j]);
					c[i]++;
					map.put(ss[j],c);
				}else{
					int[] count = new int[n];
					for(int k = 0; k< n; k++){
						count[k]=0;
					}
					count[i]++;
					map.put(ss[j], count);
				}
			}		
		}
		for(int i =0; i< m; i++){
			String[] ss = querys[i].split("\\s+");
			for(int j =0; j <ss.length; j++){
				if(map.containsKey(ss[j])){
					int max = max(map.get(ss[j]));
					System.out.println(stmts[max]);
				}
			}
		}
		scan.close();
	}
	
}