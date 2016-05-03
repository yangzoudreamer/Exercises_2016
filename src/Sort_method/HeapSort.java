package Sort_method;


public class HeapSort {
	//Heapsort
	public void heapSort(int[] array){
		buildInitHeap(array);
		
		System.out.println("\r\n建堆后..........................");
        for(int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");
		
		int n = array.length;
		//each time findout one node,and put it at the last array index. then the array length which is wait for sort must minus one
		for (int i = n-1; i > 0; i--) {
			swap(array, 0, i);
			heapNode(array, 0, i);
		}
	}
	
	
	//buildHeap
	public void buildInitHeap(int[] array){
		int n = array.length;
		for (int i = n/2 -1; i >= 0; i--) {
			heapNode(array, i, n);
		}
	}
	
	/*each node heap,
	max can not be arrived,it is the length of array which is wait for sort
	index is the target node wait for sort
	this method need recursion, because the node swap with its subnode,the subnode may also need swap with subnode(recursion)
	*/
	public void heapNode(int[] array, int index, int max){
		int left = (index * 2) +1;
		int right = (index * 2)+2;
		int largest = 0;
		if (left<max && array[left] > array[index]) {
			largest = left;
		}
		else {
			largest = index;
		}
		//right compared to largest
		if (right < max && array[right] > array[largest]) {
			largest = right;
		}
		if (index != largest) {
			swap(array, index, largest);
			//recursion , due to its subnode array has be changed
			heapNode(array, largest, max);
		}
	}
	
	public void swap(int[] arrry, int i,int j){
		int tmp = arrry[i];
		arrry[i] = arrry[j];
		arrry[j] = tmp;
	}

	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,16,9,10,11,12,13,14,15,8};
        System.out.println("排序前..........................");
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
        
        HeapSort testHeap = new HeapSort();
        testHeap.heapSort(a);
        
        System.out.println("\r\n排序后..........................");
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");

	}
	
}
