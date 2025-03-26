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
    private int index;
    private Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return array(postorder,0,inorder.length-1);
    }
    private TreeNode array(int[] postorder,int left,int right){
        if(left > right){
            return null;
        }
        int value = postorder[index--];
        TreeNode root = new TreeNode(value);
        root.right = array(postorder,map.get(value)+1,right);
        root.left = array(postorder,left,map.get(value)-1);
        return root;
    }
}