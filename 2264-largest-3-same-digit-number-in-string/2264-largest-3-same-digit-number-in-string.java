class Solution {
    public String largestGoodInteger(String num) {
        String ans = "";
        for(int i=0; i<num.length()-2; ++i){
            String sub = num.substring(i, i+3);
            if(isGood(sub) && ans.compareTo(sub)<0)
                ans = sub;
        }
        return ans;
    }
    private boolean isGood(String sub){
        return (sub.charAt(0) == sub.charAt(1) && sub.charAt(0) == sub.charAt(2));
    }
}