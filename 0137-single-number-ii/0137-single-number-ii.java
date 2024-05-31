class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        int[] bits = new int[32];
        for(int x=0; x<nums.length; ++x){
            String s = Integer.toBinaryString(nums[x]);
            System.out.println(s);
            for(int i=s.length()-1; i>=0; --i)
                bits[s.length()-1-i] += s.charAt(i)-'0';
        }
        System.out.println(Arrays.toString(bits)+" "+Integer.toBinaryString(2));
        for(int i=0; i<32; ++i){
            if(bits[i]%3==1)
                ans |= (1<<i);
        }
        return ans;
    }
}