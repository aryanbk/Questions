class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        
        for(int i=1; i<travel.length; ++i) travel[i] += travel[i-1];
        
        int ans = 0, lastM = -1, lastP = -1, lastG = -1;
        
        for(int i=garbage.length -1; i>=0; --i){
            if(lastM==-1 && garbage[i].contains("M"))
                lastM = i;
            if(lastG==-1 && garbage[i].contains("G"))
                lastG = i;
            if(lastP==-1 && garbage[i].contains("P"))
                lastP = i;
            ans += garbage[i].length();
        }
        
        if(lastM > 0)
            ans += travel[lastM - 1];
        if(lastP > 0)
            ans += travel[lastP - 1];
        if(lastG > 0)
            ans += travel[lastG - 1];
        
        return ans;
        
    }
}

// first attempt
// 
// class Solution {
//     public int garbageCollection(String[] garbage, int[] travel) {
//         for(int i=1; i<travel.length; ++i) travel[i] += travel[i-1];
//         return collect(garbage, travel, 'M') + collect(garbage, travel, 'G') + collect(garbage, travel, 'P');
        
//     }
//     private int collect(String[] gbg, int[] tvl, char g){
//         int ans = 0, last = 0;
//         for(int i=0; i<gbg.length; ++i){
            
//             // count no of occurances of g in gbg[i]
//             int count = (int)(gbg[i].chars().filter(ch -> ch == g).count());
//             ans += count;
//             if (count != 0) last = i;
//         }
//         return last>0 ? ans+tvl[last-1] : ans;
//     }
// }