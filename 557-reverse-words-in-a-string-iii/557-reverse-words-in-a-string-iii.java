class Solution {
    public String reverseWords(String s) {
        int fnt=0,bk=0,l=s.length();
        char[] ans=s.toCharArray();
        s="";
        while(fnt!=l){
            if(ans[fnt]==32){
                int temp=fnt-1;
                while(temp>=bk){
                    s+=ans[temp];
                    temp--;
                }
                s+=" ";
                bk=fnt+1;
            }else if(fnt==l-1){
                int temp=fnt;
                while(temp>=bk){
                    s+=ans[temp];
                    temp--;
                }
            }
            fnt++;
        }
        return s;
    }
}