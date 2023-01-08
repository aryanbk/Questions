class Solution {
    public int minimumLines(int[][] sp) {
        Arrays.sort(sp, (a,b)->Integer.compare(a[0], b[0]));
        if(sp.length==1) return 0;
        int ans=1;
        for(int i=2; i<sp.length; ++i){
            if((sp[i][1]-sp[i-1][1])*(sp[i-1][0]-sp[i-2][0])!=(sp[i-1][1]-sp[i-2][1])*(sp[i][0]-sp[i-1][0])) ans++;
        }
        return ans;
    }
}