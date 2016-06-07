package hiho;

import java.util.Scanner;
//马拉车Manacher算法
public class Hiho1039{
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
//		int n =  in.next();
		while(in.hasNext()){
			String input = in.nextLine();
//			System.out.println(getLength(input));
			System.out.println(getNoRepeatCharSeq(input));
		}
	}
	
	public static boolean isNoRepeatCharSeq(String str) {
		boolean flag = true;
		
		for (int i = 0; i < str.length()-1; i++) {
			if (str.charAt(i) == str.charAt(i+1)) {
				flag = false;
			}
		}
		
		return flag;
	}
	
	public static String getNoRepeatCharSeq(String str){
		String res = str;
		
		while (!isNoRepeatCharSeq(str)) {
			str = getLastString(str);
		}
		res = str;
		return res;
	}
	
	public static String getLastString(String input){
		int len = input.length();
//		StringBuffer buffer = new StringBuffer(input);
		String res = "";
		int start = 0;
		int end = 0;
		
		char[] s = input.toCharArray();
		for (int i = 0; i < s.length-1; i++) {
			if(s[i] == s[i+1]){
				start = i;
				for (int j = start+1; j < s.length; j++) {
					if (s[j] == s[start]) {
						s[j] = '\0';
						if (j == s.length-1) {
							end = j;
							break;
						}
						continue;
					}
					else {
						end = j;
						break;
					}
				}
				s[start] = '\0';
				i = end-1;
				continue;
			}
		}
		
		res = String.valueOf(s);
		String res1 = res.replace('\0','1');
		String res2 = res1.replaceAll("1", "");
		return res2;
	}
	
	public static int getLength(String str){
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
	
	public static int manacher(char[] cc ,int len,int[] Len){
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

