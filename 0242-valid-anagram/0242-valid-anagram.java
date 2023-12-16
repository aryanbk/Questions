// follow up
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        var map = new HashMap<Character, Integer>();
        for(int i=0; i<s.length(); ++i){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)-1);
        }
        for(Character key: map.keySet()){
            if(map.get(key)!=0)
                return false;
        }
        return true;
    }
}


// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if(s.length() != t.length()) return false;
//         int[] map=new int[26];
//         for(int i=0; i<s.length(); i++){
//             map[s.charAt(i)-'a']++;
//             map[t.charAt(i) -'a' ]--;
//         }
//         for(int j=0; j<26; j++){
//             if(map[j] != 0) return false;
//         }
//         return true;
//     }
// }