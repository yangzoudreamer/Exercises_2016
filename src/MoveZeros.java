
public class MoveZeros {
	public static void moveZeros(int[] nums){
		int len = nums.length;
		int j = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] != 0) {
				int tmp = nums[j];
				nums[j] = nums[i];
				nums[i] = tmp;
				j++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {0,1,0,2,12};
		moveZeros(array);
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
}
