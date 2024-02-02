class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int[] all = {12,23,34,45,56,67,78,89,
                         123,234,345,456,567,678,789,
                         1234,2345,3456,4567,5678,6789,
                         12345,23456,34567,45678,56789,
                         123456,234567,345678,456789,
                         1234567,2345678,3456789,
                         12345678,23456789,
                         123456789};
        List<Integer> ans = new ArrayList<>();
        int n = all.length;
        for(int i=0; i<n; ++i){
            if(all[i] < low) continue;
            if(all[i] > high) break;
            ans.add(all[i]);
        }
        return ans;
    }
}

// class Solution {
//     List<Integer> ans;
//     String lo;
//     String hi;
//     public List<Integer> sequentialDigits(int low, int high) {
//         ans = new ArrayList<>();
//         lo = Integer.toString(low);
//         hi = Integer.toString(high);
//         solve(0, new StringBuilder(), false, false);
//         return ans;
//     }
//     void solve(int i, StringBuilder cur, boolean flag1, boolean flag2){
//         System.out.println(cur);
//         if(cur.length() > hi.length()){
//             // ans.add(Integer.parseInt(cur.toString()));
//             return;
//         }
//         if(cur.length() >= lo.length())
//             ans.add(Integer.parseInt(cur.toString()));
        
//         char start = flag1 || i>=lo.length()? '0' : lo.charAt(i);
//         char end = flag2 ? '9' : hi.charAt(i);
//         while(start <= end){
//             cur.append(start);
//             boolean newFlag1 = flag1 || i>=lo.length() || start >lo.charAt(i);
//             boolean newFlag2 = flag2 || start < hi.charAt(i);
//             solve(i+1, cur, newFlag1, newFlag2);
//             cur.deleteCharAt(cur.length() - 1);
//         }
//         return;
//     }
// }