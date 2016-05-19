import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


public class Group_Anagrams {
	//利用字符代替数值的原理，使用素数作为因子，避免了混淆乘积的作用。字符串由相同字符不同排列组成，可以通过所含字符得到相同的乘积，具有唯一性。
	
	int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//最多10609个z

	
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (String str : strs) {
			int key = 1;
			for (char c : str.toCharArray()) {
				key *= prime[c - 'a'];
			}
			List<String> tList;
			if (map.containsKey(key)) {
				tList = res.get(map.get(key));
			}else {
				tList = new ArrayList<String>();
				map.put(key, res.size()-1);
				res.add(tList);
			}
			tList.add(str);
		}
		
		for (List<String> list : res) {
			Collections.sort(list);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		
	}
}
