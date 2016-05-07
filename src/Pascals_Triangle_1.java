import java.util.ArrayList;
import java.util.List;


public class Pascals_Triangle_1 {
	public static List<List<Integer>> getRow(int rowIndex) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int m = 0; m < rowIndex; m++) {
			List<Integer> res = new ArrayList<Integer>();
//	      ͨ���׶���ÿ�ζ�listĩβ�Ӹ�1�����֣��ٴӺ���ǰ�õ��µ�������֤����β����1���м������������һ�е�������֮�����
	        for (int i = 0; i <= rowIndex; i++) {
	        	res.add(1);
	        	for (int j = i-1; j > 0; j--) {
					res.set(j, res.get(j-1)+res.get(j));
				}
			}
	        list.add(res);
		}

//        ȡ����⣬�����Ǹ���ʽ�ɣ���������û���Ƶ�ԭ����
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
