class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr2.length; ++i)
            map.put(arr2[i], i);
        Integer[] arr = new Integer[arr1.length];
        for(int i=0; i<arr1.length; ++i)
            arr[i] = arr1[i];
        Arrays.sort(arr, (a, b) ->
                   map.getOrDefault(a, 1000+a) - map.getOrDefault(b, 1000+b));
        for(int i=0; i<arr1.length; ++i)
            arr1[i] = arr[i];
        return arr1;
    }
}