import java.util.ArrayList;
import java.util.List;


//对于求n的阶乘，注意大数问题

public class Pascals_Triangle_2 {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
//      通俗易懂，每次对list末尾加个1的数字，再从后向前得到新的数。保证了首尾都是1，中间的数都是由上一行的两个数之后求得
        for (int i = 0; i <= rowIndex; i++) {
        	res.add(1);
        	for (int j = i-1; j > 0; j--) {
				res.set(j, res.get(j-1)+res.get(j));
			}
		}
//        取巧求解，可能是个公式吧，但是真心没有推导原理啊！
//        res.add(1);
//        int k = rowIndex;
//        for( int i = 1; i <= rowIndex; i++, k-- ){
//            // Using double to remove the overflow
//            double tmp = ((double)res.get(i-1)*k)/i;
//            res.add( (int)tmp );
//        }
        
        return res;
    }
    
    public static int nFactorial(int n){
    	if (n == 1) {
			return 1;
		}
    	if (n == 0) {
			return 1;
		}
    	else if (n > 0) {
    		return n * nFactorial(n-1);
		}
    	return 1;
    }
//    为得到Cnr的值进行计算，大数溢出
//    public static int getCnr(int r,int n) {
//		int res = 0;
//		int m = nFactorial(n);
//		int p = (nFactorial(n-r));
//		int q = nFactorial(r);
//		res =  m / (p*q);
//		优化,p为较大的一个数,只能解决一部分数字较小的n.需要大数
//		int p = r > (n-r)? r:(n-r);
//		int q = r <= (n-r)? r:(n-r);
//		
//		int div = nFactorial(q);
//		int t = 1;
//		for (int i = 0; i < n-p; i++) {
//			t *= n-i;
//		}
//		res = t / div;
//		return res;
//	}
//	斯特林不适合啊
//	public static int nFactorial(int n) {
//		int m = n;
//		int res = (int)(Math.sqrt(Math.PI * m * 2) * Math.pow(m/Math.E, m));
//		
//		System.out.println(res);
//		
//		return res;
//	}
	
	public static void main(String[] args) {
		List<Integer> resIntegers = getRow(18);
		for (int i = 0; i < resIntegers.size(); i++) {
			System.out.println(resIntegers.get(i));
		}
	}
	
	//大数做加法，每个数array[i][j] = array[i-1][j-1] + array[i-1][j]但是不满足O(K)的空间
//	public String getBigNFactorial(int n){
//		String res = "";
//		
//		
//	}
	
}
