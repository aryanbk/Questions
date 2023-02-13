class Solution {
    public int numOfSubarrays(int[] arr) {
        int even=1, odd=0;
        long sumt=0, ans=0;
        for(int a: arr){
            sumt+=(long)a;
            if(sumt%2==0){
                ans += (long)odd;
                even++;
            }else{
                ans += (long)even;
                odd++;
            }
        }
        return (int)(ans%(1000000007));
    }
}