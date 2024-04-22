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
    public TreeNode buildTree(int[] pre, int[] ino) {
        return build(0, pre.length-1, 0, ino.length-1, pre, ino);
    }
    TreeNode build(int preI, int preJ, int inoI, int inoJ, int[] pre, int[] ino){
        if(preI > preJ || inoI > inoJ) return null;
        TreeNode node = new TreeNode(pre[preI]);
        int rootIno = -1;
        for(int x=inoI; x<=inoJ; ++x){
            if(pre[preI] == ino[x]) rootIno = x;
        }
        int nodeInLeft = rootIno - inoI;
        node.left = build(preI+1, preI+nodeInLeft, inoI, rootIno-1, pre, ino);
        node.right = build(preI+nodeInLeft+1, preJ, rootIno+1, inoJ, pre, ino);
        return node;
    }
}