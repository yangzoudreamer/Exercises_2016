package DP;

//找到一个矩阵的最大子矩阵和，同时打印出最大子矩阵
public class Max_SubMatrix {
	
	public static SubMaxRes getSubMaxRes(int[] array) {
		SubMaxRes res = new SubMaxRes();
		res.index = 0;
		res.max = array[0];
		
		int  tmp = array[0];
		
		for (int i = 1; i < array.length; i++) {
			//只要前缀不为负数就继续累加，因为最后一定跟max比较
			if (tmp >= 0) {
				tmp += array[i];
			}
			else {
				tmp = array[i];
			}
			if (res.max < tmp) {
				res.max = tmp;
				res.index = i;
			}
		}
		
		return res;
	}
	
	public static void findMaxSubMatrix(int[][] array){
		int max = array[0][0];
		int subArrayLinei = 0;
		int subArrayLinej = 0;
		int column = 0;
		int arrayRow = array.length;
		int arrayColumn = array[0].length;
		int[] tmp = new int[arrayColumn];
		SubMaxRes res = new SubMaxRes();
		
		for (int i = 0; i < arrayRow; i++) {
			for (int j = 0; j < arrayColumn; j++) {
				tmp[j] = 0;
			}
			for (int j = i; j < arrayRow; j++) {
				for (int k = 0; k < arrayColumn; k++) {
					tmp[k] += array[j][k];
				}
				res = getSubMaxRes(tmp);
				if (res.max > max) {
					max = res.max;
					subArrayLinei = i;
					subArrayLinej = j;
					column = res.index;
				}
			}			
		}
		
		System.out.println("SubMatrix is "+max);
		
		for (int i = subArrayLinei; i <= subArrayLinej; i++) {
			for (int j = 0; j <= column; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] array = {{0,-2,-7,0},{9,2,-6,2},{-4,1,-4,1},{-1,8,0,-2}};
		findMaxSubMatrix(array);
	}
}
