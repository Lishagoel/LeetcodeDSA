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
    private int index = 0;
    private Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return array(preorder,0,preorder.length-1);
    }
    private TreeNode array(int[] preorder,int left, int right){
        if(left > right){
            return null;
        }
        int value = preorder[index++];
        TreeNode root = new TreeNode(value);
        root.left = array(preorder,left,map.get(value)-1);
        root.right = array(preorder,map.get(value)+1,right);
        return root;
    }
}