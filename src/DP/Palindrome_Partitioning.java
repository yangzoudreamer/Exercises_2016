package DP;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        ArrayList<String> path = new ArrayList<>();
        
        if (s.equals("") || s == null) {
			return res;
		}
        
        process(s,path, res);
        
        return res;
    }
    
    public void process(String s, List<String> path, List<List<String>> res){
    	if (0 == s.length()) {
			res.add(new ArrayList<>(path));
			return;
		}
    	int len = s.length();
    	
    	for (int i = 1; i <= len; i++) {
			String subStr = s.substring(0,i);
			if (isPalindrome(subStr)) {
				path.add(subStr);
				String remained = s.substring(i);
				process(remained, path, res);
//				printList(path);
//				使用回溯每次需要将判定过的结点从结果中取出来便于下次合并组成新的子串，其实这个点压根就没搞懂，DFS还是没领悟核心
				path.remove(path.size()-1);
			}
		}
    }
    
    public void printList(List<String> list){
    	for (String string : list) {
			System.out.print(list +" ");
		}
    }
    
    public static boolean isPalindrome(String string) {
		boolean flag = true;
		int start = 0;
		int end = string.length()-1;
		while(start < end){
			if (string.charAt(start) == string.charAt(end)) {
				++start;
				--end;
			}else{
				return false;
			}
		}
		return flag;
	}
    
    public static void main(String[] args) {
    	List<List<String>> partition = new Palindrome_Partitioning().partition("aab");
    	for (List<String> arrayList : partition) {
			for (String string : arrayList) {

				System.out.print(string + " ");
			}
			System.out.println();
		}
	}
}
