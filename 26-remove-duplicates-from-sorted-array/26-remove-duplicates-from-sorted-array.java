class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0, j=1, ans=1;
        while(j<nums.length){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
                ans++;
            }
            j++;
        }
        return ans;
    }
}


// class Solution {
//     public int removeDuplicates(int[] nums) {
//         int ans=0,l=nums.length,last=l-1;
//         if(l<2) return l;
//         if(nums[last]!=nums[last-1]) ans++;
//         int i=0;
//         while(i<last){
//             if(nums[i]==nums[i+1] && (i+1)!=last){
//                 for(int j=i+1;j<last;j++){
//                     nums[j]=nums[j+1];
//                 }
//                 last--;
//             }else{
//                 i++;
//                 ans++;
//             }
//         }
//         return ans;
//     }
// }