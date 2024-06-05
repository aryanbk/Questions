// using streams
//
class Solution {
    public List<String> commonChars(String[] words) {
        int n = words.length;
        int[] freq = new int[26];
        Arrays.fill(freq, 100000000);
        
        for(String word: words){
            int[] f = new int[26];
            word.chars().forEach(c -> ++f[c-'a']);
            IntStream.range(0, 26)
                .forEach(i -> freq[i] = Math.min(freq[i], f[i]));
        }
        
        List<String> ans = new ArrayList<>();
        
        IntStream.range('a', 'z'+1)
            .forEach(c -> 
                    ans.addAll(Collections.nCopies(freq[c-'a'], ""+(char)c)));
        
        return ans;
    }
}




// class Solution {
//     public List<String> commonChars(String[] words) {
//         int n = words.length;
//         int[][] f = new int[n][26];
        
//         for(int i=0; i<words.length; ++i){
//             for(int j=0; j<words[i].length(); ++j){
//                 ++f[i][words[i].charAt(j)-'a'];
//             }
//         }
        
//         int[] minF = new int[26];
//         Arrays.fill(minF, 1000000000);
        
//         for(int c=0; c<26; ++c){
//             for(int i=0; i<words.length; ++i){
//                 minF[c] = Math.min(minF[c], f[i][c]);
//             }
//         }
        
//         List<String> ans = new ArrayList<>();
        
//         for(int i=0; i<26; ++i){
//             for(int x=0; x<minF[i]; ++x){
//                 char ch = (char)(i+'a');
//                 ans.add(String.valueOf(ch));
//             }
//         }
        
//         return ans;
//     }
// }