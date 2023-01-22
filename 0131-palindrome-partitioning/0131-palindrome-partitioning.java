class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        find(s, 0, 1, new ArrayList<>());
        return ans;
    }
    private void find(String s, int last, int ptr, List<String> curr){
        if(ptr==s.length()){
            if(isPali(s, last, ptr)){
                curr.add(s.substring(last, ptr));
                ans.add(new ArrayList<>(curr));
                curr.remove(curr.size()-1);
            } 
            return;
        }
        if(isPali(s, last, ptr)){
            curr.add(s.substring(last, ptr));
            find(s, ptr, ptr+1, curr);
            curr.remove(curr.size()-1);
        }
        find(s, last, ptr+1, curr);
        return;
    }
    private boolean isPali(String s, int l, int r){
        r-=1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l+=1;
            r-=1;
        }
        return true;
    }
}