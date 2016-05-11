package hiho;

import java.util.Scanner;

public class HiHO1032 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n =  in.nextInt();
		while(in.hasNext()){
			String input = in.next();
			System.out.println(new HiHO1032().getLength(input));
		}
	}
	
	public  int getLength(String str){
		int res = 0;
		char[] cs = str.toCharArray();
		char[] tmp = new char[str.length() * 2 + 3];
		int len = cs.length;
		tmp[0] = '@';
		int[] Len = new int[str.length() * 2+1];
		for (int i = 1; i <= 2*len; i += 2) {
			tmp[i] = '#';
			tmp[i+1] = cs[i/2];
		}
		tmp[len*2+1] = '#';
		tmp[len*2+2] = '&';
		int length = 2*len+1;
		res = manacher(tmp, length,Len);
		
		return res;
	}
	
	public  int manacher(char[] cc ,int len,int[] Len){
		int maxLen = 0; 
		int ans = 0;
		int p = 0;
		for (int i = 1; i < cc.length; i++) {
			if (maxLen > i) {
				if (i >= Len.length) {
					break;
				}
				Len[i] = (int)Math.min(Len[2*p-i], maxLen-i);
			}else {
				Len[i] = 1;
			}
			while (cc[i-Len[i]] == cc[i+Len[i]]) {
				Len[i]++;
			}
			if (maxLen < Len[i] + i) {
				maxLen = Len[i]+i;
				p = i;
			}
			ans = (int)Math.max(ans, Len[i]);
		}
		return ans-1;
	}
	
}
