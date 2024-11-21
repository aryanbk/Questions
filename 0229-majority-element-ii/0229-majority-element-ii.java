class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = 0;
        int num2 = 1;
        int count1 = 0;
        int count2 = 0;
        
        for(int n: nums){
            if(n==num1) 
                ++count1;
            else if(n==num2) 
                ++count2;
            else if(count1==0){
                num1 = n;
                ++count1;
            }
            else if(count2==0){
                num2 = n;
                ++count2;
            }
            else{
                --count1;
                --count2;
            }
        }
        
        count1 = 0;
        count2 = 0;
        for(int n: nums){
            count1 += n==num1 ? 1 : 0;
            count2 += n==num2 ? 1 : 0;
        }
        
        List<Integer> ans = new ArrayList<>();
        if(nums.length/3 < count1) ans.add(num1);
        if(nums.length/3 < count2) ans.add(num2);
        
        return ans;
    }
}