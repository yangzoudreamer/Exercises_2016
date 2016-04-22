//��ָOffer  ���ݷ���һ���ַ��������Ƿ�����Ӵ�·����ֻ�ܲ��ܴ��ĸ���������һλ��
public class HasPath {
		
	    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
	    {
	        if(str.length == 0)
	            return true;
	        int preLength  = 0;
	        boolean[] visited = new boolean[rows * cols];
	        for (int i = 0; i < visited.length; i++) {
				visited[i] = false;
			}
	    	for(int i = 0; i< rows;i++){
	            for(int j = 0; j < cols;j++){
	                
	                if(hasPath(matrix,i,rows,j,cols,preLength,str,visited)){
	                    return true;
	                }
	            }
	        }
	        return false;
	    }
	    
	    public static boolean hasPath(char[] matrix,int row,int rows,int col,int cols,int preLength,char[] str,boolean[] visited){
	        
//	    	System.out.println("this row is "+row+",this col is "+col);
	    	
	    	//�ﵽĩβ
//	    	if (str[preLength] == '\0') {
//				return true;
//			}
	    	
	    	if (preLength == str.length) {
				return true;
			}
	    	
	    	boolean hasPath = false;
	        if (row>=0&& row <rows && col >=0 && col < cols && matrix[row*cols + col] == str[preLength]&& !visited[row*cols + col]) {
				
	        	++preLength;
				visited[row*cols+col] = true;
				
				hasPath = hasPath( matrix, row, rows, col-1, cols, preLength,str, visited)
						||hasPath( matrix, row, rows, col+1, cols, preLength,str, visited)
						||hasPath( matrix, row+1, rows, col, cols, preLength,str, visited)
						||hasPath( matrix, row-1, rows, col, cols, preLength,str, visited);
				if (!hasPath) {
					--preLength;
					visited[row*cols + col] = false;
				}
			}
	        	        
	        return hasPath;
	    }
	    
	    public static void main(String[] args) {
			String test = "abcesfcsadee";
			String tar = "bcced";
			char[] matrix = test.toCharArray();
			char[] str = tar.toCharArray();
			if (HasPath.hasPath(matrix, 3, 4, str)) {
				System.out.println("Exist path");
			}
			else {
				System.out.println("No Exist path");
			}
		}
	    
}
