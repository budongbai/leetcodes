

import java.util.Arrays;
import java.util.Scanner;



public class Main22 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		
		StringBuilder sb = new StringBuilder();
		
		String maxStr = null;
		for(int i=0; i< s.length(); i++){
			char c = s.charAt(i);
			if(c>='0' && c <='9'){
				sb.append(c);
			}else{
				if(maxStr == null){
					maxStr = sb.toString();
					sb = new StringBuilder();
				}else if(sb.toString().length()>= maxStr.length()){
					maxStr = sb.toString();
					sb = new StringBuilder();
				}
			}
		}
		System.out.println(maxStr);
		System.out.println(maxStr.length());
		scan.close();
	}

}
