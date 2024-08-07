class Solution {
    String[] lessThanTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};
    String[] Tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] Thousands = {"", "Thousand", "Million", "Billion", "Trillion", "Quadrillion"};
    
    List<String> ans;
    
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        
        int i = 0;
        ans = new ArrayList<>();
        
        while(num>0){
            int lastThree = num - ((num/1000)*1000);
            if(lastThree!=0) ans.add(Thousands[i]);
            getLastTwoDigit(lastThree);
            if(lastThree/100 > 0){
                ans.add("Hundred");
                getOneDigit(lastThree/100);
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
    
    void getLastTwoDigit(int num){
        num = num - ((num/100)*100);
        if(num<=20){
            ans.add(lessThanTwenty[num]);
            return;
        }
        getOneDigit(num%10);
        ans.add(Tens[num/10]);
        
    }
    
    void getOneDigit(int num){
        num = num - ((num/10)*10);
        ans.add(lessThanTwenty[num]);
    }
}