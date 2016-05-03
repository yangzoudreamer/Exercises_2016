
public class Search_a_2D_Matrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int tarRow = 0;
        boolean flag = false;
        if(target < matrix[0][0])
            return false;
        if(target > matrix[row-1][column-1]){
            return false;
        }
        
        for(int i = 0; i < row-1; i++){
            if(target >= matrix[i][0] && target < matrix[i+1][0]){
                tarRow = i;
                flag = true;
                break;
            }
        }
        if(flag == false){
            tarRow = row-1;
        }
        for(int j = 0; j < column;j++){
            if(matrix[tarRow][j] == target){
                return true;
            }
        }
        return false;
        
    }
    
    public static void main(String[] args) {
//    	int[][] matrix = {  {1,3,5,7},
//    			  {10, 11, 16, 20},
//    			  {23, 30, 34, 50}};
    	
    	int[][] matrix = {{1},{3}};
    	
    	int target = 1;
    	if (Search_a_2D_Matrix.searchMatrix(matrix, target) == true) {
			System.out.println("YES");
		}
    	else {
			System.out.println("NO");
		}
	}
}
