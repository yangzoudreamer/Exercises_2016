import java.util.Scanner;

class Main{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {

			int k = Integer.valueOf(in.next());
			int[] balls = new int[k];
			for (int i = 0; i < balls.length; i++) {
				balls[i] = 0;
			}
			for (int i = 0; i < balls.length; i++) {
				balls[i] = Integer.valueOf(in.next());
			}
			double[] eachBallProbability = new double[k];
			double result = 0;
			int sumBalls = 0;
			for (int i = 0; i < balls.length; i++) {
				sumBalls += balls[i];
			}
			
			for (int i = 0; i < eachBallProbability.length; i++) {
				eachBallProbability[i] =(double) balls[i] / sumBalls;
			}
			for (int i = 0; i < eachBallProbability.length; i++) {
				result += getExpected(k, eachBallProbability[i]);
			}
				System.out.println(result);
		}
	}
	
	public static double getExpected(int k, double p){
		double result = 0;
		
		result = k * Math.pow(1-p, k-1) + Math.pow(1-p, k)/p;
		
		System.out.println("result:" + result);
		
		return result;
	}
	
/*	String[] input = new String[6];
	for (int i = 0; i < input.length; i++) {
		input[i] = in.next();
	}
	
	String[][] arrays = new String[6][6];
	char[] c = new char[6];
	
	for (int i = 0; i < 6; i++) {
		c = input[i].toCharArray();
		for (int j = 0; j < 6; j++) {
			arrays[i][j] = String.valueOf(c[i]);
		}
	}
//	isVolid?
	if (!isValid(arrays)) {
		System.out.println("0");
		return ;
	}
//	---------------process valid ------------------------
	
	*/

	
	
/*	public static boolean isValid(String[][] array){
		int times = 0;
//		row by row 
		for (int i = 0; i < 6; i++) {
			
			for (int j = 0; j < 6; j++) {
				if (array[i][j].equals("o")) {
					times++;
				}
			}
			if (times > 3) {
				return false;
			}
			else {
				times = 0;
			}
		}
//		 col by col
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (array[j][i].equals("o")) {
					times++;
				}
			}
			if (times > 3) {
				return false;
			}
			else {
				times = 0;
			}
		}
		
		return true;
	}*/
	
}

/*int k = Integer.valueOf(in.next());
int[] balls = new int[k];
double[] eachBallProbability = new double[k];
double result = 0;
int sumBalls = 0;
for (int i = 0; i < balls.length; i++) {
	sumBalls += balls[i];
}

for (int i = 0; i < eachBallProbability.length; i++) {
	eachBallProbability[i] = balls[i] / sumBalls;
}

//the result is Mathematical Expectation
//if k = 2, it is easy to calculate
*/





/*public static void travel(boolean[] visited, int[] p,int idx){
	if (visited[idx]) {
		return;
	}
	visited[idx] = true;
	travel(visited, p, p[idx]);
}

public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	while (in.hasNext()) {
		
		int n = Integer.valueOf(in.next());
		int[] p = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			p[i] = Integer.valueOf(in.next());
		}
		
		boolean[] visited = new boolean[n+1];
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (visited[i]) {
				continue;
			}
			travel(visited, p, i);
			++cnt;
		}
		System.out.println(cnt);
		return;
	}
}*/