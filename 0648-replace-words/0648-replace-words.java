class Solution {
    Node head;
    public String replaceWords(List<String> dct, String s) {
        head = new Node();
        for(String word: dct){
            insert(word);
        }
        
        String[] ss = s.split(" ");
        for(int i=0; i<ss.length; ++i){
            String word = ss[i];
            ss[i] = search(word);
        }
        
        return String.join(" ", ss);
        
        
    }
    void insert(String word){
        Node cur = head;
        for(int i=0; i<word.length(); ++i){
            int idx = word.charAt(i)-'a';
            if(cur.map[idx]==null)
                cur.map[idx] = new Node();
            cur = cur.map[idx];
        }
        cur.word = word;
    }
    
    String search(String word){
        Node cur = head;
        int i=0;
        while(cur.word == null && i<word.length()){
            int idx = word.charAt(i)-'a';
            if(cur.map[idx] == null)
                return word;
            cur = cur.map[idx];
            ++i;
        }
        return cur.word==null ? word : cur.word;
    }
    
}

class Node{
    Node[] map;
    String word;
    public Node(){
        map = new Node[26];
        word = null;
    }
}







// class Solution {
//     public String replaceWords(List<String> dct, String s) {
//         String[] ss = s.split(" ");
//         // System.out.println(Arrays.toString(ss));
//         for(int i=0; i<ss.length; ++i){
//             ss[i] = valid(ss[i], dct);
//         }
//         // return 
//         return String.join(" ", ss);
//     }
    
//     String valid(String s, List<String> dct){
//         // System.out.println(s);
//         for(int i=0; i<dct.size(); ++i){
//             String t = dct.get(i);
//             int n = t.length();
//             // System.out.println(s.length() >= n && s.substring(n).equals(t));
//             if(s.length() >= n && s.substring(0, n).equals(t))
//                 s = t;
//         }
//         // System.out.println(s);
//         return s;
//     }
// }