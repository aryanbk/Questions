class NumArray {
    private int n;
    private Segtree st;
    public NumArray(int[] nums) {
        this.n = nums.length;
        st = new Segtree(nums);
    }
    
    public void update(int index, int val) {
        st.update(0, n - 1, 0, val, index);
    }
    
    public int sumRange(int left, int right) {
        return st.sumRange(left, right);
    }
}

public class Segtree {
    private int[] seg;
    private int[] nums;

    public Segtree(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        int height = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int maxSize = 2 * (int) Math.pow(2, height) - 1;
        seg = new int[maxSize];
        build(0, n - 1, 0);
    }

    private void build(int start, int end, int index) {
        if (start == end) {
            seg[index] = nums[start];
            return;
        }
        int mid = start + (end - start) / 2;
        build(start, mid, 2 * index + 1);
        build(mid + 1, end, 2 * index + 2);
        seg[index] = seg[2 * index + 1] + seg[2 * index + 2];
    }

    public int query(int start, int end, int left, int right, int index) {
        if (left <= start && right >= end) {
            return seg[index];
        }
        if (end < left || start > right) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        return query(start, mid, left, right, 2 * index + 1) +
                query(mid + 1, end, left, right, 2 * index + 2);
    }

    public void update(int start, int end, int index, int val, int i) {
        if (i < start || i > end) {
            return;
        }
        // If the current node represents the update index
        if (start == end && start == i) {
            nums[i] = val;  // Update the value in the nums array
            seg[index] = val; // Update the value in the segment tree
            return;
        }
        seg[index] += val - nums[i]; // Update the segment tree node
        int mid = start + (end - start) / 2;
        update(start, mid, 2 * index + 1, val, i);
        update(mid + 1, end, 2 * index + 2, val, i);
    }

    public int sumRange(int left, int right) {
        return query(0, nums.length - 1, left, right, 0);
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */