class Solution {
    public int minimumAverageDifference(int[] nums) {
        long sumt=0;
        for(int n: nums) sumt+=n;
        long mini = 1000000000, curr=0;
        int minind=-1,l=nums.length;
        
        for(int i=0; i<l; ++i){
            curr+=nums[i];
            sumt-=nums[i];
            long currDiff = (i!=l-1) ? Math.abs(curr/(i+1) - sumt/(l-i-1)) : Math.abs(curr/(i+1)) ;
            if(currDiff<mini){
                mini=currDiff;
                minind=i;
            }
        }
        return minind;
    }
}