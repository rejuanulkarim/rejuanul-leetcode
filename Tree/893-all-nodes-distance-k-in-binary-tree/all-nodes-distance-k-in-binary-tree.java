/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    HashMap<TreeNode, TreeNode> map = new HashMap<>();

    void dfsMapUpdate(TreeNode node){
        if(node == null) return;
        if(node.left != null){
            map.put(node.left,node);
            dfsMapUpdate(node.left);
        }
        if(node.right != null){
            map.put(node.right,node);
            dfsMapUpdate(node.right);
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        dfsMapUpdate(root);

        HashSet<Integer> visited = new HashSet<>();

        Deque<TreeNode> q = new ArrayDeque<>();


        q.add(target);
        visited.add(target.val);
        while(!q.isEmpty() && k > 0){
            int size = q.size();
            while(size > 0){
                TreeNode node = q.pollFirst();
                if(node.left != null && !visited.contains(node.left.val)) {
                    q.addLast(node.left);
                    visited.add(node.left.val);
                }
                if(node.right != null && !visited.contains(node.right.val)) {
                    q.addLast(node.right);
                    visited.add(node.right.val);
                }
                if(map.containsKey(node) && !visited.contains(map.get(node).val)){
                    TreeNode temp = map.get(node);
                    q.addLast(temp);
                    visited.add(temp.val);
                }

                size-- ;
            }
            k--;
        }
        while(!q.isEmpty()){
            res.add(q.pollFirst().val);
        }
        return res;
    }
}