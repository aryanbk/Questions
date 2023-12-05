class Solution {
    List<Integer> listLIS;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        lengthOfLIS(nums);
        return listLIS;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] map = new int[n];
        
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < i; ++j) {
                if(nums[i]%nums[j] == 0) {
                    if(dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        map[i] = j;
                    }
                }
            }
        }
        
        int maxLen = 0;
        int endIdx = 0;
        for(int i = 0; i < n; ++i) {
            if(dp[i] > maxLen) {
                maxLen = dp[i];
                endIdx = i;
            }
        }
        
        listLIS = new ArrayList<>();
        while(maxLen > 0) {
            listLIS.add(nums[endIdx]);
            endIdx = map[endIdx];
            maxLen--;
        }
        
        Collections.reverse(listLIS);
        System.out.println(listLIS);
        
        return listLIS.size(); // Return the length of LIS
    }
}
