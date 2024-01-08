class Solution {
    Integer[][][] memo;
    public int rotatedDigits(int n) {
        memo = new Integer[n][2][2];
        return rec(Integer.toString(n), 0, false, false);
    }
    int rec(String n, int i, boolean smaller, boolean mirror){
        if(i==n.length())
            return mirror ? 1 : 0;
        
        int s = smaller ? 1 : 0;
        int m = mirror ? 1 : 0;
        
        if(memo[i][s][m] != null) return memo[i][s][m];
        
        memo[i][s][m] = 0;
        int cur = n.charAt(i)-'0';
        int lim = smaller ? 9 : cur;
        
        for(int x=0; x <= lim; ++x){
            if(x==2 || x==5 || x==6 || x==9 || x==0 || x==1 || x==8)
                memo[i][s][m] += rec(n, i+1, smaller ? smaller : x<cur, mirror || (x==2 || x==5 || x==6 || x==9));
        }
        
        return memo[i][s][m];
    }
}

