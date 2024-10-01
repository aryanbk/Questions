class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] mod = new int[k];
        for(int a: arr) ++mod[((a%k)+k)%k];
        for(int i=1, j=k-1; i<=j; ++i, --j){
            if(i==j ? mod[i]%2!=0 : mod[i] != mod[j]) return false;
        }
        return true;
    }
}