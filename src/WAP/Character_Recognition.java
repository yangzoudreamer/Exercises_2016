package WAP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Character_Recognition {
	
	public static int n;
	public static int m;
	public static int k;
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		 n = in.nextInt();
		 m = in.nextInt();
		 k = in.nextInt();
		
		List<Integer> initList = new ArrayList<Integer>();
		
		int[][][] arrays = new int[k][n][m];
		
		for (int i = 0; i < k; i++) {
//			in.next();
			for (int j = 0; j < n; j++) {
				String line = in.next();
				for (int r = 0; r < m; r++) {
					arrays[i][j][r] = (line.charAt(r))=='0'?0:1;
				}
			}
			initList.add(i);
		}
		
		
		System.out.println(getResult(arrays, initList));
		
	}
	
	public static int getResult(int[][][] array, List<Integer> subArrayIndex) {
//		int[] pre_index = index;
//		int res = 0;
		if(subArrayIndex.size()<=2)
			return 1;
		
		else {
			int const_sub = subArrayIndex.size()/2;
			int absMin = subArrayIndex.size()/2;
			int count = 0;
			int index_i = 0;
			int index_j = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					count = 0;
					for (int r = 0; r < k; r++) {
						if (array[r][i][j] == 0) {
							++count;
						}
					}
					if(Math.abs(count-const_sub) < absMin){
						absMin = Math.abs(count-const_sub);
						index_i = i;
						index_j = j;
						if (absMin == 0) {
							break;
						}
					}
				}
				if (absMin == 0) {
					break;
				}
			}
			
			List<Integer> preSubList = new ArrayList<Integer>();
			List<Integer> lastSubList = new ArrayList<Integer>();
			
			for (int i = 0; i < subArrayIndex.size(); i++) {
				if (array[subArrayIndex.get(i)][index_i][index_j] == 0) {
					preSubList.add(i);
				}else {
					lastSubList.add(i);
				}
			}
			
			return max(getResult(array, preSubList),getResult(array, lastSubList))+1;
		}		
	}
	
	public static int max(int x,int y){
		return x > y ? x:y;
	}
}
