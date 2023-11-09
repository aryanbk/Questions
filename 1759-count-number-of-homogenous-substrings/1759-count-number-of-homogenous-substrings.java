class Solution {
    public int countHomogenous(String s) {
        int count = 2, l = s.length();
        long ans = 1;
        for(int i=1; i<l; ++i){
            if(s.charAt(i)==s.charAt(i-1)){
                ans+=count;
                count++;
            }else{
                ans++;
                count=2;
            }
        }
        return (int)(ans%1000000007);
    }
}