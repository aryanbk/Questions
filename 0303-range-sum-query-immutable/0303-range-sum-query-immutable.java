// Prefix Sum
// 
class NumArray {    
    int[] pre;
    public NumArray(int[] nums) {
        pre = nums;
        for(int i=1; i<nums.length; ++i)
            pre[i] += pre[i-1];
    }
    
    public int sumRange(int left, int right) {
        return left>0 ? pre[right]-pre[left-1] : pre[right];
    }
}

// Segment Tree
// 
// class NumArray {
//     Segtree st;
//     public NumArray(int[] nums) {
//         st = new Segtree(nums);
//     }
    
//     public int sumRange(int left, int right) {
//         return st.query(left, right);
//     }
// }

// public class Segtree {
//     private int[] seg;
//     private int[] nums;

//     public Segtree(int[] nums) {
//         this.nums = nums;
//         int n = nums.length;
//         int height = (int)(Math.ceil(Math.log(n) / Math.log(2)));
//         int maxSize = 2 * (int) Math.pow(2, height) - 1;
//         seg = new int[maxSize];
//         build(0, n - 1, 0);
//     }

//     private void build(int start, int end, int index) {
//         if (start == end) {
//             seg[index] = nums[start];
//             return;
//         }
//         int mid = start + (end - start) / 2;
//         build(start, mid, 2 * index + 1);
//         build(mid + 1, end, 2 * index + 2);
//         seg[index] = seg[2 * index + 1] + seg[2 * index + 2];
//     }

//     public int query(int left, int right) {
//         return queryRange(0, nums.length - 1, left, right, 0);
//     }

//     private int queryRange(int start, int end, int left, int right, int index) {
//         if (left <= start && right >= end) {
//             return seg[index];
//         }
//         if (end < left || start > right) {
//             return 0;
//         }
//         int mid = start + (end - start) / 2;
//         return queryRange(start, mid, left, right, 2 * index + 1) +
//             queryRange(mid + 1, end, left, right, 2 * index + 2);
//     }

//     public void update(int index, int val) {
//         updateValue(0, nums.length - 1, 0, val, index);
//     }

//     private void updateValue(int start, int end, int index, int val, int i) {
//         if (i < start || i > end) {
//             return;
//         }
//         if (start == end && start == i) {
//             nums[i] = val;
//             seg[index] = val;
//             return;
//         }
//         seg[index] += val - nums[i];
//         int mid = start + (end - start) / 2;
//         updateValue(start, mid, 2 * index + 1, val, i);
//         updateValue(mid + 1, end, 2 * index + 2, val, i);
//     }
// }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */