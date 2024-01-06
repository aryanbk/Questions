// // O(n)
// // O(n)
//
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int m = findKthLargest(nums, (n+1)/2); //median
        int hi = 1;
        int lo = n%2==0 ? n-2 : n-1;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for(var x: nums){
            if(x < m){
                ans[lo] = x;
                lo-=2;
            }else if (x > m) {
                ans[hi] = x;
                hi+=2;
            }
        }
        for(int i=0; i<n; ++i)
            nums[i] = ans[i]==-1 ? m : ans[i];
    }
    
    int findKthLargest(int[] nums, int k){
        var pq = new PriorityQueue<Integer>();
        for(var n: nums){
            pq.offer(n);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }
}


// // O(n log n)
// // O(n)
//
// class Solution {
//     public void wiggleSort(int[] nums) {
//         int n = nums.length;
//         Arrays.sort(nums);
//         int[] ans = new int[n];
        
//         int i = n-1;
//         int j = 1;
//         while(j<n){
//             ans[j] = nums[i--];
//             j+=2;
//         }
//         j = 0;
//         while(j<n){
//             ans[j] = nums[i--];
//             j+=2;
//         }
        
//         for(int x=0; x<n; ++x)
//             nums[x] = ans[x];
        
//     }
// }


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