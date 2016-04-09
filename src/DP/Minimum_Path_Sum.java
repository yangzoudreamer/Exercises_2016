package DP;

public class Minimum_Path_Sum {
    public  int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int min = 0;
        
        if (m == 0 || n == 0) {
			return -1;
		}
        for (int i = 1; i < m; i++) {
			grid[i][0] += grid[i-1][0];
		}
        for (int j = 1; j < n; j++) {
			grid[0][j] += grid[0][j-1];
		}
        
        for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				grid[i][j] +=  MinSub(grid[i-1][j],grid[i][j-1]);
			}
		}
        min = grid[m-1][n-1];
        System.out.println(min);
        return min;
    }
    
    public static int MinSub(int a , int b){
        return a > b? b : a;
    }
    public static void main(String[] args) {
		int[][] arrays = new int[3][4];
//		System.out.println(arrays.length);
		for (int i = 0; i < arrays.length; i++) {
			for (int j = 0; j < arrays[0].length; j++) {
				arrays[i][j] = i;
//				System.out.print(arrays[i][j]);
			}
//			System.out.println();
		}
		
		minPathSum(arrays);
		
	}
}
