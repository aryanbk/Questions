class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int cur = 0;
        int i = 1;
        while(!(cur>=target && (cur-target)%2==0)){
            cur += i++;
        }
        return i-1;
    }
}



// class Solution {
//     public int reachNumber(int target) {
//         target = Math.abs(target);
//         int step = 0;
//         int sum = 0;
//         while (sum < target) {
//             step++;
//             sum += step;
//         }
//         while ((sum - target) % 2 != 0) {
//             step++;
//             sum += step;
//         }
//         return step;
//     }
// }






// // works but TLE
//
// class Solution {
//     public int reachNumber(int target) {
//         int t = Math.abs(target);
//         Set<List<Integer>> vis = new HashSet<>();
//         Queue<Integer> q = new LinkedList<>();
//         q.offer(0);

//         for(int ans=0; !q.isEmpty(); ++ans){
//             int l = q.size();
//             // System.out.println(q+" "+ans);
            
//             for(int i=0; i<l; ++i){
//                 int cur = Math.abs(q.poll());
//                 // int cur = q.poll();
//                 if(t==cur) return ans;
                
//                 // if(vis.contains(List.of(cur, ans)) ||
//                 //   vis.contains(List.of(-cur, ans))) continue;
//                 // vis.add(List.of(cur, ans));
//                 // vis.add(List.of(-cur, ans));

//                 if(vis.contains(List.of(cur, ans))) continue;
//                 vis.add(List.of(cur, ans));
                
                
//                 int plus = cur+ans+1;
//                 // int min = Math.abs(cur-step-1);
//                 int min = Math.abs(cur - (ans+1));
                
//                 // if(plus<=t && !vis[plus]){
//                 if(!vis.contains(plus)){
//                     // vis[plus] = true;
//                     // vis.add(plus);
//                     q.offer(plus);
//                 }
//                 if(!vis.contains(min)){
//                     // vis[min] = true;
//                     // vis.add(min);
//                     q.offer(min);
//                 }
//             }
//             // step++;
//         }
//         return -1;
//     }
// }



// // works but TLE
//
// class Solution {
//     public int reachNumber(int target) {
//         int t = Math.abs(target);
//         Set<List<Integer>> vis = new HashSet<>();
//         Queue<Integer> q = new LinkedList<>();
//         q.offer(0);

//         for(int ans=0; !q.isEmpty(); ++ans){
//             int l = q.size();
//             System.out.println(q+" "+ans);
//             // for(int x: q){
//             //     System.out.println(x);
//             // }
            
//             for(int i=0; i<l; ++i){
//                 // int cur = Math.abs(q.poll());
//                 int cur = q.poll();
//                 if(t==cur) return ans;
                
//                 if(vis.contains(List.of(cur, ans)) ||
//                   vis.contains(List.of(-cur, ans))) continue;
//                 vis.add(List.of(cur, ans));
//                 vis.add(List.of(-cur, ans));
                
                
//                 int plus = cur+ans+1;
//                 // int min = Math.abs(cur-step-1);
//                 int min = cur - (ans+1);
                
//                 // if(plus<=t && !vis[plus]){
//                 // if(!vis.contains(plus)){
//                     // vis[plus] = true;
//                     // vis.add(plus);
//                     q.offer(plus);
//                 // }
//                 // if(!vis.contains(min)){
//                     // vis[min] = true;
//                     // vis.add(min);
//                     q.offer(min);
//                 // }
//             }
//             // step++;
//         }
//         return -1;
//     }
// }


// // 1st attempt
//
// class Solution {
//     public int reachNumber(int target) {
//         int t = Math.abs(target);
//         Queue<Integer> q = new LinkedList<>();
//         int step = 1;
//         q.add(1);
//         boolean[] vis = new boolean[t+1];
//         vis[0] = true;
//         vis[1] = true;
//         while(!q.isEmpty()){
//             int l = q.size();
//             for(int x: q){
//                 System.out.println(x);
//             }
            
//             for(int i=0; i<l; ++i){
//                 int cur = Math.abs(q.poll());
//                 if(t==cur)
//                     return step;
//                 int plus = cur+step+1;
//                 int min = Math.abs(cur-step-1);
//                 if(plus<=t && !vis[plus]){
//                     vis[plus] = true;
//                     q.offer(plus);
//                 }
//                 if(min<=t && !vis[min]){
//                     vis[min] = true;
//                     q.offer(min);
//                 }
//             }
//             step++;
//         }
//         return -1;
//     }
// }