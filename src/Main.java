import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner inScanner = new Scanner(System.in);
		int testCount = inScanner.nextInt();
		while(testCount>0){
			int size = 0;
			int N = inScanner.nextInt();
			int p = inScanner.nextInt();
			int W = inScanner.nextInt();
			int H = inScanner.nextInt();
			int[] arrays = new int[N];
			
			for (int i = 0; i < arrays.length; i++) {
				int tmp	= inScanner.nextInt();
				arrays[i] = tmp;
			}
			
			
			for (int i = 1; i <= Math.min(W, H); i++) {
				
				if(!check(i,W,H,p,arrays)){
					break;
				}
				size = i;
			}
			System.out.println(size);
			testCount--;
		}
	}
	
	static boolean check(int s, int w,int h,int p,int[] array){
		int sum = 0;
		
		for (int i = 0; i < array.length; i++) {
			int tmp = (w/s);
			if(array[i]%tmp != 0){
				sum++;
			}
			sum += array[i]/(w/s);
		}
		
		return (h/s)*p >= sum;
		
		/*
		 *  int count,obj;
     		cin>>count>>obj;
		      if(count == 0)
		           return 0;
		      int* monkey = new int[count];
		      for ( int i = 0; i <count ;i++)
		          monkey[i] = i+1;
		      int flag = 0;
		      for ( int i = 0; i < count;i++)
			     {
			          int calcount = 0;
			          while(calcount < obj)
			          {
			              while(0 == monkey[flag])
			                   flag  = (flag+1) % count ;//看成了用obj去除，其实是一个圈count的循环
			              calcount++;
			              flag = (flag+1) % count;
			          }
			          flag--;
			          if (flag < 0)
			             flag = count -1;
			          if (i == count-1)//判断是否遍历到最后一次，即是猴王
			             cout<< "monkey—aking："<<monkey[flag]<<endl;//monkey[i]不是解，因为可能数据              已经是0，但flag会跳过monkey[i] == 0的数组位置
			          monkey[flag] = 0;
			     }
		 * */
		
	}
	
}
