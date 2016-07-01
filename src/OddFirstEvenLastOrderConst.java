import java.util.LinkedList;
import java.util.Queue;

/* ��Ŀ����������һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
 * ���е�ż��λ��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
 */
public class OddFirstEvenLastOrderConst {
//	����˼·�ǽ���ͷβ��Ԫ�أ���ͷ��ż����β������ʱ����ֵ������ͷβ���Ͽ�������һ�������ܱ�֤����֮���ԭʼ���λ��
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

//	����һ�α��������ö���ռ�ķ������ֱ������ż��Ȼ�����¸�ֵ
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
	
//	�����Բ��ö���ռ䣬ʹ��ָ���ǣ�һ��ָ��Aָ���һ��ż������һ��ָ��Bָ���һ��ż����ĵ�һ������
//	Ȼ��AB����ֵ��Aָ����һ��ż����B�������ɨ��������������ʱ��O(n^2)
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
