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
    /*
        Company Tags : Accolite, Amazon, Microsoft
     */
    int idx = 0;
    int[] pre , in ;
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        pre = preorder; 
        in = inorder;
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        return treeBuilder(0, n-1);
    }
    TreeNode treeBuilder(int start,int end){
        if(start > end) return null;
        int rootVal = pre[idx];
        int i = map.get(rootVal);
        idx++;
        TreeNode root = new TreeNode(rootVal);
        root.left = treeBuilder(start,i-1);
        root.right = treeBuilder(i+1,end);
        return root;
    }
}