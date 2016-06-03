import java.util.ArrayList;
import java.util.List;
//自己的想法就是用额外空间去保存res
//最佳方式是，从后往前比较最大值插入到最终位置（因为两个都是有序的数组因此最大值比较必定是最大的一个），这样不需要额外的空间，也能够在O(n)的时间下完成比较

/*public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       int ind = n + m - 1 ;
       int p1 = m-1 , p2 = n-1;
       while(ind >= 0){
          if(p1 < 0) nums1[ind--] = nums2[p2--];
          else if(p2 < 0) nums1[ind--] = nums1[p1--];
          else nums1[ind--] = (nums1[p1] > nums2[p2]) ? nums1[p1--] : nums2[p2--] ; 
      }
   }
}*/

public class Merge_Sorted_Array {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> res = new ArrayList<Integer>();
        int i,j;
        i = 0;
        j = 0;
        while(i<m && j<n){
            if(nums1[i]>nums2[j]){
                res.add(nums2[j]);
                ++j;
            }
            else{
                res.add(nums1[i]);
                ++i;
            }
        }
        if(i==m){
            while(j<n){
                res.add(nums2[j]);
                ++j;
            }
        }
        else if(j==n){
        	 while(i < m){
                 res.add(nums1[i]);
                 ++i;
             }
        }
        for(int k = 0; k < m+n;k++){
            nums1[k]=res.get(k);
        }
        return;
    }
	
	public static void main(String[] args) {
		int[] nums1 = new int[10];
		nums1[0] = 4;
		nums1[1] = 5;
		nums1[2] = 6;
		int[] nums2 = {1,2,3};
		merge(nums1, 3, nums2,3);
	}
}
