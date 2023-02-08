class Solution {
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        Set<Integer> vis = new HashSet<>();
        vis.add(0);
        int n=nums.length, step=1;
        while(true){
            int n2 = q.size();
            for(int i=0; i<n2; ++i){
                int curr = q.poll();
                for(int j=curr+1; j<Math.min(n, curr+1+nums[curr]); ++j){
                    if(j>=n-1) return step;
                    if(!vis.contains(j)){
                        q.add(j);
                        vis.add(j);
                    }
                }
            }
            step++;
        }
    }
}