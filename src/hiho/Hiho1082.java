package hiho;

import java.util.Scanner;

public class Hiho1082 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[] target = {'m','a','r','s','h','t','o','m','p'};
		int len = target.length;
		while(in.hasNext()){
			String res = "";
			String text = in.nextLine();
			int head = 0;
			int end = 0;
			for (int i = 0; i < text.length(); i++) {
				head = i;
				end = i;
				if(text.length()-i < len){
					res += text.charAt(i);
				}
				else {
					int start = i;
					for (int j = 0; j < target.length; j++) {
						if (text.charAt(start) == target[j] || text.charAt(start)+32 == target[j]) {
							start++;
						}
						else {
							break;
						}
					}
					//匹配不成功
					if(start-i != target.length){
						res += text.substring(i,i+1);
						continue;
					}
					//匹配成功
					else {
						res += "fjxmlhx";
						i = start-1;
					}
				}
				
			}
			System.out.println(res);
		}
		
	}
}
