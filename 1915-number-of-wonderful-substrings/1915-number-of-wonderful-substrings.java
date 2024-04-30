class Solution {
    Map<Integer, Integer> prev;
    
    public long wonderfulSubstrings(String word) {
        long ans = 0;
        int n = word.length();
        int freq = 0;
        prev = new HashMap<>();
        prev.put(0, 1);
        
        for(int l=0, r=0; r<n; ++r){
            int cur = word.charAt(r)-'a';
            int mask = 1<<cur;
            
            freq = freq ^ mask;
            ans += helper(freq);
            prev.put(freq, prev.getOrDefault(freq, 0) + 1);
        }
        
        return ans;
    }
    
    int helper(int f){
        int ans = 0;
        
        for(int i=0; i<10; ++i)
            ans += prev.getOrDefault((1<<i) ^ f, 0);
        
        ans += prev.getOrDefault(f, 0);
        return ans;
    }
}