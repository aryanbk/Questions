class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long sumt = 0;
        for(int i=0; i<n; ++i) sumt += chalk[i];
        k %= sumt;
        
        for(int i=0; true; ++i){
            k -= chalk[i%n];
            if(k<0) return i;
        }
    }
}