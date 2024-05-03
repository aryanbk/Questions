class Solution {
    public int compareVersion(String version1, String version2) {
        // in regex "." all the characters, so we'll use "\\." 
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n = Math.max(v1.length, v2.length);
        
        int[] one = new int[n];
        int[] two = new int[n];
        
        for(int i=0; i<v1.length; ++i)
            one[i] = Integer.valueOf(v1[i]);
        for(int i=0; i<v2.length; ++i)
            two[i] = Integer.valueOf(v2[i]);
        
        for(int i=0; i<n; ++i){
            if(one[i] > two[i]) return 1;
            else if(one[i] < two[i]) return -1;
        }
        
        return 0;
    }
}