package hiho;

import java.util.Scanner;

class HIHO1038{
	public static void main(String[] args ){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int N = Integer.valueOf(in.next());
			int M = Integer.valueOf(in.next());
			int[][] res = new int[N+1][M+1]; 
			int[] needs = new int[N+1];
			int[] values = new int[N+1];
			for(int i = 0; i < M+1;i++){
				res[0][i] = 0;
			}
			for(int i = 1; i < N+1;i++){
				needs[i] = Integer.valueOf(in.next());
				values[i] = Integer.valueOf(in.next());
			}

			for(int i = 1; i < N+1; i++){
				for(int j = 0; j < M+1; j++){
					if(needs[i] > j){
						res[i][j] = res[i-1][j];
					}  
					else{ 
					 res[i][j] = Math.max(res[i-1][j-needs[i]]+values[i],res[i-1][j]); 
					}
				}
			}
			System.out.println(res[N][M]);
		}
	}
} 
