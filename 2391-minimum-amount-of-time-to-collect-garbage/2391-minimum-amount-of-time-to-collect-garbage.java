class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int ans = 0;
        for(int i=1; i<travel.length; ++i)
            travel[i] += travel[i-1];
        ans += collect(garbage, travel, 'M');
        System.out.println(ans);
        ans += collect(garbage, travel, 'G');
        System.out.println(ans);
        ans += collect(garbage, travel, 'P');
        System.out.println(ans);
        
        return ans;
        
    }
    private int collect(String[] gbg, int[] tvl, char g){
        int ans = 0;
        int last = 0;
        for(int i=0; i<gbg.length; ++i){
            int occur = (int)(gbg[i].chars().filter(ch -> ch == g).count());
            if (occur != 0)
                last = i;
            ans += occur;
            // ans += i<tvl.length ? tvl[i] : 0;
        }
        // if (last>0)
            // ans += tvl[last];
        return last>0 ? ans+tvl[last-1] : ans;
    }
    // public static int count(String str, char character) {
        // return str.chars().filter(ch -> ch == character).count();
    // }
}