class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        
        // Finding the first and last occurrence of each character in the string
        for(int i = 0; i < s.length(); ++i) {
            int ind = s.charAt(i) - 'a';
            if(first[ind] == -1)
                first[ind] = i;
            last[ind] = i;
        }
        
        int ans = 0;
        for(int i = 0; i < 26; ++i) {
            // Counting distinct characters between the first and last occurrence of each character
            boolean[] seen = new boolean[26];
            for(int j = first[i] + 1; j < last[i]; ++j) {
                int index = s.charAt(j) - 'a';
                if (!seen[index]) {
                    seen[index] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}



// not-clean

// class Solution {
//     public int countPalindromicSubsequence(String s) {        
//         int[] first = new int[26];
//         int[] last = new int[26];
//         for(int i=0; i<s.length(); ++i){
//             int ind = s.charAt(i)-97;
//             if(first[ind] == 0)
//                 first[ind] = i+1;
//             last[ind] = i+1;
//         }
//         int ans = 0;
//         for(int i=0; i<26; ++i){
//             Set<Character> set =  new HashSet<>();
//             for(int j=first[i]; j<last[i]-1; ++j){
//                 set.add(s.charAt(j));
//             }
//             ans += set.size();
//         }
//         return ans;
//     }
// }