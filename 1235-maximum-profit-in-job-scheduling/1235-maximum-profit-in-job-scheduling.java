class Solution {
        
    class Job {
        int s;
        int e;
        int p;
        Job(int s, int e, int p) {
            this.s = s;
            this.e = e;
            this.p = p;
        }
    }
        
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; ++i) 
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        
        Arrays.sort(jobs, (a, b) -> a.s - b.s);
        int[] max = new int[n];
        return takeJob(jobs, max, 0, 0, n);
    }
    
    int takeJob(Job[] jobs, int[] max, int i, int t, int n) {
        while (i < n && t > jobs[i].s)
            ++i;
        
        if (i == n)
            return 0;
            
        if (max[i] != 0)
            return max[i];
        
        int take = jobs[i].p + takeJob(jobs, max, i+1, jobs[i].e, n);
        int skip = takeJob(jobs, max, i+1, t, n);
        
        max[i] = Math.max(take, skip);
        return max[i];
    } 
}