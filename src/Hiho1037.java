import java.util.Scanner;


/*
test case
5
2
6 4
1 2 8
4 0 9 6
6 5 5 3 6

output:
28
*/
public class Hiho1037 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int[][] res = new int[n][n];
			int[][] matrix = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < i+1; j++) {
					matrix[i][j] = in.nextInt();
				}
			}
			int max = 0;
			res[0][0] = matrix[0][0];
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < i+1; j++) {
					if (j == 0) {
						res[i][j] = res[i-1][j]+ matrix[i][j];
					}
					else if(j == i){
						res[i][j] = res[i-1][j-1]+ matrix[i][j];
					}
					else {
						res[i][j] = Math.max(res[i-1][j], res[i-1][j-1]) + matrix[i][j];
					}
				}
			}
			
			for (int i = 0; i < matrix.length; i++) {
				if (max<res[n-1][i]) {
					max = res[n-1][i];
				}
			}
			System.out.println(max);
		}
	}
	
	
}
