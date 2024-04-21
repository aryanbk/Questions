class Solution {
    int[] freq;
    public int characterReplacement(String s, int k) {
        freq = new int[26];
        int ans = 0;
        for(int l=0, r=0; r<s.length(); ++r){
            ++freq[s.charAt(r)-'A'];
            
            while(r-l+1 - max() > k)
                --freq[s.charAt(l++)-'A'];
            
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
    int max(){
        int ans = 0;
        for(int f: freq) ans = Math.max(ans, f);
        return ans;
    }
}



//// mis-understood the question

// class Solution {
//     public int characterReplacement(String s, int k) {
//         int[] freq = new int[26];
//         int mx = 0;
//         for(int i=0; i<s.length(); ++i){
//             ++freq[s.charAt(i)-'A'];
//             mx = Math.max(mx, freq[s.charAt(i)-'A']);
//         }
        
//         var pq = new PriorityQueue<Integer>();
//         for(int i=0; i<26; ++i) pq.offer(freq[i]);
        
//         int ans = mx;
//         k = Math.min(k, s.length()-ans);
//         while(k>0){
//             int popped = pq.poll();
//             ans += Math.min(k, popped);
//             k -= popped;
//         }
        
//         return ans;
//     }
// }