class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        float[] time = new float[n];
        for(int i=0; i<n; ++i)
            time[i] = (float)dist[i]/(float)speed[i];
        
        Arrays.sort(time);
        int curr = 0;
        for(int i=0; i<n; ++i){
            if(curr++ >= time[i])
                return i;
        }
        return n;
    }
}