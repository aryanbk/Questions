class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length()<p.length()) return new ArrayList<>();
        
        int[] mp=new int[26];
        for(int i=0; i<p.length(); i++){
            mp[p.charAt(i)-97]++;
        }
        
        int j=0;
        int[] ms = new int[26];
        while(j<p.length()) ms[s.charAt(j++)-97]++;
        
        j--;
        int i=0;
        List<Integer> ans=new ArrayList<>();
        while(j<s.length()){
            if(Arrays.equals(mp, ms)) ans.add(i);
            j++;
            if(j<s.length()) ms[s.charAt(j)-97]++;
            ms[s.charAt(i)-97]--;
            i++;
        }
        
        return ans;
    }
}