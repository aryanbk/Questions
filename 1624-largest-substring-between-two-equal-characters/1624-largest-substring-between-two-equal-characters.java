class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int ans = -1;
        var map = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); ++i){
            if(map.containsKey(s.charAt(i))){
                ans = Math.max(ans, i-1-map.get(s.charAt(i)));
            }
            else{
                map.put(s.charAt(i), i);
            }
        }
        return ans;
    }
    
}