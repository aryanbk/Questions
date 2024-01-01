class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        
        for(int i = g.length-1, j = s.length -1; i>=0 && j>=0; --i){
            if(s[j] >= g[i]){
                ++ans;
                --j;
            }
        }
        
        return ans;
    }
}


// class Solution {
//     public int findContentChildren(int[] g, int[] s) {
//         Arrays.sort(g);
//         Arrays.sort(s);
        
//         int i = g.length-1;
//         int j = s.length-1;
//         int ans = 0;
        
//         while(i>=0 && j>=0){
//             if(g[i] <= s[j]){
//                 ++ans;
//                 --j;
//             }
//             --i;
//         }
//         return ans;
//     }
// }