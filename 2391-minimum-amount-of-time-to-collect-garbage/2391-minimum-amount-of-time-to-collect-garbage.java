class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        for(int i=1; i<travel.length; ++i) travel[i] += travel[i-1];
        return collect(garbage, travel, 'M') + collect(garbage, travel, 'G') + collect(garbage, travel, 'P');
        
    }
    private int collect(String[] gbg, int[] tvl, char g){
        int ans = 0, last = 0;
        for(int i=0; i<gbg.length; ++i){
            
            // count no of occurances of g in gbg[i]
            int count = (int)(gbg[i].chars().filter(ch -> ch == g).count());
            ans += count;
            if (count != 0) last = i;
        }
        return last>0 ? ans+tvl[last-1] : ans;
    }
}