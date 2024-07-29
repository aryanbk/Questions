class Solution {
    public int numTeams(int[] rating) {
        int ans = 0;
        for(int i=0; i<rating.length; ++i){
            int smallLeft = 0;
            int largeLeft = 0;
            for(int j=0; j<i; ++j){
                if(rating[i] > rating[j]) ++smallLeft;
                else ++largeLeft;
            }
            
            int smallRight = 0;
            int largeRight = 0;
            for(int j=i+1; j<rating.length; ++j){
                if(rating[i] > rating[j]) ++smallRight;
                else ++largeRight;
            }
            
            ans += (smallLeft * largeRight) + (largeLeft * smallRight);
        }
        
        return ans;
    }
}