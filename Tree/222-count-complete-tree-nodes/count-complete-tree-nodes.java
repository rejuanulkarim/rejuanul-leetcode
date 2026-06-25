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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left = leftDepth(root);
        int right = rightDepth(root);
        if(left == right) return (1 << left)-1;
        return countNodes(root.left) +1+ countNodes(root.right);
    }
    int leftDepth(TreeNode node){
        int count =0;
        while(node != null){
            count++;
            node = node.left;
        }
        return count;
    }
    int rightDepth(TreeNode node){
         int count =0;
        while(node != null){
            count++;
            node = node.right;
        }
        return count;
    }
}