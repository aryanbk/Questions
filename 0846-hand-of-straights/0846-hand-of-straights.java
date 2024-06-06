class Solution {
    public boolean isNStraightHand(int[] hand, int gs) {
        int n = hand.length;
        Map<Integer, Integer> map = new HashMap<>();
        int mx = 0;
        int mn = 1000000000;
        
        for(int i=0; i<n; ++i){
            map.put(hand[i], map.getOrDefault(hand[i], 0)+1);
            mx = Math.max(mx, hand[i]);
            mn = Math.min(mn, hand[i]);
        }
        
        for(int i=mx; i>=mn; --i){
            while(map.getOrDefault(i, 0)>0){
                for(int x=0; x<gs; ++x){
                    int val = map.getOrDefault(i-x, 0);
                    if(val<=0)
                        return false;
                    map.put(i-x, val-1);
                }
            }
        }
        return true;
    }
}