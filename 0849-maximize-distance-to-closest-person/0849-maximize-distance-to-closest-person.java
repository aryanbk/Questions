class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int[] dis = new int[n];
        
        Arrays.fill(dis, 20001);
        if(seats[n-1]==1) dis[n-1] = 0;
        
        for(int i=n-2; i>=0; --i){
            dis[i] = (seats[i]==1) ? 0 : dis[i+1]+1;
        }
        
        int maxdis = Integer.MIN_VALUE, curr = 20001;
        for(int i=0; i<n; ++i){
            curr = (seats[i]==1) ? 0 : curr+1;
            maxdis = Math.max(maxdis, Math.min(curr, dis[i]));
        }
        
        return maxdis;
    }
}