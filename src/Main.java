import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int R = Integer.valueOf(in.next());
			int x1 = Integer.valueOf(in.next());
			int y1 = Integer.valueOf(in.next());
			int x2 = Integer.valueOf(in.next());
			int y2 = Integer.valueOf(in.next());
			int x3 = Integer.valueOf(in.next());
			int y3 = Integer.valueOf(in.next());
			int x0 = Integer.valueOf(in.next());
			int y0 = Integer.valueOf(in.next());
			
			boolean flag1 = false;
			boolean flag2 = false;
			boolean flag3 = false;
			
			if (R >= Main.distance(x1,y1,x0,y0)) {
				flag1 = true;
			}
			if (R >= Main.distance(x2,y2,x0,y0)) {
				flag2 = true;
			}
			if (R >= Main.distance(x3,y3,x0,y0)) {
				flag3 = true;
			}
			int count = 0;
			if (flag1) {
				++count;
			}
			if (flag2) {
				++count;
			}
			if (flag3) {
				++count;
			}
			System.out.println(count+"x");
		}
	}
	
	public static double distance(int x,int y,int m,int n){
		
		double dis = 0;
		dis = Math.sqrt(Math.pow(x-m, 2)+Math.pow(y-n, 2));

		return dis;
	}
}
