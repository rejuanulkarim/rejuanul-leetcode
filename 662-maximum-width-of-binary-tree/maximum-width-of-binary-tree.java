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
    class NodeInfo{
        TreeNode node;
        int idx;
        NodeInfo(TreeNode node, int idx){
            this.node = node;
            this.idx =idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Deque<NodeInfo> q = new ArrayDeque<>();
        int res =0;
        q.add(new NodeInfo(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int f = q.peekFirst().idx;
            int l = q.peekLast().idx;
            res = Math.max(res,(l-f +1));
            for(int i=0;i<size;i++){
                NodeInfo nodeInfo = q.removeFirst();
                TreeNode node = nodeInfo.node;
                int idx = nodeInfo.idx;
                if(node.left != null) q.add(new NodeInfo(node.left,2*idx +1));
                if(node.right != null) q.add(new NodeInfo(node.right,2*idx +2));
            }
        }
        return res;
    }
}