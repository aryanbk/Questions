class Solution {
    public String sortVowels(String s) {
        char[] c = s.toCharArray();
        List<Character> vow = new ArrayList<>();
        for (char ch : c) {
            // Check if the character is a vowel (case-insensitive)
            if (isVowel(ch))
                vow.add(ch);
        }

        Collections.sort(vow);

        // Iterate through the character array
        int ptr = 0;
        for (int i = 0; i < c.length; ++i) {
            // If the current character is a vowel, replace it with the next sorted vowel
            if (isVowel(c[i])) {
                c[i] = vow.get(ptr++);
            }
        }

        // Convert the modified character array back to a string and return
        return String.valueOf(c);
    }

    public boolean isVowel(char ch) {
        char lowerChar = Character.toLowerCase(ch);
        return lowerChar == 'a' || lowerChar == 'e' || lowerChar == 'i' || lowerChar == 'o' || lowerChar == 'u';
    }
}
