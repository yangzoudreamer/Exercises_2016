package hiho;

import java.util.Scanner;
//̰��ɨ�貹�����飬һ�������Ǳ��뽫���еĲ����������ܵõ����Ĵ�����

public class HIHO1051 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = Integer.valueOf(in.next());
			while (n>0) {
				--n;
				int max = -1;
				
				int length = Integer.valueOf(in.next());
				int m = Integer.valueOf(in.next());
				int[] arr = new int[length+1];
				
				for (int i = 1; i <= length; i++) {
					arr[i] = Integer.valueOf(in.next());
				}				

				if (m >= length) {
					System.out.println("100");
					continue;
				}
				else {
					for(int i=m+1;i<=length;i++)
			        {
						if(arr[i]-arr[i-m-1]-1>max)
						    max=arr[i]-arr[i-m-1]-1;
			        }
					System.out.println(max);
					
				}
			}
		}
	}
}
