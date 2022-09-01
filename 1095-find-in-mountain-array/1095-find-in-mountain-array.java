/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        int lo=1,hi= arr.length()-2,peak=-1,arrpeak=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            int arrmid=arr.get(mid), arrp=arr.get(mid+1), arrm=arr.get(mid-1);
            if(arrmid>arrm && arrmid>arrp){
                peak=mid;
                arrpeak=arrmid;
                System.out.println(mid);
                break;
            }
            else if(arrmid<arrm) hi=mid-1;
            else if(arrmid<arrp) lo=mid+1;
        }
        int first=-1;
        if(target<=arrpeak){
            first=bs(target, 0, peak, arr);
        }
        if(first==-1) return rbs(target, peak, arr.length()-1, arr);
        return first;
    }
    int bs(int target, int lo, int hi, MountainArray arr){
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            int arrmid=arr.get(mid);
            if(target==arrmid) return mid;
            else if(target>arrmid) lo=mid+1;
            else if(target<arrmid) hi=mid-1;
        }
        return -1;
    }
    int rbs(int target, int lo, int hi, MountainArray arr){
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            int arrmid=arr.get(mid);
            if(target==arrmid) return mid;
            else if(target>arrmid) hi=mid-1;
            else if(target<arrmid) lo=mid+1;
        }
        return -1;
    }
}