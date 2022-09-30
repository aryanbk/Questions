class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int l=nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<l; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int lo=i+1, hi=l-1;
            while(lo<hi){
                int sum=nums[i]+nums[lo]+nums[hi];
                if(sum<0) lo++;
                else if(sum>0) hi--;
                else{
                    ans.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    int p=lo;
                    while(lo<l && nums[p]==nums[lo]) ++lo;
                    p=hi;
                    while(hi>=0 && nums[p]==nums[hi]) --hi;
                }
            }
        }
        return ans;
    }
}