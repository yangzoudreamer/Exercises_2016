
public class LongestPreFix {
	
//  �Ȱ��ַ������ֵ�����������������ͷ����β���ַ����ȽϾͿ��Եõ��������Ϊһ���ַ���ͬ����Ҫ�����ж���ֱ�ӷ��ؽ��
/*	public String longestCommonPrefix(String[] strs) {
	    if (strs == null) return null;
	    if (strs.length == 0) return "";

	    Arrays.sort(strs);
	    char[] first = strs[0].toCharArray();
	    char[] last  = strs[strs.length - 1].toCharArray();

	    int i = 0, len = Math.min(first.length, last.length);
	    while (i < len && first[i] == last[i]) i++;
	    return strs[0].substring(0, i);
	}*/
	
    public static String longestCommonPrefix(String[] strs) {
    	if (strs.length == 0) {
			return "";
		}
        String resString = "";
        resString = strs[0];
        for (int i = 1; i < strs.length; i++) {
			resString = tmpLongest(resString, strs[i]);
			if(resString.equals(""))
			{
			    break;
			}
		}
        return resString;
    }

    public static String tmpLongest(String p1,String p2){
    	
    	int len = p1.length()> p2.length()?p2.length():p1.length();
    	char[] res = new char[len];
    	int length = 0;
    	for (int i = 0; i < len; i++) {
			if (p1.charAt(i) == p2.charAt(i)) {
				res[i] = p1.charAt(i);
				length++;
			}
		}
    	if(length == 0){
    	    return "";
    	}
    	
    	return String.valueOf(res).substring(0,length);
    }
	
	
	public static void main(String[] args) {
		String[] strings = {"aca","cba","bca"};
		System.out.println(longestCommonPrefix(strings));
	}
}
