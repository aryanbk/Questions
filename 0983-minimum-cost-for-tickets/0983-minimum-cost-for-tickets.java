class Solution {
    int[][] memo;
    public int mincostTickets(int[] days, int[] costs) {
        memo = new int[days.length][366];
        for(int[] m1: memo) Arrays.fill(m1, -1);
        
        return help(0, 0, days, costs);
    }
    private int help(int i, int freeTill, int[] days, int[] costs){
        if(i==days.length) return 0;
        
        if(memo[i][freeTill] != -1) return memo[i][freeTill];
        
        int ans = Integer.MAX_VALUE;
        
        if(freeTill>=days[i]) ans = Math.min(ans, help(i+1, freeTill, days, costs));
        else{
            ans = Math.min(ans, costs[0]+help(i+1, 0,days, costs));
            
            int newFreeTill = Math.min(days[i]+6, 365);
            ans = Math.min(ans, costs[1]+help(i+1, newFreeTill, days, costs));
            
            newFreeTill = Math.min(days[i]+29, 365);
            ans = Math.min(ans, costs[2]+help(i+1, newFreeTill, days, costs));
        }
        memo[i][freeTill] = ans;
        return memo[i][freeTill];
    }
}