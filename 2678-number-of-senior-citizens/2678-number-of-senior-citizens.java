class Solution {
    public int countSeniors(String[] details) {
        int ans = 0;
        for(var d: details)
            ans += Integer.parseInt(d.substring(11, 13)) > 60 ? 1 : 0;
        return ans;
    }
}