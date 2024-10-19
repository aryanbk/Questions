class Solution {
    public char findKthBit(int n, int k) {
        return (char)((k / (k & -k) >> 1 & 1) ^ (k & 1 ^ 1) + '0');
    }
}