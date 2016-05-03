
public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
    	if (num1.equals("0")||num2.equals("0")) {
			return "0";
		}
        String res = "";
        String inRes = "";
        for (int i = num1.length()-1; i >=0 ; i--) {
			inRes = subMultiply(num1.length()-1-i,num1.charAt(i),num2);
			res = sum(res, inRes);
		}
        int index = 0;
        for (int i = 0; i < res.length(); i++) {
			if (res.charAt(index) == '0') {
				index++;
			}
			else {
				break;
			}
		}
        res = res.substring(index);
        
        return res;
    }
    
    public static String subMultiply(int len, char c,String num1) {
		String res = "";
		int flag = 0;
		
		for (int i = num1.length()-1; i >= 0; i--) {
			int k = (c-'0')*(num1.charAt(i)-'0') + flag;
			res = k % 10 + res;
			flag = k / 10;
			if(i == 0 && flag != 0){
				res = flag + res;
			}
		}
		
		for (int i = 0; i < len; i++) {
			res = res + "0";
		}
		return res;
	}
    
    public static String sum(String num1,String num2){
    	String sumRes = "";
    	int flag = 0;
    	String longEle =  num1.length() >= num2.length() ? num1 : num2;
    	String shortEle = num1.length() < num2.length() ? num1 : num2;
    	
    	for (int i = longEle.length()-1,j = shortEle.length()-1; i >=0 || j >= 0 ; i--,j--) {
			if (i>=0 && j >= 0) {
				int k = (longEle.charAt(i)-'0')+(shortEle.charAt(j)-'0')+flag;
				sumRes = k % 10 + sumRes;
				flag = k / 10;
				if (i==0 && j == 0 && flag == 1) {
					sumRes = flag + sumRes;
				}
			}
			else {
				int t = i > j ? i : j;
				int k = longEle.charAt(t)-'0' + flag;
				flag = k / 10;
				sumRes = k % 10 + sumRes;
				if (t == 0 && flag == 1) {
					sumRes = flag + sumRes;
				}
			}
		}

    	return sumRes;
    }
    
    public static void main(String[] args) {
		String in1 = "09";
		String in2 = "2";
		
		String resString = multiply(in1, in2);
		
		for (int i = 0; i < resString.length(); i++) {
			System.out.print(resString.charAt(i));
		}
		
	}
}
