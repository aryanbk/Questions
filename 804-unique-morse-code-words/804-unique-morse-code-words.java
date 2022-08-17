class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] ref= {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        for(String str: words){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<str.length(); ++i){
                sb=sb.append(ref[str.charAt(i)-'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}