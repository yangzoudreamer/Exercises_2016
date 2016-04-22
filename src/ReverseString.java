
public class ReverseString {
	public String reverseString(String s) {
		char[] res = s.toCharArray();
		int len =  res.length;
		for (int i = 0, j = len-1; i < j; i++,j--) {
			char c = res[i];
			res[i] = res[j];
			res[j] = c;
		}
		return String.valueOf(res);
	}

}
