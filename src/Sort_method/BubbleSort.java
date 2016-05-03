package Sort_method;

public class BubbleSort {
	public void bubbleSort(int[] array){
		boolean flag = false;
		int sortTimes = 0;
		int k = array.length;
		int end = k;
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < end-1; j++) {
				if (array[j] > array[j + 1]) {
					int tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
					flag = true;
				}
			}
			end -= 1;
			//加快排序速度，若一次排序没改变任何值，说明序列已经有序
			if (flag == false) {
				System.out.println("排序次数： "+sortTimes);
				break;
			}
			flag = false;
			sortTimes++;
		}
	}
	
	public static void main(String[] args) {
//		int[] array = {2,7,4,0,3,6,23,12,46,1};
		int[] array = {8,1,2,3,4,5,6,7};
		BubbleSort test = new BubbleSort();
		test.bubbleSort(array);
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+ " ");
		}
		
	}
}
