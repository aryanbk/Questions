class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> vis = new HashSet<>();
        for(String d: deadends) vis.add(d);
        
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        
        for(int ans=0; !q.isEmpty(); ++ans){ // ans == steps
            int l = q.size();
            
            for(int i=0; i<l; ++i){
                String cur = q.poll();
                char[] ch = cur.toCharArray();
                
                if(cur.equals(target)) return ans;
                if(vis.contains(cur)) continue;
                vis.add(cur);
                
                for(int j=0; j<4; ++j){
                    char prev = ch[j]=='0' ? '9' : (char)(ch[j]-1);
                    char nx = ch[j]=='9' ? '0' : (char)(ch[j]+1);
                    
                    ch[j] = prev;
                    q.offer(String.valueOf(ch));
                    ch[j] = nx;
                    q.offer(String.valueOf(ch));
                    
                    ch[j] = cur.charAt(j);
                }
            }
        }
        return -1;
    }
}


// // StackOverFlow Error
//
// class Solution {
//     public int openLock(String[] deadends, String target) {
//         char[] ch = new char[]{'0', '0', '0', '0'};
//         Set<String> set = new HashSet<>();
//         for(String d: deadends) set.add(d);
        
//         return bk(ch, set, target.toCharArray(), new HashSet<>());
//     }
    
//     int bk(char[] ch, Set<String> set, char[] trgt, Set<String> vis){
//         String cur = String.valueOf(ch);
//         if(Arrays.equals(ch, trgt)) return 0;
//         if(set.contains(cur)) return -10000000;
//         vis.add(cur);
        
//         int ans = 1000000000;
        
//         for(int i=0; i<4; ++i){
//             int dig = ch[i]-'0';
//             int prev = (dig+9)%10;
//             int nx = (dig+1)%10;
//             ch[i] = (char)(prev+'0');
//             if(!set.contains(String.valueOf(ch)))
//                 ans = Math.min(ans, bk(ch, set, trgt, vis));
//             ch[i] = (char)(nx+'0');
//             if(!set.contains(String.valueOf(ch)))
//                 ans = Math.min(ans, bk(ch, set, trgt, vis));
//             ch[i] = (char)(dig+'0');
//         }
        
//         return ans;
//     }
// }