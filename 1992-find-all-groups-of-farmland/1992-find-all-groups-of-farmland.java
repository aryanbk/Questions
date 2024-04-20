class Solution {
    
    int[] dir = new int[]{0, 1, 0, -1, 0};
    
    public int[][] findFarmland(int[][] land) {
        List<int[]> ans = new ArrayList<>();
        for(int i=0; i<land.length; ++i){
            for(int j=0; j<land[0].length; ++j){
                if(land[i][j] == 1)
                    bfs(i, j, land, ans);
            }
        }
        int[][] res = new int[ans.size()][4];
        for(int i=0; i<ans.size(); ++i) res[i] = ans.get(i);
        return res;
    }
    
    void bfs(int i0, int j0, int[][] land, List<int[]> fin){
        
        int[] ans = new int[]{land.length, land[0].length, -1, -1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i0, j0});
        
        while(!q.isEmpty()){
            int i = q.peek()[0];
            int j = q.peek()[1];
            ans[0] = Math.min(i, ans[0]);
            ans[1] = Math.min(j, ans[1]);
            ans[2] = Math.max(i, ans[2]);
            ans[3] = Math.max(j, ans[3]);
            q.poll();
            
            for(int x=0; x<4; ++x){
                int a = i+dir[x];
                int b = j+dir[x+1];
                if(a>=0 && b>=0 && a<land.length && b<land[0].length && land[a][b] == 1){
                    land[a][b] = 0;
                    q.offer(new int[]{a, b});
                }
            }
            
        }
        fin.add(ans);
    }
}