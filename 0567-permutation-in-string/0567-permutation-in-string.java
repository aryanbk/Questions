class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int[] freq = new int[26];
        
        for(int i=0; i<n; ++i) ++freq[s1.charAt(i) - 'a'];
        
        for(int l=0, r=0; r<s2.length(); ++r){
            --freq[s2.charAt(r) - 'a'];
            
            if(r-l+1 == n){
                if(allZeros(freq)) return true;
                ++freq[s2.charAt(l++) - 'a'];
            }
        }
        
        return false;
    }
    
    
    boolean allZeros(int[] a){
        for(int i=0; i<a.length; ++i)
            if(a[i] != 0) return false;
        return true;
    }
}