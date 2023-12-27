class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {        
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        
        for (String s : strs) {
            char[] arr = new char[26];
            for (char ch : s.toCharArray())
                arr[ch - 'a']++;
            
            String key = String.valueOf(arr);
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<>());
                ans.add(map.get(key));
            }
            map.get(key).add(s);
        }
        return ans;
    }
}




// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         if (strs == null || strs.length == 0) return new ArrayList<>();
//         Map<String, List<String>> map = new HashMap<>();
//         for (String s : strs) {
//             char[] arr = new char[26];
//             for (char ch : s.toCharArray()) arr[ch - 'a']++;
//             String finalStr = String.valueOf(arr);
//             if (!map.containsKey(finalStr)) map.put(finalStr, new ArrayList<>());
//             map.get(finalStr).add(s);
//         }
//         return new ArrayList<>(map.values());
//     }
// }