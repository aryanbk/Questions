class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for(int n: nums){
            if(set.contains(n)) ans.add(n);
            else set.add(n);
        }
        return ans;
    }
}