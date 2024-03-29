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
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> s=new Stack();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode current=s.pop();
            ans.add(current.val);
            if(current.left!=null){
                s.push(current.left);
            }
            if(current.right!=null){
                s.push(current.right);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}