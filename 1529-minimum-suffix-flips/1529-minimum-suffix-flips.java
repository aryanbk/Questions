class Solution {
    public int minFlips(String target) {
        int all = 0;
        int flip = 0;
        for(int i=0; i<target.length(); ++i){
            if(target.charAt(i)-'0' != all){
                all = all^1;
                ++flip;
            }
        }
        return flip;
    }
}