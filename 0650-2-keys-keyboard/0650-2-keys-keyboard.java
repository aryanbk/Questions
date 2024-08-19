class Solution {
    Integer[][] memo;
    int n;
    
    public int minSteps(int n) {
        if(n==1) return 0;
        memo = new Integer[1000][1000];
        this.n = n;
        return solve(1, 1)+1;
    }
    
    int solve(int cur, int clip){
        if(cur==n) return 0;
        if(cur>n || clip>n) return 10000000;
        if(memo[cur][clip] != null) return memo[cur][clip];
        memo[cur][clip] = Math.min(solve(cur+clip, clip), solve(cur+clip, cur+clip)+1)+1;
        return memo[cur][clip];
    }
}


// class Solution {
//     public int minSteps(int n) {
//         var q = new LinkedList<List<Integer>>();
//         q.offer(List.of(1, 0));
//         var set = new HashSet<List<Integer>>();
//         int lvl = 0;
        
//         while(!q.isEmpty()){
//             int l = q.size();
//             for(int i=0; i<l; ++i){
//                 var node = q.poll();
//                 int cur = node.get(0);
//                 int clip = node.get(1);

//                 if(cur==n) return lvl;
                
//                 if(set.contains(node)) continue;
//                 set.add(node);
                
//                 q.offer(List.of(cur+clip, clip));
//                 q.offer(List.of(cur, cur));
//             }
//             ++lvl;
//         }
        
//         return -1;
//     }
    
// }