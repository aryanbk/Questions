class Solution {
    
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int largestIsland(int[][] grid) {
        
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        
        // union existing one's 
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                if(grid[i][j]==0) continue;
                for(int[] d: dir){
                    int x = i + d[0];
                    int y = j + d[1];
                    if(x>=0 &&x<n && y>=0 && y<n && grid[x][y] == 1)
                        ds.union(i*n+j, x*n+y);
                }
            }
        }
        
        // ans contains max area of all existing 1s
        int ans = ds.getMaxSize();

        
        // check all the 0s
        // check adj cells
        // if some nbr's par isnt in set (already added)
        // add it to area
        // maximize answer by comparing area
        
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                if(grid[i][j]==1) continue;
                
                Set<Integer> set = new HashSet<>();
                int area = 1;
                
                for(int[] d: dir){
                    int x = i + d[0];
                    int y = j + d[1];
                    if(x>=0 &&x<n && y>=0 && y<n && grid[x][y] == 1){
                        int par = ds.find(x*n + y);
                        if(!set.contains(par)){
                            area += ds.getSize(par);
                            set.add(par);
                        }
                    }
                }
                ans = Math.max(ans, area);
            }
        }
        
        return ans;
    }
    
}


class DisjointSet {
    private int[] parent;
    private int[] size;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);

        if (rootI != rootJ) {
            if (size[rootI] < size[rootJ]) {
                parent[rootI] = rootJ;
                size[rootJ] += size[rootI];
            } else {
                parent[rootJ] = rootI;
                size[rootI] += size[rootJ];
            }
        }
    }
    
    public int getSize(int x){
        return size[x];
    }
    
    public int getMaxSize(){
        int mx = Integer.MIN_VALUE;
        for(int s: size)
            mx = Math.max(mx, s);
        return mx;
    }
    
}
