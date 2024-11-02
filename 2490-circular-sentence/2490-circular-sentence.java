class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] sen = sentence.split(" ");
        int n = sen.length;
        for(int i=0; i<n; ++i)
            if(sen[i].charAt(sen[i].length()-1) != sen[(i+1)%n].charAt(0)) return false;
        return true;
    }
}




// // readable
//
// class Solution {
//     public boolean isCircularSentence(String sentence) {
//         String[] sen = sentence.split(" ");
//         int n = sen.length;
//         for(int i=0; i<n; ++i){
//             String cur = sen[i];
//             String nx = sen[(i+1)%n];
//             if(cur.charAt(cur.length()-1) != nx.charAt(0)) return false;
//         }
//         return true;
//     }
// }