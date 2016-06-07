package hiho;

import java.util.Scanner;
/*
 * 最先的想法是先将字符串中重复的字符全部递归剔除掉，得到一个没有连续重复的字符串
      然后再对这个字符串使用最长回文子串，将插入字符到回文子串的中间，就能够将这个回文完全剔除得到消除的最大值
      最长回文使用马拉车Manacher算法
      结果发现错误百出，例如AAACA,结果是5，其实插入C可以变成ACAACA，结果是6
      因此，花了1小时实现的是个垃圾，不过复习了马拉车还是不错的
*/

/*暴力算法 ，实在是自身太弱
 * 1.原来计划在某个位置插入的字母必须是和相邻的字母相同，譬如“AC”，在AC之间插入的是A。后来试过几个测试用例，输出正确，就拿去提交，结果发现WA。

2.后来发现在某个位置插入的字母不一定要和相邻字母相同，这涉及到一些策略的问题，譬如AAACA，按照我的理解，要么插入后变成AAAACA，最后消除后剩下CA，要么插入后变成AAACAA，消除后剩下C，要么插入后变成AAACCA，消除后剩下C，所以按照我原来的思路，输出的会是5.

3.实际上，对于AAACA这个例子，最好的插入方法是ACAACA。消除过程如下：ACAACA->ACCA->AA>”“，结果为6才正确。

4.最后采用的方法是，遍历所有的情况，在每个可插入的位置都尝试插入A,B,C（这也很可能为什么题目只提供了3种字母，而不是更多的字母）.
*/

import java.util.Scanner;

public class Hiho1039{

    public static int handle(StringBuffer buffer) {
        int count = 0;
        while (true) {
            StringBuffer temp = new StringBuffer();
            int i = 0, j = 1;
            for (; j < buffer.length(); j++) {
                if (buffer.charAt(i) != buffer.charAt(j)) {
                    temp.append(buffer.charAt(i));
                } else {
                    while (j < buffer.length()
                            && buffer.charAt(i) == buffer.charAt(j))
                        j++;
                }
                i = j;
            }
            if (j == buffer.length()) {
                temp.append(buffer.charAt(i));
            }
            if (temp.length() == buffer.length()) {
                count = temp.length();
                break;
            }
            buffer = temp;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            StringBuffer buffer = new StringBuffer(scanner.next());
            int min = buffer.length();
            for (int j = 0; j < buffer.length(); j++) {
                for (char ch = 'A'; ch <= 'C'; ch++) {
                    StringBuffer temp = new StringBuffer(buffer);
                    temp = temp.insert(j, ch);
                    int count = handle(temp);
                    min = min > count ? count : min;
                }
            }
            System.out.println(buffer.length() + 1 - min);
        }
    }
}

/*public class Hiho1039{
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.valueOf(in.nextLine());
		while(in.hasNext()){
//			System.out.println(getLength(input));
			String input =in.nextLine();
			int res = input.length() - getNoRepeatCharSeq(input).length()+1;
			int res2 = getLength(getNoRepeatCharSeq(input));
			System.out.println(res+res2);
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
		if (str.equals("")) {
			return 0;
		}
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
*/
