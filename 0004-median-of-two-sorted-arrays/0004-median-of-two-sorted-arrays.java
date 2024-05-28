class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int m = nums1.length;
        int n = nums2.length;
        int[] cmb = new int[m+n];
        
        while(i<m && j<n){
            if(nums1[i] < nums2[j]){
                cmb[i+j] = nums1[i];
                i++;
            }
            else{
                cmb[i+j] = nums2[j];
                j++;
            }
        }
        
        while(i<m){
            cmb[i+j] = nums1[i];
            ++i;
        }
        while(j<n){
            cmb[i+j] = nums2[j];
            ++j;
        }
                
        double ans = (m+n)%2 != 0 ? cmb[(m+n-1)/2] : 
                ((double)(cmb[(m+n+1)/2] + cmb[(m+n-1)/2])) / 2;

        return ans; 
    }
}