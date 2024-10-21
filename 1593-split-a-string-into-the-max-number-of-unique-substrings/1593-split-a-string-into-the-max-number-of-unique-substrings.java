class Solution {
    public int maxUniqueSplit(String s) {
        return bfs(0, new HashSet<String>(), s);
    }
    
    int bfs(int i, Set<String> set, String s){
        if(i==s.length()) return 0;
        int res = -1;
        
        for(int x=i+1; x<=s.length(); ++x){
            String subs = s.substring(i, x);
            if(!set.add(subs)) continue;
            int nx = bfs(x, set, s);
            res = Math.max(res, 1+nx);
            set.remove(subs);
        }
        return res;
    }
}





// class Solution {
//     public int maxUniqueSplit(String s) {
//         return bfs(0, new HashSet<String>(), s);
//     }
    
//     int bfs(int i, Set<String> set, String s){
//         if(i==s.length()) return 0;
//         int res = -1;
//         for(int x=i+1; x<=s.length(); ++x){
//             String subs = s.substring(i, x);
//             if(!set.contains(subs)){
//                 set.add(subs);
//                 int nx = bfs(x, set, s);
//                 res = Math.max(res, 1+nx);
//                 set.remove(subs);
//             }
//         }
//         return res;
//     }
// }