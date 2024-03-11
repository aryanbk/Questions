// O(n)

class Solution {
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        for(int i=0; i<s.length(); ++i) ++freq[s.charAt(i)-'a'];

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<order.length(); ++i){
            while(freq[order.charAt(i)-'a']-->0) sb.append(order.charAt(i));
        }
        
        for(int i=0; i<26; ++i)
            while(freq[i]-->0) sb.append((char)(i+'a'));

        return sb.toString();
    }
}





// class Solution {
//     public String customSortString(String order, String s) {
//         HashMap<Character, Integer> map = new HashMap<>();
//         for (int i = 0; i < order.length(); ++i) {
//             map.put(order.charAt(i), i);
//         }

//         List<Character> charList = new ArrayList<>();
//         for (char c : s.toCharArray()) {
//             charList.add(c);
//         }

//         Collections.sort(charList, (a, b) -> 
//                         map.getOrDefault(a, 26) - map.getOrDefault(b, 26));

//         StringBuilder sb = new StringBuilder();
//         for (char c : charList) {
//             sb.append(c);
//         }

//         return sb.toString();
//     }
// }



// class Solution {
//     public String customSortString(String order, String s) {
//         HashMap<Character, Integer> map = new HashMap<>();
//         for (int i = 0; i < order.length(); ++i) {
//             map.put(order.charAt(i), i);
//         }

//         Character[] ss = new Character[s.length()];

//         for (int i = 0; i < s.length(); ++i) {
//             ss[i] = s.charAt(i);
//         }

//         Collections.sort(charList, (a, b) -> map.getOrDefault(a, 26) - map.getOrDefault(b, 26));

//         StringBuilder result = new StringBuilder();
//         for (char c : ss) {
//             result.append(c);
//         }

//         return result.toString();
//     }
// }
