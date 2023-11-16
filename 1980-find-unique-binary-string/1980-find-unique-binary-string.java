class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder s = new StringBuilder();
        for(int i=0; i<nums.length; ++i)
            s.append(nums[i].charAt(i) == '0' ? '1' : '0');
        return s.toString();
    }
}

// class Solution {
//     public String findDifferentBinaryString(String[] nums) {
//         int n = nums.length;
//         Set<Integer> s = new HashSet<>();
        
//         for(String str: nums)
//             s.add(Integer.parseInt(str, 2));
        
//         int i = 0;
//         while(s.contains(i))
//             i++;
        
//         String ans = Integer.toBinaryString(i);
//         String pre = "";
        
//         for(i=0; i<n-ans.length(); ++i)
//             pre += "0";
        
//         return pre+ans;
//     }
// }