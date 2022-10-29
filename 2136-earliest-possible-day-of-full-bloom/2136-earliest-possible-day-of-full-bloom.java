class Solution {
    public class Pair implements Comparable<Pair>{
        int pt;   //plantTime
        int gt;   //growTime
        Pair(int pt, int gt){
            this.pt=pt;
            this.gt=gt;
        }
        public int compareTo(Pair o){
            if(this.gt==o.gt){
                return o.pt-this.pt;
            }
            return o.gt-this.gt;
        }
    }
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int pt=0;      //pt=plantTime;
        Pair[] arr=new Pair[plantTime.length];
        for(int i=0;i<arr.length;i++){
            arr[i]=new Pair(plantTime[i],growTime[i]);
        }
        Arrays.sort(arr);
        int maximumTime=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            pt+=arr[i].pt;
            maximumTime=Math.max(maximumTime,pt+arr[i].gt);
        }
        return maximumTime;   
    }
}