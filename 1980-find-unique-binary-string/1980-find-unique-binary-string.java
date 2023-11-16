class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<Integer> s = new HashSet<>();
        for(String str: nums){
            s.add(Integer.parseInt(str, 2));
        }
        // for(Integer i: s)
            // System.out.println(i);
        int i = 0;
        while(s.contains(i))
            i++;
        String ans = Integer.toBinaryString(i);
        String pre = "";
        for(i=0; i<n-ans.length(); ++i){
            pre += "0";
        }
        return pre+ans;
    }
}