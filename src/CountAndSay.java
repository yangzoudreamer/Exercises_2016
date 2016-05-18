
public class CountAndSay {
	
    public static String countAndSay(int n) {
        String res = "";
        String pre = "";
        if (n == 1) {
			return "1";
		}
        pre = "1";
        for (int i = 1; i < n; i++) {
        	int times = 1;
        	char number = '\0';
			for (int j = 0; j < pre.length(); j++) {
				if (j+1 != pre.length()) {
					if (pre.charAt(j) == pre.charAt(j+1)) {
						times++;
						number = pre.charAt(j);
					}
					else {
						res += String.valueOf(times);
						number = pre.charAt(j);
						res += String.valueOf(number);
						times = 1;
						number = pre.charAt(j+1);
					}
				}
				else {
					if(pre.length() == 1){
						res = "11"; 
					}
//					else if(pre.length() == 2){
//						
//					}
					else if (pre.charAt(j-1) == pre.charAt(j)) {
						res += String.valueOf(times);
						res += String.valueOf(number);
						break;
					}
					else 
						res += "1"+pre.charAt(j);
				}
			}
			pre = res;
			res = "";
		}       
        
        return pre;
    }
	
	public static void main(String[] args) {
		System.out.println(countAndSay(2));
	}
}
