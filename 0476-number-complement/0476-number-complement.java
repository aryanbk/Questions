class Solution {
    public int findComplement(int num) {
        int tempNum = num;
        int inv = 1;
        while(tempNum>0){
            inv <<= 1;
            tempNum >>= 1;
        }
        return num ^ (inv-1);
    }
}