class Solution {
    int mask = 0;
    public int findTheLongestSubstring(String s) {
        var map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int ans = 0;
        
        for(int i=0; i<s.length(); ++i){
            help(s.charAt(i));
            map.putIfAbsent(mask, i);
            ans = Math.max(ans, i-map.get(mask));
        }
        
        return ans;
    }
    
    void help(char c){
        if(c == 'a') mask ^= 1;
        if(c == 'e') mask ^= 2;
        if(c == 'i') mask ^= 4;
        if(c == 'o') mask ^= 8;
        if(c == 'u') mask ^= 16;
    }
}



// class Solution {
//     public int findTheLongestSubstring(String s) {
//         int[] map = new int[]{'a'-'a', 'e'-'a', 'i'-'a', 'o'-'a', 'u'-'a'};
//         int[] first = new int[]{-1, -1, -1, -1, -1};
//         boolean[] odd = new boolean[5];
//         int ans = 0;
        
//         for(int i=0; i<s.length(); ++i){
//             int c = find(s.charAt(i));
//             if(c != -1){
//                 odd[c] ^= true;
//                 if(first[c] == -1) first[c] = i;
//             }
            
//             int mxIdx = -1;
//             for(int x=0; x<5; ++x){
//                 if(odd[x]) mxIdx = Math.max(mxIdx, first[x]);
//             }
            
//             ans = Math.max(ans, i-mxIdx);
//         }
        
//         return ans;
//     }
//     int find(char c){
//         if(c == 'a') return 0;
//         if(c == 'e') return 1;
//         if(c == 'i') return 2;
//         if(c == 'o') return 3;
//         if(c == 'u') return 4;
//         return -1;
//     }
// }