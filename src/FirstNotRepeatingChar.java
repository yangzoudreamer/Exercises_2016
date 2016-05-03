import java.util.ArrayList;
import java.util.List;


public class FirstNotRepeatingChar {
	public static int FirstNotRepeatingChar(String str){
		int index = 0;
		
		char[] c = str.toCharArray();
		int[] times = new int['z'];
		
		for (int i = 0; i < c.length; i++) {
			times[c[i]]++;
		}
		
		for (int i = 0; i < c.length; i++) {
			if (times[c[i]] == 1) {
				System.out.println(i);
				return i;
			}
		}
		
		return index;
	}
	
	public static void main(String[] args) {
//		FirstNotRepeatingChar.FirstNotRepeatingChar("google");
//		System.out.println(FirstNotRepeatingChar.replaceSpace(new StringBuffer("i am hero")));;
//		reverseVowel("hello");
		climbStairs(6);
	}
	
	public static String replaceSpace(StringBuffer str) {
	    	StringBuffer res = new StringBuffer("");
	    	for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == ' ') {
					res.append("%20");
				}
				else {
					res.append(str.charAt(i));
				}
			}
	    	return res.toString();
	}
	
	public static String reverseVowel(String str) {
		String res;
		char[] c = str.toCharArray();
		
		int head = 0;
		int trail = str.length()-1;
		
		
		
		while (head < trail) {
			if (isVowel(c[head])&&isVowel(c[trail])) {
				char tmp = c[head];
				c[head] = c[trail];
				c[trail] = tmp;
				head++;trail--;
			}
			else if(isVowel(c[head])&&!isVowel(c[trail])){
				trail--;
			}
			else if(!isVowel(c[head])&&isVowel(c[trail])){
				head++;
			}
			else {
				head++;
				trail--;
			}
		}
		System.out.println(String.valueOf(c));
		return c.toString();
	}
	
	public static boolean isVowel(char c) {
		String cString = String.valueOf(c);
		String string = "aeiouAEIOU";
		if (string.contains(cString)) {
			return true;
		}
		return false;
	}
	
//	static List<Integer> res = new ArrayList<Integer>();
	public static int climbStairs(int n) {
		List<Integer> res = new ArrayList<Integer>();
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			res.add(1);
			return 1;
		}
		if (n == 2) {
			res.add(2);
			return 2;
		}
		else if (n > 2) {
			res.add(1);
			res.add(2);
			for (int i = 2; i < n; i++) {
				res.add(res.get(i-1)+res.get(i-2));
			}
		}
		System.out.println(res.get(n-1));
		return res.get(n-1);
		
	}
	
}
