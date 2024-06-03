class Solution {
    public int appendCharacters(String s, String t) {
        int i = 0;
        int j = 0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i) == t.charAt(j))
                ++j;
            ++i;
        }
        return t.length()-j;
    }
}




// // it is not DP
//
// class Solution {
//     Map<List<Integer>, Integer> memo;
//     public int appendCharacters(String s, String t) {
//         memo = new HashMap<>();
//         return solve(0, 0, s, t);
//     }
//     int solve(int i, int j, String s, String t){
//         if(i>=s.length()) return t.length()-j;
//         if(j>=t.length()) return 0;
        
//         var key = List.of(i, j);
        
//         if(memo.containsKey(key)) return memo.get(key);
        
//         if(s.charAt(i) == t.charAt(j)){
//             while(i<s.length() && j<t.length() && s.charAt(i) == t.charAt(j)){
//                 ++i;
//                 ++j;
//             }
//             memo.put(key, solve(i+1, j+1, s, t));
//         }
//         else memo.put(key, solve(i+1, j, s, t));
//         return memo.get(key);
//     }
// }








// // memory limit exeeeded
//
// class Solution {
//     Integer[][] memo;
//     public int appendCharacters(String s, String t) {
//         memo = new Integer[s.length()+1][t.length()+1];
//         return solve(0, 0, s, t);
//     }
//     int solve(int i, int j, String s, String t){
//         if(i==s.length()) return t.length()-j;
//         if(j>=t.length()) return 0;
        
//         if(memo[i][j] != null) return memo[i][j];
        
//         if(s.charAt(i) == t.charAt(j)){
//             while(i<s.length() && j<t.length() && s.charAt(i) == t.charAt(j)){
//                 ++i;
//                 ++j;
//             }
//             memo[i][j] = solve(i, j, s, t);
//         }
//         else memo[i][j] = solve(i+1, j, s, t);
//         return memo[i][j];
//     }
// }