class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        boolean[] map = new boolean[n+1];
        int repeat = 0;
        for(int i: nums){
            if(set.contains(i)){
                repeat = i;
            }
            set.add(i);
            map[i]=true;
        }
        for(int i=1; i<n+1; ++i){
            if(!map[i]) return new int[]{repeat, i};
        }
        
        return new int[]{0, 0};
    }
}