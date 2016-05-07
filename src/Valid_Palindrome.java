
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Valid_Palindrome {
	public static boolean isPalindrome(String str) {
//		正则针对海量的字符串逐个格式化太慢
//		Pattern pattern = Pattern.compile("[a-zA-Z]+");
//		Matcher matcher = pattern.matcher(s);
		String res = "";
//		while (matcher.find()) {
//			res += matcher.group();
//		}
		
//		res = s.replaceAll("[\\p{Punct}\\p{Space}\\n]+", "");
//		
//		res = res.toLowerCase();
//		
//		return check(res);
		
//		直接对s的每个字符判定，不“合法”的直接跳过，统计转换成小写字母
		char[] s = str.toCharArray();
    	int sz = s.length;
    	if(sz<1) return true;
    
    	int i=0;
    	int j= sz-1;
    
    	while(i<j) {
            while( i<j && !isValid(s[i]) ) ++i;
            while( i<j && !isValid(s[j]) ) --j;
            
            if( s[i] >= 'A' && s[i]<='Z') s[i] += 'a'-'A';
            if( s[j] >= 'A' && s[j]<='Z') s[j] += 'a'-'A';  
            	
            if(i<j && s[i] != s[j]) {
                return false;
            }
            ++i;
            --j;
        }
        
        return true;
	}
	
	private static boolean isValid(char c) {
        if(c>='A' && c<='Z') return true;
        if(c>='a' && c<='z') return true;
        if(c>='0' && c<='9') return true;
        return false;
    }
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}
	
	public static boolean check(String str){
//		boolean flag = false;
		int len = str.length();
		for (int i = 0, j = len-1; i <= j; i++,j--) {
			if (str.charAt(i) == str.charAt(j)) {
				continue;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
}
