class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        
        for(int n: nums1) set.add(n);
        for(int n: nums2)
            if(set.contains(n))
                intersect.add(n);
        
        int[] ans = new int[intersect.size()];
        int ptr = 0;
        
        for(int n: intersect) ans[ptr++] = n;
        
        return ans;
    }
}