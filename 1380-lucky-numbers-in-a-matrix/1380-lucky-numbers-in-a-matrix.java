class Solution {
    public List<Integer> luckyNumbers (int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] mx = new int[n];
        int[] mn = new int[m];
        Arrays.fill(mn, Integer.MAX_VALUE);
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                mx[j] = Math.max(mx[j], mat[i][j]);
                mn[i] = Math.min(mn[i], mat[i][j]);
            }
        }
        var ans = new ArrayList<Integer>();
        var s1 = new HashSet<Integer>();
        var s2 = new HashSet<Integer>();
        for(int x: mx) s1.add(x);
        for(int x: mn) s2.add(x);
        s1.retainAll(s2);
        for(int x: s1) ans.add(x);
        return ans;
    }
}