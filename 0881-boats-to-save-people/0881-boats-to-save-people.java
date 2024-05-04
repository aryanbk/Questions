class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int i=0;
        int j = people.length-1;
        
        while(i<=j){
            if(people[i] + people[j] <= limit){
                ++i; --j;
            }
            else
                --j;
            ++ans;
        }
        
        return ans;
    }
}







// // wrong approch
//
// class Solution {
//     public int numRescueBoats(int[] people, int limit) {
//         Arrays.sort(people);
//         int ans = 0;
//         int cur = 0;
//         for(int i=0; i<people.length; ++i){
//             if(cur + people[i] > limit){
//                 ans++;
//                 cur = people[i];
//             }
//             else
//                 cur += people[i];
//         }
        
//         return ans + 1;
//     }
// }