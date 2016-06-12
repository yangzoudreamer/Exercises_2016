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
//	        ���뱣֤ʣ�µ�������������Ŀ���ڵ��������ţ�������ʹ�������ţ��˴���else��Ӱ�죬һ��������������
	        else if(left == right){
	            getCounts(left-1,right,str+"(",list);
	        }
	        else{
	            if(left > 0){
	                getCounts(left -1,right,str+"(",list);
	            }
//	            ���ﲻ����else��Ϊ��Ҫ���ݣ���DFS��Ҫ������һ��ʱ���������ڲ�û���þ���������ȥ��������ţ�Ȼ����������������ҵı���dfs
	            
	            if(left < right && right > 0){
	                getCounts(left,right-1,str+")",list);
	            }
	        }
	    }
	    
	    public static void main(String[] args) {
			System.out.println(new GenerateParenthesis().generateParenthesis(3));
		}
}