class Solution {
    Map<Integer, Integer> prev;
    
    public long wonderfulSubstrings(String word) {
        long ans = 0;
        int n = word.length();
        // System.out.println(n);
        // int[] freq = new int[26];
        int freq = 0;
        prev = new HashMap<>();
        prev.put(0, 1);
        
        for(int l=0, r=0; r<n; ++r){
            char ch = word.charAt(r);
            int cur = ch-'a';
            
            int mask = 1<<cur;
            
            freq = freq ^ mask;
            int help = helper(freq);
            // System.out.println(help+" "+freq);
            ans+=help;
            prev.put(freq, prev.getOrDefault(freq, 0)+1);
            
        }
        
        // System.out.println(prev.size());
        return ans;
    }
    
    int helper(int f){
        // if(f==0) return prev.getOrDefault(0, 0);
        // int cur = 1;
        int ans = 0;
        // while(cur <= f){
        //     ans += prev.getOrDefault(f-cur, 0);
        //     cur *= 2;   
        // }
        
        for(int i=0, cur=1; i<10; ++i, cur *= 2){
            ans += prev.getOrDefault(cur^f, 0);
        }
        
        ans += prev.getOrDefault(f, 0);
        // for(int i: prev.keySet()){
        //     if(isPowerOfTwo(f^i))
        //         ans += prev.get(i);
        // }
        return ans;
    }
    // public boolean isPowerOfTwo(int n) {
    //     return ((n & (n-1)) == 0);
    // }
    
    
}