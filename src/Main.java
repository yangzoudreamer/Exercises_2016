import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner inScanner = new Scanner(System.in);
		int testCount = inScanner.nextInt();
		while(testCount>0){
			int size = 0;
			int N = inScanner.nextInt();
			int p = inScanner.nextInt();
			int W = inScanner.nextInt();
			int H = inScanner.nextInt();
			int[] arrays = new int[N];
			
			for (int i = 0; i < arrays.length; i++) {
				int tmp	= inScanner.nextInt();
				arrays[i] = tmp;
			}
			
			for (int i = 1; i <= Math.min(W, H); i++) {
				
				if(!check(i,W,H,p,arrays)){
					break;
				}
				size = i;
			}
			System.out.println(size);
			testCount--;
		}
	}
	
	static boolean check(int s, int w,int h,int p,int[] array){
		int sum = 0;
		
		for (int i = 0; i < array.length; i++) {
			int tmp = (w/s);
			if(array[i]%tmp != 0){
				sum++;
			}
			sum += array[i]/(w/s);
		}
		
		return (h/s)*p >= sum;
		
	}
	
}
