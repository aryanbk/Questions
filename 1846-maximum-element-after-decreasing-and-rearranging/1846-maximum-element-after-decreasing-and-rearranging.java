class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int val = 1;
        for(int i=0; i<arr.length; ++i){
            if(arr[i]>val){
                arr[i] = val;
            }else if(arr[i] < val){
                val = arr[i];
            }
            val++;
        }
        return arr[arr.length-1];
    }
}