class Solution {
    public String longestDiverseString(int a, int b, int c) {
        HashMap<Character,Integer> frequency=new HashMap<>();
        if(a>0) frequency.put('a',a);
        if(b>0) frequency.put('b',b);
        if(c>0) frequency.put('c',c);
        PriorityQueue<Character> maxHeap=new PriorityQueue<>((p,q)->frequency.get(q)-frequency.get(p));
        maxHeap.addAll(frequency.keySet());
        String result="";
        while(!maxHeap.isEmpty()){
            char c1=maxHeap.poll();
            if(result.length()>=2 && result.charAt(result.length()-1)==c1 && result.charAt(result.length()-2)==c1){
                if(maxHeap.isEmpty())break;
                char c2=maxHeap.poll();
                result+=c2;
                frequency.put(c2,frequency.get(c2)-1);
                if(frequency.get(c2)>0) maxHeap.add(c2);
                maxHeap.add(c1);
            }
            else{
                result+=c1;
                frequency.put(c1,frequency.get(c1)-1);
                if(frequency.get(c1)>0) maxHeap.add(c1);
            }
        }
        return result;
    }
}



// class Solution {
//     public String longestDiverseString(int a, int b, int c) {
//         // int mx = Math.max(a, Math.max(b, c));
//         // int mn = Math.min(a, Math.min(b, c));
//         // int mid = a+b+c -mn-mn;
//         int[][] nums = new int[][]{{a, 'a'}, {b, 'b'}, {c, 'c'}};
//         // return solve(new int[]{mn, mid, mn});
//         Arrays.sort(nums, (x,y) -> y[0]-x[0]);
//         return solve(nums);
//     }
    
//     String solve(int[][] nums){
//         for(var x: nums) System.out.println(Arrays.toString(x));
//         var sb = new StringBuilder();
//         for(int i=0; i<3; ++i){
//             if(nums[i][0] > 0){
//                 if(sb.length()!=0 && sb.charAt(sb.length()-1) == nums[i][1]) break;
//                 sb.append((char)nums[i][1]);
//                 nums[i][0]--;
//                 if(nums[i][0] > 0) sb.append((char)nums[i][1]);
//                 nums[i][0]--;
//             }
//         }
//         return sb.toString();
//     }
// }