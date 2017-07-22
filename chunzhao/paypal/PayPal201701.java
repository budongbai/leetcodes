package paypal;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author budongbai
 * @version 2017年4月13日下午7:09:13
*/
public class PayPal201701 {
	public static int hasIt(ArrayList<Integer> list){
		int size = list.size()/2;
		
		for(int i =0; i< size-1; i++){
			int ai = list.get(i);
			int ai1 = list.get(i+1);
			int bi = list.get(size+i);
			int bi1 = list.get(size+i+1);
			if(bi==1 && bi1==-1){
				if(ai >ai1)
					return i+1;
				else
					return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		String a = null,b = null;
		
		
			a = scan.nextLine();
			b = scan.nextLine();
			String[] as = a.split("\\s+");
			String[] bs = b.split("\\s+");
			for(int i =0; i< as.length; i++){
				list.add(Integer.parseInt(as[i]));
			}
			for(int i =0; i< bs.length; i++){
				list.add(Integer.parseInt(bs[i]));
			}
			int flag = hasIt(list);
			while(flag!=-1){
				list.remove(list.size()/2+flag);
				list.remove(flag);
				flag = hasIt(list);
			}
			System.out.println(list.size()/2);
		
		scan.close();
	}
}