class Solution {
    public long findMaximumScore(List<Integer> nums) {
        int cur = 0;
        long ans = 0;
        for(int i=1; i<nums.size(); ++i){
            if(nums.get(cur) < nums.get(i)){
                ans += (long)nums.get(cur) * ((long)(i - cur));
                cur = i;
            }
        }
        return ans + (long)nums.get(cur) * ((long)(nums.size()-1 - cur));
    }
}