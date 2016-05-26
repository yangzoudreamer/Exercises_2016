package WAP;

import java.util.Scanner;

public class Maximum_Xor_with_Prefix_and_Suffix {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] array = new long[n];
		long[] preFix = new long[n];
		long[] suffix = new long[n];
		long max = 0;
		for (int i = 0; i < n; i++) {
			array[i] = in.nextLong();
		}
		for (int i = 1; i < preFix.length; i++) {
			preFix[i] = array[i-1]^preFix[i-1];
		}

		for (int i = n-1; i > 0 ; i--) {
				suffix[i-1] = array[i]^suffix[i];
		}
	
		
		for (int i = 0; i < suffix.length; i++) {
			for (int j = i-1; j < suffix.length; j++) {
				long tmp; 
				if (i==0||i==1) {
					tmp = preFix[i]^suffix[0];
				}
				else{
					tmp = preFix[i]^suffix[j];
				}
				if (max < tmp) {
					max = tmp;
				}
			}
		}
		
		
		System.out.println(max);
		
	}
}
