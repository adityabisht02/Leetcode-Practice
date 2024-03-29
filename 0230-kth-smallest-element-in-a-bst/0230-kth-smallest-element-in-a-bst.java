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
    public void rec(TreeNode root,List<Integer> list){
        if(root==null){
            return ;
        }
        rec(root.left,list);
        list.add(root.val);
        rec(root.right,list);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list=new ArrayList<>();
        rec(root,list);
        
        
        return list.get(k-1);
        
    }
}