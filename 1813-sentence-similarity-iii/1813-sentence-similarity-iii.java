class Solution {
    public boolean areSentencesSimilar(String sen1, String sen2) {
        var s1 = sen1.split(" ");
        var s2 = sen2.split(" ");
        var n1 = s1.length;
        var n2 = s2.length;
        
        if(n1 < n2) return areSentencesSimilar(sen2, sen1);
        
        int i = 0;
        int j = 0;
        while(i<n1 && j<n2 && s1[i].equals(s2[j])){
            ++i; ++j;
        }
        
        int a = n1-1;
        int b = n2-1;
        while(a>=i && b>=j && s1[a].equals(s2[b])){
            --a; --b;
        }
        
        return b==j-1;
    }
    
}