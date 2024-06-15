class Solution {
    int n;
    int[][] ip;
    
    public int findMaximizedCapital(int k, int w, int[] p, int[] c) {
        n = p.length;
        ip = new int[n][2];
        
        for(int i=0; i<n; ++i)
            ip[i] = new int[]{p[i], c[i]};
        Arrays.sort(ip, (a, b) -> a[1]-b[1]);
        
        var pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[1], a[1]));
        int cur = 0;
        int ans = 0;
        
        while(k-->0){
            while(cur<n && ip[cur][1]<=w){
                // System.out.println(cur+" "+ip[cur][1]+" "+w);
                pq.offer(new int[]{cur, ip[cur][0]});
                ++cur;
            }
            // for(var pp: pq){
                // System.out.println(Arrays.toString(pp));
            // }
            // System.out.println(w);
            if(pq.isEmpty()) break;
            int[] mx = pq.poll();
            // cur = mx[0]+1;
            ans += mx[1];
            w += mx[1];
        }
        
        return w;
        
        
    }
}







// class Solution {
//     int n;
//     int[][] ip;
    
//     public int findMaximizedCapital(int k, int w, int[] p, int[] c) {
//         n = p.length;
//         ip = new int[n][2];
        
//         for(int i=0; i<n; ++i)
//             ip[i] = new int[]{p[i], c[i]};
//         Arrays.sort(ip, (a, b) -> a[1]-b[1]);
//         return knap(0, w, k);
//     }
    
//     int knap(int i, int w, int k){
//         if(i==n || k==0)
//             return 0;
        
        
        
//         int ans = knap(i+1, w, k);
//         for(int x=i; x<n && ip[x][1]<=w; ++x){
//             ans = Math.max(ans, ip[x][0] + knap(x+1, w-ip[x][1]+ip[x][0], k-1));
//         }
//         return ans;
//     }
// }
