class Solution {
    public boolean isHappy(int n) {
        int slow=n,fast=n;
        do{
            slow=numSq(slow);
            fast=numSq(numSq(fast));
        } while(slow!=fast);
        
        return slow == 1;
    }
    public int numSq(int n){
        int ans=0;
        while(n>0){
            ans+=((n%10)*(n%10));
            n/=10;
        }
        return ans;
    }
}