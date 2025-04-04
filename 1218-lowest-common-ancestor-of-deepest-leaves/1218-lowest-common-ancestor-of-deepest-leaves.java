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
    private class Pair{
        int depth;
        TreeNode root;
        Pair(int depth,TreeNode root){
            this.depth = depth;
            this.root = root;
        }
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).root;
    }
    private Pair dfs(TreeNode root){
        if(root == null){
            return new Pair(0,null);
        }
        Pair left = dfs(root.left);
        Pair right = dfs(root.right);
        if(left.depth > right.depth){
            return new Pair(left.depth+1,left.root);
        }
        else if(right.depth > left.depth){
            return new Pair(right.depth+1,right.root);
        }
        else{
            return new Pair(left.depth+1,root);
        }
    }
}