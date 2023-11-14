class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        for(int i=0; i<s.length(); ++i){
            int ind = s.charAt(i)-97;
            if(first[ind] == -1)
                first[ind] = i;
            last[ind] = i;
        }
        int ans = 0;
        for(int i=0; i<26; ++i){
            Set<Character> set =  new HashSet<>();
            for(int j=first[i]+1; j<last[i]; ++j){
                set.add(s.charAt(j));
            }
            ans += set.size();
        }
        return ans;
    }
}