 class Solution {
      public int strangePrinter(String s) {

        if(s==null || s.length() == 0)
            return 0;

        int n = s.length();
        int[][] state = new int[n][n];

        for(int i=0; i< n; i++)
            state[i][i] = 1;

        for(int i=n-1; i >=0 ; i--){
            for(int j = i+1; j< n; j++){
                if(j-i == 1){
                    if(s.charAt(i) == s.charAt(j))
                       state[i][j] =  state[i][j-1];
                    else
                       state[i][j] = state[i][j-1] + 1;

                } else{
                    state[i][j] = Integer.MAX_VALUE;

                    for(int k=i; k<j; k++){
                        int tmp = state[i][k] + state[k+1][j];
                        state[i][j] = Math.min(state[i][j] ,tmp);
                    }
                    
                    if(s.charAt(i) == s.charAt(j)){
                        state[i][j]--;
                    }
                }
            }
        }

        return state[0][n-1];
    }
}






// class Solution {
    
//     public int strangePrinter(String s) {
//         return solve(0, s.charAt(0),true, s);
//     }
    
    
//     int solve(int i, char prev, boolean follow, String s){
//         if(i==s.length()) return prev==s.charAt(i-1) ? 1 : 2;

//         char cur = s.charAt(i);
//         boolean same = cur==prev;;
//         if(follow && same){
//             return solve(i+1, cur, follow, s);
//         }
//         else if(!follow && !same){
//             int ans = solve(i+1, cur, true, s)+2;
//             if(cur==s.charAt(i-1)) ans = Math.min(ans, solve(i+1, prev, false, s));
//             return ans;
//         }
//         else if(follow && !same){
//             return Math.min(solve(i+1, cur, true, s)+1, solve(i+1, prev, false, s));
//         }
//         else{
//             return solve(i+1, cur, true, s)+1;
//         }
//     }
// }