class Solution {
    public boolean halvesAreAlike(String s) {
        String s2 = s.toLowerCase();
        int n = s.length();
        int vow = 0;
        int vow2 = 0;
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        
        for(int i=0; i<n/2; ++i){
            vow += set.contains(s2.charAt(i)) ? 1 : -1;
            vow2 += set.contains(s2.charAt(n-i-1)) ? 1 : -1;
        }
        
        return vow == vow2;
    }
}