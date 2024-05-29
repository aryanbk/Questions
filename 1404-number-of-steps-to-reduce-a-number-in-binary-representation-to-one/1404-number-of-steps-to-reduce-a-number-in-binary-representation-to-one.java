class Solution {
    public int numSteps(String s) {
        int carry = 0;
        int ans = 0;
        
        for(int i=s.length()-1; i>0; --i){
            int num = s.charAt(i)-'0' + carry;
            ans += num%2==0 ? 1 : 2;
            carry = num==0 ? 0 : 1;
        }
        
        return ans + carry;
    }
}






// class Solution {
//     public int numSteps(String s) {
//         int n = Integer.parseInt(s, 2);
//         int ans = 0;
//         while(n != 1){
//             // ans += n%2==0 ? 1 : 2;
//             n = n%2==0 ? n/2 : (n+1);
//             ++ans;
//         }
//         return ans;
//     }
// }