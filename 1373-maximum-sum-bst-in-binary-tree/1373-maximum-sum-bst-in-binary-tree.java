/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */



class Solution {
    int ans = 0;
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    int[] dfs(TreeNode root){
        if(root == null)
            return new int[]{0, 1, 1000_000_000, -1000_000_000};
        
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        
        boolean isBST = left[1]==1 && right[1]==1 && 
            (left[3] < root.val) && (right[2] > root.val);
        
        if(!isBST)
            return new int[]{Math.max(left[0], right[0]), 0, 0, 0};

        int sumt = left[0] + right[0] + root.val;
        ans = Math.max(ans, sumt);
        int mini = Math.min(left[2], root.val);
        int mxi = Math.max(right[3], root.val);
        
        return new int[]{sumt, 1, mini, mxi};
    }
}

// // WA #2
// // left's largest < root.val
// // right'smallest > root.val
//
// class Solution {
//     int ans = 0;
//     public int maxSumBST(TreeNode root) {
//         dfs(root);
//         return ans;
//     }
    
//     int[] dfs(TreeNode root){
//         if(root == null)
//             return new int[]{0, 1};
        
//         int[] left = dfs(root.left);
//         int[] right = dfs(root.right);
        
//         boolean isBST = left[1]==1 && right[1]==1 && 
//             (root.left==null || root.left.val < root.val) && 
//             (root.right==null || root.right.val > root.val);
        
//         if(!isBST)
//             return new int[]{Math.max(left[0], right[0]), 0};

//         int sumt = left[0] + right[0] + root.val;
//         ans = Math.max(ans, sumt);
//         return new int[]{sumt, 1};
//     }
// }


// // WA #1
//
// class Solution {
//     public int maxSumBST(TreeNode root) {
//         return dfs(root)[0];
//     }
    
//     int[] dfs(TreeNode root){
//         if(root == null)
//             return new int[]{0, 1};
        
//         int[] left = dfs(root.left);
//         int[] right = dfs(root.right);
        
//         boolean isBST = left[1]==1 && right[1]==1 && 
//             (root.left==null || root.left.val < root.val) && 
//             (root.right==null || root.right.val > root.val);
        
//         int mx = Math.max(left[0], right[0]);
        
//         if(isBST){
//             int sumt = left[0] + right[0] + root.val;
//             return new int[]{Math.max(sumt, mx), 1};
//         }
        
//         return new int[]{mx, 0};

//     }
// }


// wrong idea #1
//we ignored testcase where values are negative
//
// return bst ? new int[]{left[0] + right[0] + root.val, 1} : new int[]{Math.max(left[0], right[0]), 0};