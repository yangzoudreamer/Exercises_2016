import java.util.Arrays;


public class Valid_Anagram {
	public boolean isAnagram(String s, String t) {
		boolean flag = false;
		
		char[] cs = s.toCharArray();
		char[] ct = t.toCharArray();
		
		Arrays.sort(cs);
		Arrays.sort(ct);
		
		if (cs.equals(ct)) {
			flag = true;
		}
		
		return  flag;
	}
}
