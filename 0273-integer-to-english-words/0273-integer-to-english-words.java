class Solution {
    String[] map = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};
    
    String[] map2 = {"", "Thousand", "Million", "Billion", "Trillion", "Quadrillion"};
    
    String[] map3 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    List<String> ans;
    
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        int i = 0;
        ans = new ArrayList<>();
        while(num>0){
            int lastThree = num - ((num/1000)*1000);
            if(lastThree!=0) ans.add(map2[i]);
            getLastTwo(lastThree);
            if(lastThree/100 > 0){
                ans.add("Hundred");
                getOne(lastThree/100);
            }
            num /= 1000;
            ++i;
        }
        StringBuilder ansBuilder = new StringBuilder();
        for(int x=ans.size()-1; x>=0; --x){
            ansBuilder.append(ans.get(x));
            if(ans.get(x).length()!=0)
                ansBuilder.append(" ");
        }
        
        return ansBuilder.toString().trim();
        
    }
    
    void getLastTwo(int num){
        num = num - ((num/100)*100);
        if(num<=20){
            ans.add(map[num]);
            return;
        }
        getOne(num%10);
        ans.add(map3[num/10]);
        
    }
    
    void getOne(int num){
        num = num - ((num/10)*10);
        ans.add(map[num]);
    }
}