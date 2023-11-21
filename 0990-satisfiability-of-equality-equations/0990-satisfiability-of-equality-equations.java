class Solution {
    public boolean equationsPossible(String[] equations) {
        DJS djs = new DJS(26);
        for(String s: equations){
            if(s.charAt(1)=='=')
                djs.union(s.charAt(0)-'a', s.charAt(3)-'a');
        }
        for(String s: equations){
            if(s.charAt(1) == '!')
                if(djs.find(s.charAt(0)-'a') == djs.find(s.charAt(3)-'a'))
                    return false;
        }
        return true;
    }
}

class DJS {
    private int[] parent;
    private int[] rank;

    public DJS(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i; // Each element is its own parent initially
            rank[i] = 0; // Initialize rank as 0
        }
    }

    // Find the root/representative of the set
    public int find(int x) {
        int i = x;
        while(x != parent[x])
            x = parent[x];
        parent[i] = x;
        return parent[x];
    }

    // Merge two sets by rank (Union by Rank)
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
        return false;
    }
}