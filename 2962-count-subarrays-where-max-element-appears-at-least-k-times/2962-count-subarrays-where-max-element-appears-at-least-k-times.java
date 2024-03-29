class Solution {
    public long countSubarrays(int[] nums, int k) {
        int mx = 0;
        long ans = 0;
        int count = 0;
        
        for(int n: nums) mx = Math.max(mx, n);

        for(int l=0, r=0; r<nums.length; ++r){
            if(nums[r] == mx) ++count;
            while(count >= k){
                if(nums[l] == mx) --count;
                ++l;
            }
            ans += l;
        }
        return ans;
    }
}


// wont work WA #1
//
// class Solution {
//     public long countSubarrays(int[] nums, int k) {
//         int mx = 0;
//         long ans = 0;
//         for(int n: nums) mx = Math.max(mx, n);
//         // int[] last = new int[k];
//         Deque<Integer> dq = new LinkedList<>();
//         for(int i=0; i<nums.length; ++i){
//             if(nums[i] == mx){
//                 dq.add(i);
//                 while(dq.size() > k)
//                     dq.pollFirst();
//                 if(dq.size() == k)
//                     ans += (long) dq.getFirst() + 1;
//             }
//         }
//         return ans;
//     }
// }


// class Solution {
//     public long countSubarrays(int[] nums, int k) {
//         long ans = 0;
//         int mx = -1;
//         int count = 0;
//         Deque<Integer> dq = new LinkedList<>();
//         for(int l=0, r=0; r<nums.length; ++r){
//             if(mx == nums[r]) ++count;
//             else if(mx < nums[r]){
//                 mx = nums[r];
//                 count = 1;
//             }
//             while(!dq.isEmpty() && dq.peek()<nums[r])
//                 dq.poll();
//             dq.offer(nums[r]);
            
//         }
//     }
// }