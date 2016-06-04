package indeed;

/*
 * 一个n*m的矩阵每个方块中带有值，分割成单个元素的方块，每次只能横切或者竖切到底，分割的代价是未分割前矩阵中所有元素的值的总和。
求最后分成1*1独立方块时，最小代价值
每次分割的位置“一定是能够两个子矩阵各自所带值相减差达到最小的”一种分法，找到每次这样的位置即可
没有优化的条件下，算20*20的矩阵，以下方法超时
*/

import java.util.Scanner;

public class Chocolate_Bar {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = Integer.valueOf(in.next());
			int m = Integer.valueOf(in.next());
			int[][] martix = new int[n][m];
//			赋值巧克力矩阵
			for (int i = 0; i < n; i++) {
				String line = in.next();
				for (int j = 0; j < m; j++) {
					martix[i][j] = line.charAt(j)-'0';
				}
			}
			
//			每次都找到能够分割矩阵使得两个子矩阵的大小差距最小的方式
			System.out.println(partitionMatrix(martix,0,n-1,0,m-1));
		}
	}
	
	public static int partitionMatrix(int[][] matrix,int i_from,int i_to,int j_from,int j_to){
		int res = 0;
		
		
		
		if ((i_from==i_to && j_from+1==j_to)) {
			return res = matrix[i_from][j_from]+matrix[i_from][j_to];
		}
		else if (j_from == j_to && i_from+1 == i_to) {
			return res = matrix[i_from][j_from]+matrix[i_to][j_from];
		}
		else if (j_from == j_to && i_from == i_to) {
			return res = 0;
		}
		
		else {
			
			int distense = Integer.MAX_VALUE;
			int distense2 = Integer.MAX_VALUE;
			for (int i = i_from; i <= i_to; i++) {
				for (int j = j_from; j <= j_to; j++) {
					System.out.print(matrix[i][j]+" ");
					res += matrix[i][j];
					
				}
			}
			System.out.println();
//			分割成2个子矩阵递归处理,找到最佳分割的位置
			int best_i_from = i_from;
			int best_i_to = i_to;
			int best_j_from = j_from;
			int best_j_to = j_to;
			 
//			计算分割后两个矩阵的差，设置一个横切最佳值，竖切最佳值
			int row_value = Integer.MAX_VALUE;
			int column_value = Integer.MAX_VALUE;
			
			for (int i = i_from; i < i_to; i++) {
				int cutLine = i;
				int predis = 0;
				int postdis = 0;
//				第一个矩阵的值
				for (int p = i_from; p <= cutLine; p++) {
					for (int q = j_from; q <= j_to; q++) {
						predis += matrix[p][q];
					}
				}
//				第二个矩阵的值
				for (int p = cutLine + 1; p <= i_to; p++) {
					for (int q = j_from; q <= j_to; q++) {
						postdis += matrix[p][q];
					}
				}
				if (distense > abs(predis-postdis)) {
					distense = abs(predis-postdis);
//					子问题的起点
					row_value = distense;
					best_i_from = i;
				}
			}
			
			for (int j = j_from; j < j_to; j++) {
				int cutLine = j;
				int predis = 0;
				int postdis = 0;
//				第一个矩阵的值
				for (int p = i_from; p <= i_to; p++) {
					for (int q = j_from; q <= cutLine; q++) {
						predis += matrix[p][q];
					}
				}
//				第二个矩阵的值
				for (int p = i_from; p <= i_to; p++) {
					for (int q = cutLine+1; q <= j_to; q++) {
						postdis += matrix[p][q];
					}
				}
				if (distense2 > abs(predis-postdis)) {
					distense2 = abs(predis-postdis);
//					子问题的起点
					column_value = distense2;
					best_j_from = j;
				}
			}
//			选竖切
			if (row_value > column_value) {
				res +=  partitionMatrix(matrix, i_from, i_to, j_from, best_j_from)+
						partitionMatrix(matrix, i_from, i_to, best_j_from+1, best_j_to);
			}
			else {
				res +=  partitionMatrix(matrix, i_from, best_i_from, j_from, j_to)+
						partitionMatrix(matrix, best_i_from+1, i_to, j_from, j_to);
			}
		}
		return res;
	}
	
	public static int abs(int x){
		if (x < 0) {
			return -x;
		}
		return x;
	}
	
}
