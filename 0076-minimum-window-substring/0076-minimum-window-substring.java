class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        
        int[] freq = new int['z'-'A'+1];
        for(int i=0; i<t.length(); ++i) ++freq[t.charAt(i)-'A'];
        
        int[] ans = {0, s.length()+2};
        
        for(int l=0, r=0; r<m; ++r){
            --freq[s.charAt(r)-'A'];
            while(valid(freq)){
                if(r-l < ans[1]-ans[0]) ans = new int[]{l, r};
                ++freq[s.charAt(l)-'A'];
                ++l;
            }
        }
        
        return ans[0]==0 && ans[1]==s.length()+2 ? "" : s.substring(ans[0], ans[1]+1);
        
    }
    
    boolean valid(int[] freq){
        for(int i=0; i<'z'-'A'+1; ++i) if(freq[i]>0) return false;
        return true;
    }
}