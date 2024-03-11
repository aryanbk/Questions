class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); ++i) {
            map.put(order.charAt(i), i);
        }

        Character[] ss = new Character[s.length()];

        for (int i = 0; i < s.length(); ++i) {
            ss[i] = s.charAt(i);
        }

        Arrays.sort(ss, (a, b) -> {
            int aa = map.containsKey(a) ? map.get(a) : 27;
            int bb = map.containsKey(b) ? map.get(b) : 27;
            return aa - bb;
        });

        StringBuilder result = new StringBuilder();
        for (char c : ss) {
            result.append(c);
        }

        return result.toString();
    }
}
