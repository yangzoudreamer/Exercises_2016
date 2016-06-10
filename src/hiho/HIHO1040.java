package hiho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/*����
����ƽ����4���߶Σ��ж���4���߶��Ƿ�ǡ��Χ��һ���������0�ľ��Ρ�

����
�����һ����һ������T(1<=T<=100)������������ݵ�������

ÿ�����ݰ���4�У�ÿ�а���4������x1, y1, x2, y2 (0 <= x1, y1, x2, y2 <= 100000)������(x1, y1), (x2,y2)����һ���߶ε������˵㡣

���
ÿ���������һ��YES����NO����ʾ�����4���߶��Ƿ�ǡ��Χ�ɾ��Ρ�
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

�����YES YES NO
*/

/*˼·��ÿ������2����ȷ�����γɾ��α�����4���㣬���ܸ��࣬�����hashmap��ÿ������ĵ㣬����4��ֱ���ж�ΪNO��
֮���Լ����뷨�Ǹ���ֱ�ǹ��ɶ������жϣ���ͬ�����3�����ȵıߣ����������ξ���2����������ֱ�Ǳ�ƽ����Ϊб��ƽ���ͣ�
��׼�ⷨ�ǣ��ж�һ�����������ı�Ҫô��ֱҪôƽ�У�����б�����㣬K1*K2 = -1 �Ǵ�ֱ��k1 = k2 Ϊƽ�С�
�ύ�����Լ����뷨WA��Ȼ����û�оٳ������Ʒ��Լ���˼·��*/
/*��׼�ⷨ
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
