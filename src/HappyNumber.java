
public class HappyNumber {
    public static boolean isHappy(int n) {
    	if(n == 1 || n == 7)
            return true;
        int test = n;
        boolean flag = false;
        do{
            String string = String.valueOf(test);
            char[] cstring = string.toCharArray();
            int len = cstring.length;
            int res = 0;
            for(int i = 0; i < len;i++){
                res += (int)Math.pow((cstring[i]-'0'),2);
            }
            test = res;
        }while(n>=10);
        
        
        return test==1||test==7;
    }
    
    public static void main(String[] args) {
		System.out.println(isHappy(29));
	}
}
