import java.util.ArrayList;
import java.util.List;


//������n�Ľ׳ˣ�ע���������

public class Pascals_Triangle_2 {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
//      ͨ���׶���ÿ�ζ�listĩβ�Ӹ�1�����֣��ٴӺ���ǰ�õ��µ�������֤����β����1���м������������һ�е�������֮�����
        for (int i = 0; i <= rowIndex; i++) {
        	res.add(1);
        	for (int j = i-1; j > 0; j--) {
				res.set(j, res.get(j-1)+res.get(j));
			}
		}
//        ȡ����⣬�����Ǹ���ʽ�ɣ���������û���Ƶ�ԭ����
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
//    Ϊ�õ�Cnr��ֵ���м��㣬�������
//    public static int getCnr(int r,int n) {
//		int res = 0;
//		int m = nFactorial(n);
//		int p = (nFactorial(n-r));
//		int q = nFactorial(r);
//		res =  m / (p*q);
//		�Ż�,pΪ�ϴ��һ����,ֻ�ܽ��һ�������ֽ�С��n.��Ҫ����
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
//	˹���ֲ��ʺϰ�
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
	
	//�������ӷ���ÿ����array[i][j] = array[i-1][j-1] + array[i-1][j]���ǲ�����O(K)�Ŀռ�
//	public String getBigNFactorial(int n){
//		String res = "";
//		
//		
//	}
	
}
