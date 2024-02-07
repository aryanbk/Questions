class Solution {
    public String frequencySort(String s) {
        int[][] freq = new int['z'+1][1];
        Arrays.setAll(freq, i -> new int[]{0, i});
        for(int i=0; i<s.length(); ++i){
            ++freq[s.charAt(i)][0];
        }
        
        Arrays.sort(freq, (a, b) -> b[0]-a[0]);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<freq.length && freq[i][0]!=0; ++i){
            String temp = String.valueOf((char)freq[i][1]).repeat(freq[i][0]);
            sb.append(temp);
        }
        
        return sb.toString();
    }
}