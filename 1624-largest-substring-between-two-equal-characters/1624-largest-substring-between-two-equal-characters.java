class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int ans = -1;
        var map = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); ++i){
            char ch = s.charAt(i);
            if(map.containsKey(ch))
                ans = Math.max(ans, i-1-map.get(ch));
            else
                map.put(ch, i);
        }
        return ans;
    }
    
}