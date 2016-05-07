import java.util.ArrayList;
import java.util.List;


public class Pascals_Triangle_1 {
	public static List<List<Integer>> getRow(int rowIndex) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int m = 0; m < rowIndex; m++) {
			List<Integer> res = new ArrayList<Integer>();
//	      通俗易懂，每次对list末尾加个1的数字，再从后向前得到新的数。保证了首尾都是1，中间的数都是由上一行的两个数之后求得
	        for (int i = 0; i <= rowIndex; i++) {
	        	res.add(1);
	        	for (int j = i-1; j > 0; j--) {
					res.set(j, res.get(j-1)+res.get(j));
				}
			}
	        list.add(res);
		}

//        取巧求解，可能是个公式吧，但是真心没有推导原理啊！
//        res.add(1);
//        int k = rowIndex;
//        for( int i = 1; i <= rowIndex; i++, k-- ){
//            // Using double to remove the overflow
//            double tmp = ((double)res.get(i-1)*k)/i;
//            res.add( (int)tmp );
//        }
        return list;
    }
}
