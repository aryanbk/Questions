class Solution {
    public int firstUniqChar(String s) {
        boolean[] map=new boolean[26];
        for(int i=0; i<s.length(); i++){
            if(!map[s.charAt(i)-'a']){
                int j=i+1;
                while(j<s.length()){
                    if(s.charAt(i)==s.charAt(j)){
                        map[s.charAt(i)-'a']=true;
                        break;
                    }
                    j++;
                }
                if(j==s.length()) return i;
            }
        }
        return -1;
    }
}