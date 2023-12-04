class Solution {
    public String largestGoodInteger(String num) {
        int ans = -1; // Initialize ans as an integer
        for (int i = 0; i < num.length() - 2; ++i) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                ans = Math.max(ans, num.charAt(i) - '0');
            }
        }
        return ans==-1 ? "" : String.valueOf(ans) + String.valueOf(ans) + String.valueOf(ans); 
    }
}



// class Solution {
//     public String largestGoodInteger(String num) {
//         String ans = "";
//         for(int i=0; i<num.length()-2; ++i){
//             String sub = num.substring(i, i+3);
//             if(isGood(sub) && ans.compareTo(sub)<0)
//                 ans = sub;
//         }
//         return ans;
//     }
//     private boolean isGood(String sub){
//         return (sub.charAt(0) == sub.charAt(1) && sub.charAt(0) == sub.charAt(2));
//     }
// }