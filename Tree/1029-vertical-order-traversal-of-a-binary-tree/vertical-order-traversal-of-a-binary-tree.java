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

 /*
class Solution {
    HashMap<Integer,List<int[]>> map = new HashMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        bfsTraversal(root);
        ArrayList<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        List<List<Integer>> list = new ArrayList<>();
        for(Integer i: keySet){
            List<Integer> valList= new ArrayList<>();
            List<int[]> arrList = map.get(i); 
            Collections.sort(arrList,(a,b)->{
                if(a[0]==b[0]) return a[1]-b[1];
                return a[0]-b[0];
            });
            for(int[] arr:arrList){
                valList.add(arr[1]);
            }
            list.add(valList);
        }
        return list;
    }
    void bfsTraversal(TreeNode root){
        Deque<NodeInfo> q = new ArrayDeque<>();
        q.add(new NodeInfo(root,0,0));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                NodeInfo info = q.remove();
                TreeNode node = info.node;
                int row = info.row, col = info.col;
                map.computeIfAbsent(col,k-> new ArrayList<>()).add(new int[]{row,node.val});
                if(node.left != null) q.add(new NodeInfo(node.left,row+1,col-1));
                if(node.right != null) q.add(new NodeInfo(node.right,row+1,col+1));
            }
        }
        
    }
    class NodeInfo{
        TreeNode node;
        int row;
        int col;
        NodeInfo(TreeNode node,int row,int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
}
*/


class Solution {

    // Global min heap
    // Priority:
    // 1. Smaller column first
    // 2. If same column -> smaller row first
    // 3. If same row + column -> smaller value first
    PriorityQueue<NodeInfo> pq = new PriorityQueue<>((a,b)->{
        if(a.col == b.col){

            // same column → compare rows
            if(a.row == b.row)

                // same row+col → smaller value first
                return a.val - b.val;

            return a.row - b.row;
        }

        // smaller column first
        return a.col - b.col;
    });

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // edge case
        if(root == null)
            return new ArrayList<>();

        // DFS traversal:
        // collect every node with row,col info
        traversal(root,0,0);

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> arrList = new ArrayList<>();

        // first column of heap
        int preCol = pq.peek().col;

        // add first element
        arrList.add(pq.remove().val);

        while(!pq.isEmpty()){

            // look at next node's column
            int col = pq.peek().col;

            // same vertical column
            if(preCol == col){

                arrList.add(pq.remove().val);

            }else{

                // new column starts
                list.add(arrList);

                arrList = new ArrayList<>();

                arrList.add(pq.remove().val);

                preCol = col;
            }
        }

        // add last column
        list.add(arrList);

        return list;
    }

    void traversal(TreeNode node,int row,int col){

        // DFS base case
        if(node == null)
            return;

        // store node with coordinates
        pq.add(new NodeInfo(node,row,col));

        // left -> row+1,col-1
        traversal(node.left,row+1,col-1);

        // right -> row+1,col+1
        traversal(node.right,row+1,col+1);
    }

    class NodeInfo{

        TreeNode node;

        int row,col,val;

        NodeInfo(TreeNode node,int row,int col){

            this.node=node;

            this.row=row;

            this.col=col;

            this.val=node.val;
        }
    }
}
