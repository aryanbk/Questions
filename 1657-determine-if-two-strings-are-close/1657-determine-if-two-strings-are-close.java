class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        
        for(int i=0; i<word1.length(); ++i){
            char ch1 = word1.charAt(i);
            map1.put(ch1, map1.getOrDefault(ch1, 0)+1);
            char ch2 = word2.charAt(i);
            map2.put(ch2, map2.getOrDefault(ch2, 0)+1);
        }
        var list1 = new ArrayList<>(map1.values());
        var list2 = new ArrayList<>(map2.values());
        
        Collections.sort(list1);
        Collections.sort(list2);
        
        return  list1.equals(list2) && map1.keySet().equals(map2.keySet());
        
    }
}