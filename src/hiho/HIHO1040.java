package hiho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/*描述
给出平面上4条线段，判断这4条线段是否恰好围成一个面积大于0的矩形。

输入
输入第一行是一个整数T(1<=T<=100)，代表测试数据的数量。

每组数据包含4行，每行包含4个整数x1, y1, x2, y2 (0 <= x1, y1, x2, y2 <= 100000)；其中(x1, y1), (x2,y2)代表一条线段的两个端点。

输出
每组数据输出一行YES或者NO，表示输入的4条线段是否恰好围成矩形。
test case
3
0 0 0 1
1 0 1 1
0 1 1 1
1 0 0 0
0 1 2 3
1 0 3 2
3 2 2 3
1 0 0 1
0 1 1 0
1 0 2 0
2 0 1 1
1 1 0 1

输出：YES YES NO
*/

/*思路是每条边由2个点确定，形成矩形必须是4个点，不能更多，因此用hashmap存每次输入的点，超过4个直接判定为NO，
之后，自己的想法是根据直角勾股定理来判断，不同点最多3条不等的边，碰到正方形就是2条。并且有直角边平方和为斜边平方和，
标准解法是，判定一条边与其他的边要么垂直要么平行，根据斜率来算，K1*K2 = -1 是垂直，k1 = k2 为平行。
提交后是自己的想法WA，然而并没有举出反例推翻自己的思路。*/
/*标准解法
 * import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Main {
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		
		int t = cin.nextInt();
		
		while (t-- > 0) {
			
			Set<String> set = new HashSet<String>();
			
			int[] vx = new int[4];
			int[] vy = new int[4];
			
			for (int i = 0; i < 4; i++) {
				int x1 = cin.nextInt();
				int y1 = cin.nextInt();
				int x2 = cin.nextInt();
				int y2 = cin.nextInt();
				
				set.add(x1 + "-" + y1);
				set.add(x2 + "-" + y2);
				
				vx[i] = x2 - x1;
				vy[i] = y2 - y1;
			}
			
			if (set.size() != 4) {
				System.out.println("NO");
				continue;
			}
			
			boolean valid = true;
			for (int i = 1; i < 4; i++) {
				if (!(vx[0] * vx[i] + vy[0] * vy[i] == 0 || vx[0] *vy[i] - vy[0] * vx[i] == 0)) {
					valid = false;
					break;
				}
			}
			
			if (valid) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}*/


public class HIHO1040 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = Integer.valueOf(in.next());
			HashMap<String, String> map = new HashMap<>();
			boolean isFourLine = false;
			boolean isExistThreeDis = false;
			while (n>0) {
				map.clear();
				n--;
				int nodeCount = 8;
				int disCount = 0;
				int index = 0;
				int x[] = new int[8];
				int y[] = new int[8];
				while(index<8)
				{
					int i = in.nextInt();
					int j = in.nextInt();
					x[index] = i;
					y[index] = j;
					String indexXY = new String(i+"|"+j);
					if (!map.containsKey(indexXY)) {
						map.put(indexXY, indexXY);
//						nodes[i][j] = true;
						--nodeCount;
					}
					++index;
				}
				if (nodeCount == 4) {
					HashMap<String, String> dis = new HashMap<>();
					for (int i = 1; i < y.length; i++) {
						String disXY = String.valueOf(getLength(x[0],y[0],x[i],y[i]));
						if (!dis.containsKey(disXY) && !disXY.equals("0.0")) {
							dis.put(disXY, disXY);
//							System.out.println("lengths:"+disXY);
						}
					}
					if (dis.size() == 3 || dis.size() == 2) {
						if (dis.size() == 3) {
							List<String> string = new ArrayList<>();
							Iterator iterator = dis.entrySet().iterator();
							while (iterator.hasNext()) {
								 Map.Entry entry = (Map.Entry)iterator.next();
								 string.add((String) entry.getValue());
							}
							if (isTriTrue(string.get(0), string.get(1), string.get(2))) {
								System.out.println("YES");
							}
							else {
								System.out.println("NO");
							}
						}
						else if (dis.size() == 2) {
//							
							List<String> string = new ArrayList<>();
							Iterator iterator = dis.entrySet().iterator();
							while (iterator.hasNext()) {
								 Map.Entry entry = (Map.Entry)iterator.next();
								 string.add((String) entry.getValue());
							}
							if (isDouTrue(string.get(0), string.get(1))) {
								System.out.println("YES");
							}
							else {
								System.out.println("NO");
							}
						}
					}
					else {
						System.out.println("NO");
					}
				}
				else {
					System.out.println("NO");
				}
			}
		}
	}
	public static double getLength(int x1,int y1,int x2,int y2){
		double res = 0;
		return (Math.pow(x2-x1, 2))+(Math.pow(y2-y1, 2));
	}
	
	public static boolean isTriTrue(String x1,String y1,String z1){
		double x,y,z;
		x = Double.valueOf(x1);
		y = Double.valueOf(y1);
		z = Double.valueOf(z1);
		return x+y==z || x + z == y || y+z ==x;
	}
	public static boolean isDouTrue(String x1,String y1){
		double x,y;
		x = Double.valueOf(x1);
		y = Double.valueOf(y1);
		return x+x == y || y+y ==x;
	}
}
