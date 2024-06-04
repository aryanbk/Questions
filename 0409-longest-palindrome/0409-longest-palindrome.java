class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); ++i)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        
        int ans = 0;
        boolean isOdd = false;
        
        for(char i: map.keySet()){
            int val = map.get(i);
            if(val %2 ==0) ans += val;
            else {
                isOdd = true;
                ans += val - 1;
            }
        }
        
        return ans + (isOdd ? 1 : 0);
    }
}