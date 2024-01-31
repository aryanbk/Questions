class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] str = new String[n];
        for(int i=0; i<n; ++i) str[i] = Integer.toString(nums[i]);
        
        Arrays.sort(str, (a, b) -> {
            String aa = a+b;
            String bb = b+a;
            return bb.compareTo(aa);
        });
        
        StringBuilder sb = new StringBuilder();
        for(String s: str) sb.append(s);
        
        // to remove prefix zeros
        for(int i=0; i<sb.length()-1 && sb.charAt(i)=='0';) sb.deleteCharAt(i);
        
        return sb.toString();
    }
}




// class Solution {
//     public String largestNumber(int[] nums) {
//         int n = nums.length;
//         String[] str = new String[n];
//         for(int i=0; i<n; ++i) str[i] = Integer.toString(nums[i]);
//         Arrays.sort(str, (a, b) -> {
//             int na = a.length();
//             int nb = b.length();
//             int i = 0;
//             int j = 0;
//             while(i<na && j<nb && a.charAt(i)==b.charAt(j)){
//                 ++i;
//                 ++j;
//             }
//             if(i==na && j==nb) return 0;
//             if(i==na) return b.charAt(j)=='0' ? -1 : 1;
//             else if(j==nb) return a.charAt(i)=='0' ? 1 : -1;
//             return b.charAt(j) - a.charAt(i);
//         });
//         StringBuilder sb = new StringBuilder();
//         for(String s: str) sb.append(s);
//         return sb.toString();
//     }
// }