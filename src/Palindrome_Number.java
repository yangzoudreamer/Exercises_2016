
public class Palindrome_Number {
    public static boolean isPalindrome(int x) {
        long res = 0;
        long t = x;
        while(x != 0){
            res = res * 10 + x % 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return false;
            }
            x /= 10;
        }
        if(res == t)
            return true;
        return false;
    }
    
    public static void main(String[] args) {
		System.out.println(isPalindrome(1));
	}
}
