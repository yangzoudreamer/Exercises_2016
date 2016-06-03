package hiho;

public class Hiho1033 {
	
	public static void main(String[] args) {
		int result = 0;
		for (long i = 60296763086567224L; i < 193422344885593845L; i++) {
			if (calculateRes(i) == 10) {
				result+=i;
			}
		}
		System.out.println(result);
	}
	
	public static long formatRes(long res){
		long r =  (res % ((long)(Math.pow(10, 9))+7));
		return r;
	}
	
	public static int calculateRes(long x){
		int res = 0;
		String test = String.valueOf(x);
		for (int i = 0; i < test.length(); i++) {
			if (i % 2==0) {
				res += test.charAt(i)-'0';
			}
			else {
				res -= test.charAt(i)-'0';
			}
		}
		return res;
	}
}
