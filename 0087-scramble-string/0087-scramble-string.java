class Solution {
    private HashMap<List<String>, Boolean> map;
    public boolean isScramble(String s1, String s2) {
        map = new HashMap<>();
        return mcm(s1, s2);
    }
    
    private boolean mcm(String a, String b){
        List<String> list = List.of(a, b);
        
        if(map.containsKey(list)) return map.get(list);
        
        if(!isAnagram(a, b)){
            map.put(list, false);
            return false;
        }
        if(a.equals(b)){
            map.put(list, true);
            return true;
        }
        
        // (0, k) and (k+1, a.length())
        for(int k=0; k<a.length()-1; ++k){
            if(mcm(a.substring(0, k+1), b.substring(0, k+1)) && mcm(a.substring(k+1), b.substring(k+1))){
                map.put(list, true);
                return true;
            }
            
            if(mcm(a.substring(0, k+1), b.substring(a.length() -k - 1)) && mcm(a.substring(k+1), b.substring(0, a.length()-1-k))){
                map.put(list, true);
                return true;
            }
        }
        
        map.put(list, false);
        return false;
        
    }
    
    private boolean isAnagram(String s1, String s2){
        
        if(s1.length() != s2.length()) return false;
        
        int[] fm = new int[26];
        for(int i=0; i<s1.length(); ++i){
            fm[s1.charAt(i)-'a']++;
            fm[s2.charAt(i)-'a']--;
        }
        for(int i=0; i<26; ++i){
            if(fm[i] != 0) return false;
        }
        return true;
    }
}



// class Solution {
//     HashMap<List<String>, Boolean> map;
//     public boolean isScramble(String s1, String s2) {
//         map = new HashMap<>();
//         return mcm(s1, s2);
//     }
    
//     private boolean mcm(String a, String b){
//         List<String> list = new ArrayList<>();
//         list.add(a);
//         list.add(b);
        
//         if(map.containsKey(list)) return map.get(list);
        
//         if(!isAnagram(a, b)){
//             map.put(list, false);
//             return false;
//         }
//         if(a.equals(b)){
//             map.put(list, true);
//             return true;
//         }
        
//         // (0, k) and (k+1, a.length())
//         for(int k=0; k<a.length()-1; ++k){
//             if(mcm(a.substring(0, k+1), b.substring(0, k+1)) && mcm(a.substring(k+1), b.substring(k+1))){
//                 map.put(list, true);
//                 return true;
//             }
            
//             if(mcm(a.substring(0, k+1), b.substring(a.length() -k - 1)) && mcm(a.substring(k+1), b.substring(0, a.length()-1-k))){
//                 map.put(list, true);
//                 return true;
//             }
//         }
        
//         map.put(list, false);
//         return false;
        
//     }
    
//     private boolean isAnagram(String s1, String s2){
        
//         if(s1.length() != s2.length()) return false;
        
//         int[] fm = new int[26];
//         for(int i=0; i<s1.length(); ++i){
//             fm[s1.charAt(i)-'a']++;
//             fm[s2.charAt(i)-'a']--;
//         }
//         for(int i=0; i<26; ++i){
//             if(fm[i] != 0) return false;
//         }
//         return true;
//     }
// }


// first failed attempt
//
// class Solution {
//     public boolean isScramble(String s1, String s2) {
//         return mcm(0, s1.length()-1, 0, s1, s2);
//     }
    
//     private boolean mcm(int i, int j, int x, String s1, String s2){
//         if(i>j) return false;
//         // for(int p=0; p<j)
//         System.out.println(s1.substring(i, j+1)+" "+s2.substring(x, x+j-i+1));
//         if(i==j) return s1.charAt(i) == s2.charAt(x);
        
//         if(!isAnagram(s1.substring(i, j+1), s2.substring(x, x+j-i+1))) return false;
        
//         if(s1.substring(i, j+1).equals(s2.substring(x, x+j-i+1))) return true; 
//         // if(s1.substring(i, j+1).equals(s2.substring(x, x+j-i+1))) return true;

        
//         for(int k=i; k<j; ++k){
//             boolean left = mcm(i, k, x, s1, s2);
//             boolean right = mcm(k+1, j, k+1, s1, s2);
            
//             if(left && right) return true;
            
//             boolean left0 = mcm(i, k, j+x-k, s1, s2);
//             boolean right0 = mcm(k+1, j, x, s1, s2);
            
//             if (left0 && right0) return true;
//         }
        
//         return false;
//     }
//     private boolean isAnagram(String s1, String s2){
//         int[] fm = new int[26];
//         for(int i=0; i<s1.length(); ++i){
//             fm[s1.charAt(i)-'a']++;
//             fm[s2.charAt(i)-'a']--;
//         }
//         for(int i=0; i<26; ++i){
//             if(fm[i] != 0) return false;
//         }
//         return true;
//     }
// }