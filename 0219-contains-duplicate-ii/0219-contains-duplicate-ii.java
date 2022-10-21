class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int l=0;
        HashSet<Integer> set = new HashSet<>();
        for(int r=0, n=nums.length; r<n; ++r){
            set.add(nums[r]);
            if(r-l == k){
                set.remove(nums[l]);
                l+=1;
            }
            if(set.size() != r-l+1)
                return true;
        }
        return false;
    }
}