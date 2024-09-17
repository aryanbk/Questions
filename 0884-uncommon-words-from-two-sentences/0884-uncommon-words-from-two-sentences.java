class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        var freq = new HashMap<String, Integer>();
        var a1 = s1.split(" ");
        var a2 = s2.split(" ");
        
        for(int i=0; i<a1.length; ++i) freq.put(a1[i], freq.getOrDefault(a1[i], 0)+1);
        for(int i=0; i<a2.length; ++i) freq.put(a2[i], freq.getOrDefault(a2[i], 0)+1);
        
        var ansList = new ArrayList<String>();
        for(Map.Entry<String, Integer> e: freq.entrySet()){
            if(e.getValue()==1) ansList.add(e.getKey());
        }
        
        var ans = new String[ansList.size()];
        for(int i=0; i<ans.length; ++i) ans[i] = ansList.get(i);
        
        return ans;
    }
}