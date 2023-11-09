class Solution {
    public int countHomogenous(String s) {
        int curr = -1, ans = 0, count = 0;
        for(int i=0; i<s.length(); ++i){
            count = s.charAt(i)==curr ? count + 1 : 1;
            ans = (ans + count) % 1000000007;
            curr = s.charAt(i);
        }
        return ans;
    }
}

// class Solution {
//     public int countHomogenous(String s) {
//         int count = 2, l = s.length();
//         long ans = 1;
//         for(int i=1; i<l; ++i){
//             if(s.charAt(i)==s.charAt(i-1)){
//                 ans+=count;
//                 count++;
//             }else{
//                 ans++;
//                 count=2;
//             }
//         }
//         return (int)(ans%1000000007);
//     }
// }