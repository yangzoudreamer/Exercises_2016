package indeed;

/*
 * һ��n*m�ľ���ÿ�������д���ֵ���ָ�ɵ���Ԫ�صķ��飬ÿ��ֻ�ܺ��л������е��ף��ָ�Ĵ�����δ�ָ�ǰ����������Ԫ�ص�ֵ���ܺ͡�
�����ֳ�1*1��������ʱ����С����ֵ
ÿ�ηָ��λ�á�һ�����ܹ������Ӿ����������ֵ�����ﵽ��С�ġ�һ�ַַ����ҵ�ÿ��������λ�ü���
û���Ż��������£���20*20�ľ������·�����ʱ
*/

import java.util.Scanner;

public class Chocolate_Bar {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = Integer.valueOf(in.next());
			int m = Integer.valueOf(in.next());
			int[][] martix = new int[n][m];
//			��ֵ�ɿ�������
			for (int i = 0; i < n; i++) {
				String line = in.next();
				for (int j = 0; j < m; j++) {
					martix[i][j] = line.charAt(j)-'0';
				}
			}
			
//			ÿ�ζ��ҵ��ܹ��ָ����ʹ�������Ӿ���Ĵ�С�����С�ķ�ʽ
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
//			�ָ��2���Ӿ���ݹ鴦��,�ҵ���ѷָ��λ��
			int best_i_from = i_from;
			int best_i_to = i_to;
			int best_j_from = j_from;
			int best_j_to = j_to;
			 
//			����ָ����������Ĳ����һ���������ֵ���������ֵ
			int row_value = Integer.MAX_VALUE;
			int column_value = Integer.MAX_VALUE;
			
			for (int i = i_from; i < i_to; i++) {
				int cutLine = i;
				int predis = 0;
				int postdis = 0;
//				��һ�������ֵ
				for (int p = i_from; p <= cutLine; p++) {
					for (int q = j_from; q <= j_to; q++) {
						predis += matrix[p][q];
					}
				}
//				�ڶ��������ֵ
				for (int p = cutLine + 1; p <= i_to; p++) {
					for (int q = j_from; q <= j_to; q++) {
						postdis += matrix[p][q];
					}
				}
				if (distense > abs(predis-postdis)) {
					distense = abs(predis-postdis);
//					����������
					row_value = distense;
					best_i_from = i;
				}
			}
			
			for (int j = j_from; j < j_to; j++) {
				int cutLine = j;
				int predis = 0;
				int postdis = 0;
//				��һ�������ֵ
				for (int p = i_from; p <= i_to; p++) {
					for (int q = j_from; q <= cutLine; q++) {
						predis += matrix[p][q];
					}
				}
//				�ڶ��������ֵ
				for (int p = i_from; p <= i_to; p++) {
					for (int q = cutLine+1; q <= j_to; q++) {
						postdis += matrix[p][q];
					}
				}
				if (distense2 > abs(predis-postdis)) {
					distense2 = abs(predis-postdis);
//					����������
					column_value = distense2;
					best_j_from = j;
				}
			}
//			ѡ����
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
