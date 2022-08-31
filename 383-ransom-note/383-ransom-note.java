class Solution {
    public boolean canConstruct(String ran, String mag) {
        boolean[] map=new boolean[mag.length()];
        for(int i=0; i<ran.length(); i++){
            char ch=ran.charAt(i);
            int j;
            for(j=0; j<mag.length(); j++){
                if(ch==mag.charAt(j) && !map[j]){
                    map[j]=true;
                    break;
                }
            }
            if(j>=mag.length()) return false;
        }
        return true;
    }
}