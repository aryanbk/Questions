class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Integer[][] temp = new Integer[n][2];
        for(int i=0; i<n; ++i) temp[i] = new Integer[]{score[i], i};
        Arrays.sort(temp, (a, b) -> b[0]-a[0]);
        
        String[] ans = new String[n];
        for(int i=0; i<n; ++i){
            if(i==0) ans[temp[i][1]] = "Gold Medal";
            else if(i==1) ans[temp[i][1]] = "Silver Medal";
            else if(i==2) ans[temp[i][1]] = "Bronze Medal";
            else ans[temp[i][1]] = Integer.toString(i+1);
        }
        
        return ans;
    }
}