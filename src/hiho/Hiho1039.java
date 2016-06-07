package hiho;

import java.util.Scanner;
/*
 * ���ȵ��뷨���Ƚ��ַ������ظ����ַ�ȫ���ݹ��޳������õ�һ��û�������ظ����ַ���
      Ȼ���ٶ�����ַ���ʹ��������Ӵ����������ַ��������Ӵ����м䣬���ܹ������������ȫ�޳��õ����������ֵ
      �����ʹ��������Manacher�㷨
      ������ִ���ٳ�������AAACA,�����5����ʵ����C���Ա��ACAACA�������6
      ��ˣ�����1Сʱʵ�ֵ��Ǹ�������������ϰ�����������ǲ����
*/

/*�����㷨 ��ʵ��������̫��
 * 1.ԭ���ƻ���ĳ��λ�ò������ĸ�����Ǻ����ڵ���ĸ��ͬ��Ʃ�硰AC������AC֮��������A�������Թ��������������������ȷ������ȥ�ύ���������WA��

2.����������ĳ��λ�ò������ĸ��һ��Ҫ��������ĸ��ͬ�����漰��һЩ���Ե����⣬Ʃ��AAACA�������ҵ���⣬Ҫô�������AAAACA�����������ʣ��CA��Ҫô�������AAACAA��������ʣ��C��Ҫô�������AAACCA��������ʣ��C�����԰�����ԭ����˼·������Ļ���5.

3.ʵ���ϣ�����AAACA������ӣ���õĲ��뷽����ACAACA�������������£�ACAACA->ACCA->AA>���������Ϊ6����ȷ��

4.�����õķ����ǣ��������е��������ÿ���ɲ����λ�ö����Բ���A,B,C����Ҳ�ܿ���Ϊʲô��Ŀֻ�ṩ��3����ĸ�������Ǹ������ĸ��.
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
