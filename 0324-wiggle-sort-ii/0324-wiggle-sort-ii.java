class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] ans = new int[n];
        
        int i = n-1;
        int j = 1;
        while(j<n){
            ans[j] = nums[i--];
            j+=2;
        }
        j = 0;
        while(j<n){
            ans[j] = nums[i--];
            j+=2;
        }
        
        for(int x=0; x<n; ++x)
            nums[x] = ans[x];
        
    }
}


// // wrong approch - wont work
//
// class Solution {
//     public void wiggleSort(int[] nums) {
//         int n = nums.length;
//         Arrays.sort(nums);
//         int[] ans = new int[n];
        
//         for(int i=0, j=(n+1)/2; i<n/2; ++i, ++j){
//             ans[2*i] = nums[i];
//             ans[(2*i)+1] = nums[j];
//         }
//         if(n%2==1) ans[n-1] = nums[n/2];
        
//         for(int i=0; i<n; ++i)
//             nums[i] = ans[i];
//     }
// }