import java.util.HashMap;
import java.util.HashSet;

//test git
public class Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (int i : nums) {
			if (!set.add(i)) {
				return true;
			}
		}
        return false;
    }
    
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	
    	for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], i);
			}
			else {
				int dis = i-map.get(nums[i]);
				if (dis <= k) {
					return true;
				}
				else {
					map.put(nums[i], i);
					continue;
				}
				
			}
		}
    	return false;
    }
    
    public static void main(String[] args) {
    	int[] nums = {1,2,1};
    	int k = 1;
		System.out.println(containsNearbyDuplicate(nums, k));
	}
}
