import java.util.LinkedList;
import java.util.Queue;

/* 题目描述：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class OddFirstEvenLastOrderConst {
//	以下思路是交互头尾的元素，当头是偶数，尾是奇数时交互值，并且头尾不断靠近，这一做法不能保证奇数之间的原始相对位置
    /*public void reOrderArray(int [] array) {
    	if(array==null || array.length == 1)
            return;
        int head = 0;
        int end = array.length-1;
        
        while(head < end){
            while(head < end && !isEven(array[head])){
                head++;
            }wa
            while(head < end && isEven(array[end])){
                end--;
            }
            if(head < end){
                int temp = array[head];
                array[head] = array[end];
                array[end] = temp;
            }
        }
    }
    
    public boolean isEven(int i){
        return (i&1) == 0;
    }*/

//	采用一次遍历，采用额外空间的方法，分别存奇数偶数然后重新赋值
	public void reOrderArray(int [] array) {
		int len = array.length;
		Queue<Integer> queue1 = new LinkedList<>();
		Queue<Integer> queue2 = new LinkedList<>();
		for (int i = 0; i < len; i++) {
			if (!isEven(array[i])) {
				queue1.add(array[i]);
			}
			else if (isEven(array[i])) {
				queue2.add(array[i]);
			}
		}
		int size = queue1.size();
		for (int i = 0; i < size; i++) {
			array[i] = queue1.poll();
		}
		for (int i = size; i < len; i++) {
			array[i] = queue2.poll();
		}
	}
	public boolean isEven(int i){
	    return (i&1) == 0;
	}
	
//	还可以不用多余空间，使用指针标记，一个指针A指向第一个偶数，另一个指针B指向第一个偶数后的第一个奇数
//	然后AB交互值，A指向下一个偶数，B继续向后扫描遇到的奇数，时间O(n^2)
	/*
	 * public void reOrderArray(int [] array) {
        int index = 0;
        for(int i = 0;i<array.length;i++){
            if(array[i]%2!=0){
                for(int j = i;j>index;j--){
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
                index++;
            }
        }
    }*/
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		OddFirstEvenLastOrderConst test = new OddFirstEvenLastOrderConst();
		test.reOrderArray(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
