class Solution {
    List<String> ans;
    String[] phone;
    
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if(digits.length() == 0) return ans;
        phone = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        help(0, digits, new StringBuilder());
        
        return ans;
    }
    
    void help(int i, String digits, StringBuilder sb){
        if(i==digits.length()){
            ans.add(sb.toString());
            return;
        }
        
        int num = digits.charAt(i)-'2';
        String keys = phone[num];
        
        for(int x = 0; x < keys.length(); ++x){
            sb.append(keys.charAt(x));
            help(i+1, digits, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        return;
    }
    
}