import java.util.ArrayList;
import java.util.List;

//一个数组列表反转使用Collections.reverse(ArrayList)方法
public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length == 1) {
			List<Integer> head = new ArrayList<Integer>();
			head.add(nums[0]);
			res.add(head);
			return res;
		}
		partition(nums, 0, nums.length - 1);
		int len = getSizes(nums.length);
		List<Integer> head = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			head.add(nums[i]);
		}
		res.add(head);
		while (len < 1) {
			List<Integer> next = new ArrayList<Integer>();
			getNextList(nums);
			for (int i = 0; i < nums.length; i++) {
				next.add(nums[i]);
			}
			res.add(next);
			len--;
		}
		return res;
	}

	// quick sort find out the min list A, then each time get list which only
	// large than prelist
	public void quickSort(int[] nums, int start, int end) {
		if (start >= end) {
			return;
		}
		int mid = partition(nums, start, end);
		quickSort(nums, start, mid - 1);
		quickSort(nums, mid + 1, end);

	}

	// 能够生成的排列种数，先算出来作为跳出循环条件
	public int getSizes(int length) {
		int res = 1;
		for (int i = 1; i <= length; i++) {
			res *= i;
		}
		return res;
	}

	// find the index i which nums[i] is smaller than nums[i+1] ，找到下一个排列形式
	public void getNextList(int[] nums) {
		int end = nums.length - 1;
		int i = end, j;
		boolean isLastSort = false;
		for (int p = end; p > -1; --p) {
			if (p == 0) {
				isLastSort = true;
				break;
			} else if (nums[p - 1] < nums[p]) {
				i = p - 1;
				break;
			}
		}
		if (isLastSort == true) {
			return;
		}
		j = findIndexFirstLargeI(i, nums);
		swap(nums, i, j);
		// 反转i后子段数组
		reverseSubArray(nums, i + 1);

	}

	// find the smallest ele which in larger than num[i]，找到能够交换的k的位置
	public int findIndexFirstLargeI(int i, int[] nums) {
		int index = i + 1;
		int end = nums.length - 1;
		int min = nums[i + 1];
		for (int j = i + 1; j < nums.length; j++) {
			if (min > nums[j] && nums[j] > nums[i]) {
				index = j;
				min = nums[j];
			}
		}
		return index;
	}

	public void reverseSubArray(int[] nums, int start) {
		int len = nums.length - 1;
		if ((len + start) % 2 == 0) {
			for (int i = start; i < (len + start) / 2; i++) {
				swap(nums, i, len--);
			}
		} else {
			for (int i = start; i <= (len + start) / 2; i++) {
				swap(nums, i, len--);
			}
		}
	}

	public int partition(int[] nums, int start, int end) {
		int i = start;
		int j = end + 1;
		int v = nums[i];
		while (true) {
			while (nums[++i] < v)
				if (i >= end) {
					break;
				}
			;
			while (nums[--j] > v)
				if (j == start) {
					break;
				}
			;
			if (i >= j) {
				break;
			}
			swap(nums, i, j);
		}
		// the last operate in every time sort
		swap(nums, j, start);
		return j;
	}

	public void swap(int[] array, int a, int b) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}

	public static void main(String[] args) {
		int[] arrays = { 1, 0, 5, 2, 3 };
		Permutations testPermutations = new Permutations();
		testPermutations.quickSort(arrays, 0, arrays.length - 1);

		List<List<Integer>> result = testPermutations.permute(arrays);

		for (List<Integer> list : result) {
			for (Integer integer : list) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
		System.out.println(result.size());

	}

}
