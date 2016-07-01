
public class Partition {
	public int partition(int[] array,int start, int end){
		
		int i = (int)Math.random()*(end-start);
		
		i += start;
		
		swap(array, i, end);
		
		int small = start - 1; 
		
		for (int index = start; index < end; index++) {
			if (array[index] < array[end]) {
				++small;
				if (small != index) {
					swap(array, small, index);
				}
			}
		}
		++small;
		swap(array, small, end);
		return small;
	}
	
	public void swap(int[] array, int head, int trail) {
		if(head >= 0 && trail < array.length){
			int tmp = array[trail];
			array[trail] = array[head];
			array[head] = tmp;
		}
		return;
	}
	
	public void quickSort(int[] array, int start, int end){
		if (start == end) {
			return;
		}
		int mid = partition(array, start, end);
		
//		无论mid是什么都要分别执行左右两边的子问题，所以不用else
		if (mid > start) {
			quickSort(array, start, mid-1);
		}
		if (mid < end) {
			quickSort(array, mid+1, end);
		}
	}
	
	public static void main(String[] args) {
		int[] array = {3,0,1,2,5,6,-1,3};
		
		Partition partition = new Partition();
		
		partition.quickSort(array, 0, 7);
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
