class Solution {
    public int stoneGameVI(int[] aVal, int[] bVal) {
        int n = aVal.length;
        int[][] sumVal = new int[n][2];
        for(int i=0; i<n; ++i)
            sumVal[i] = new int[]{aVal[i] + bVal[i], i};
        
        Arrays.sort(sumVal, (a, b) ->{
            return a[0] - b[0];
        });
        
        int ans = 0;
        boolean alice = true;
        for(int i=n-1; i>=0; --i, alice = !alice){
            if(alice)
                ans += aVal[sumVal[i][1]];
            else
                ans -= bVal[sumVal[i][1]];
        }
        
        return ans>0 ? 1 : ans<0 ? -1 : 0;
    }
}