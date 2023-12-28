class Solution {
    Integer[][] dp;

    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        char[] ss = s.toCharArray();
        dp = new Integer[n][k + 1];
        return dfs(0, k, ss);
    }

    private int dfs(int i, int k, char[] s) {
        if (k < 0) return Integer.MAX_VALUE;
        if (i == s.length || s.length - i <= k) return 0;

        if (dp[i][k] != null) return dp[i][k];

        int[] f = new int[26];
        int most = 0, res = Integer.MAX_VALUE;

        for (int j = i; j < s.length; j++) {
            int idx = s[j] - 'a';
            f[idx]++;
            most = Math.max(most, f[idx]);
            int charsToDelete = j - i + 1 - most;
            if (k >= charsToDelete) {
                res = Math.min(res, getLen(most) + 1 + dfs(j + 1, k - charsToDelete, s));
            }
        }

        dp[i][k] = res;
        return res;
    }

    private int getLen(int most) {
        if (most == 1) return 0;
        if (most < 10) return 1;
        if (most < 100) return 2;
        return 3;
    }
}



// // class Solution {
    
// //     List<Character> ch;
// //     List<Integer> freq;
// //     public int getLengthOfOptimalCompression(String s, int k) {
// //         // List<Character> ch = new ArrayList<>();
// //         // List<Integer> freq = new ArrayList<>();
// //         int n = s.length();
// //         ch = new ArrayList<>();
// //         freq = new ArrayList<>();
// //         int i = 0;
// //         int j = 0;
// //         while(j<n){
// //             while(j<n && s.charAt(i) == s.charAt(j)){
// //                 ++j;
// //             }
// //             ch.add(s.charAt(i));
// //             freq.add(j-i-1);
// //             i = j;
// //         }
        
// //         return help(0, k);
// //     }
    
// //     int help(int i, int k){
// //         if(i==ch.size() || k==0){
// //             return size();
// //         }
// //         int ans = 1000000000;
// //         for(int x=0; x<Math.min(k, freq.get(i)); ++x){
// //             int temp = freq.get(i);
// //             freq.set(i, temp-x);
// //             ans = Math.min(ans, help(i+1, k-x));
// //             freq.set(i, temp);
// //         }
// //         return ans;
// //     }
    
// //     int size(){
// //         int ans = 0;
// //         for(int i=0; i<ch.size(); ++i){
// //             if(freq.get(i)==0)
// //                 continue;
// //             // if(freq.get(i)==1){
// //             //     ans++;
// //             //     continue;
// //             // }
// //             ans += Integer.toString(freq.get(i)).length() + 1;
// //         }
// //         return ans;
// //     }
// // }