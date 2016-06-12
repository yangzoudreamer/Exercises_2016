package DFS;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	 public List<String> generateParenthesis(int n) {
	        List<String> list = new ArrayList<String>();
	        String str = "";
	        getCounts(n,n,str,list);
	        return list;    
	    }
	    
	    public void getCounts(int left, int right, String str, List<String> list){
	        if(left == 0 && right == 0){
	            list.add(str);
	        }
//	        必须保证剩下的所有左括号数目大于等于右括号，并优先使用左括号，此处用else无影响，一定是左括号优先
	        else if(left == right){
	            getCounts(left-1,right,str+"(",list);
	        }
	        else{
	            if(left > 0){
	                getCounts(left -1,right,str+"(",list);
	            }
//	            这里不能用else因为需要回溯，当DFS需要返回上一层时，左括号在并没有用尽的条件下去添加右括号，然后再来进行先左后右的便利dfs
	            
	            if(left < right && right > 0){
	                getCounts(left,right-1,str+")",list);
	            }
	        }
	    }
	    
	    public static void main(String[] args) {
			System.out.println(new GenerateParenthesis().generateParenthesis(3));
		}
}