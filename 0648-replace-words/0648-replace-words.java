class Solution {
    public String replaceWords(List<String> dct, String s) {
        String[] ss = s.split(" ");
        // System.out.println(Arrays.toString(ss));
        for(int i=0; i<ss.length; ++i){
            ss[i] = valid(ss[i], dct);
        }
        // return 
        return String.join(" ", ss);
    }
    
    String valid(String s, List<String> dct){
        // System.out.println(s);
        for(int i=0; i<dct.size(); ++i){
            String t = dct.get(i);
            int n = t.length();
            // System.out.println(s.length() >= n && s.substring(n).equals(t));
            if(s.length() >= n && s.substring(0, n).equals(t))
                s = t;
        }
        // System.out.println(s);
        return s;
    }
}