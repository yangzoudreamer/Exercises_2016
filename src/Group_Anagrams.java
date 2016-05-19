import java.security.interfaces.RSAKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


public class Group_Anagrams {
	//�����ַ�������ֵ��ԭ��ʹ��������Ϊ���ӣ������˻����˻������á��ַ�������ͬ�ַ���ͬ������ɣ�����ͨ�������ַ��õ���ͬ�ĳ˻�������Ψһ�ԡ�
	
	int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//���10609��z

	
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
