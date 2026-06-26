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
    HashMap<Integer,Integer> map = new HashMap<>();
    int idx ;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        if(n == 1) return new TreeNode(inorder[0]);
        idx = n-1;
        for(int i =0;i<n;i++){
            map.put(inorder[i],i);
        }
        return TreeBuilder(inorder,postorder,0,n-1);
    }
    TreeNode TreeBuilder(int[] in, int[] post,int start,int end){
        if(start>end) return null;
        TreeNode root = new TreeNode(post[idx--]); // after root value idx = idx-1.
        int inIdx = map.get(root.val);
        root.right = TreeBuilder(in,post,inIdx+1, end);
        root.left = TreeBuilder(in,post,start,inIdx-1);
        return root;
    }
}